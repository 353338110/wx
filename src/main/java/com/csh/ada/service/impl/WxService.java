package com.csh.ada.service.impl;

import com.csh.ada.pojo.*;
import com.csh.ada.util.Utils;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Slf4j
public class WxService {
    /**
     * 验证签名
     *
     * @param TOKEN
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public static boolean check(String TOKEN, String timestamp, String nonce, String signature) {
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(strs);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0] + strs[1] + strs[2];
        String mysig = sha1(str);
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return mysig.equalsIgnoreCase(signature);
    }

    /**
     * 进行sha1加密
     *
     * @param
     * @return
     */
    private static String sha1(String src) {
        try {
            //获取一个加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(src.getBytes());
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for (byte b : digest) {
                sb.append(chars[(b >> 4) & 15]);
                sb.append(chars[b & 15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUid(String adaIP, String adaPort, int code) {
        InitBean initBean = initOTalk(adaIP, adaPort, code);
        if (null!=initBean && initBean.getUstatus()==0){
            log.info("code为"+code+"获得的uid为"+initBean.getUid());
            return initBean.getUid();
        }else {
            return null;
        }

    }

    private static InitBean initOTalk(String adaIP, String adaPort, int code) {
        String result = null;
        //String url = "http://123.57.67.197:9000/OTalkApi/init?code=" + code;//请求接口地址
        String url = adaIP + ":" + adaPort + "/OTalkApi/init?code=" + code;//请求接口地址
        log.info("初始化uid的url:" + url);
        try {
            result = Utils.get(url);
            log.info("/OTalkApi/init 消息：" + result);
            //解析json
            JSONObject jsonObject = JSONObject.fromObject(result);
            InitBean initBean = (InitBean) JSONObject.toBean(jsonObject, InitBean.class);
            if (initBean.getUstatus() != 0) {
                log.info("/OTalkApi/init 请求失败，失败消息：" + initBean.getInfo());
                return null;
            }
            return initBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static AiTalkBean aiTalk(String adaIP, String adaPort, int code, String uid, String word) {
        try {
            log.info("转化后文字" + URLEncoder.encode(word, "UTF-8"));
            String result = null;
            //String url = "http://123.57.67.197:9000/OTalkApi/aitalk?code=" + code + "&uid=" + uid + "&Say=" + URLEncoder.encode(word, "UTF-8");
            String url = adaIP + ":" + adaPort + "/OTalkApi/aitalk?&code=" + code + "&uid=" + uid + "&Say=" + URLEncoder.encode(word, "UTF-8");
            log.info("aiTalk的url" + url);
            result = Utils.get(url);

            //解析json
            JSONObject jsonObject = JSONObject.fromObject(result);
            Map classMap = new HashMap();
            classMap.put("attr", AiTalkBean.AttrBean.class);
            AiTalkBean aiTalkBean = (AiTalkBean) JSONObject.toBean(jsonObject, AiTalkBean.class, classMap);
            //取出返回的消息的内容
            if (!aiTalkBean.getUstatus().equals("0")) {
                log.info("/OTalkApi/aitalk 返回错误" + aiTalkBean.getInfo());
            }
            System.out.println(result);
            return aiTalkBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析xml数据包
     *
     * @param is
     * @return
     */
    public static Map<String, String> parseRequest(InputStream is) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            //读取输入流，获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取根节点
            Element root = document.getRootElement();
            //获取根节点的所有的子节点
            List<Element> elements = root.elements();
            for (Element e : elements) {
                map.put(e.getName(), e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 用于处理所有的事件和消息的回复
     *
     * @return 返回的是xml数据包
     */
    public static String getRespose(String adaIP,String adaPort,AiTalkBean aiTalkBean, Map<String, String> requestMap) {
        BaseMessage msg = null;
        String link = "";
        if (aiTalkBean.getUstatus().equals("0")) {
            //有attr属性，说明并给普通文本属性
            //目前只有文本属性跟图文属性，图文属性plustype为imgmsg
            if (null != aiTalkBean.getAttr() && !"".equals(aiTalkBean.getAttr())) {
                List<Article> articles = new ArrayList<>();
                for (int i = 0; i < aiTalkBean.getAttr().size(); i++) {
                    //获取超链接
                    if (null != aiTalkBean.getAttr().get(i)
                            && null != aiTalkBean.getAttr().get(i).getPlusmsg()
                            && !"".equals(aiTalkBean.getAttr().get(i).getPlusmsg())){
                        link = aiTalkBean.getAttr().get(i).getPlusmsg().substring(5);

                    }
                }
                for (int i = 0; i < aiTalkBean.getAttr().size(); i++) {
                    //判断是否为图文属性
                    if (null != aiTalkBean.getAttr().get(i)
                            && null != aiTalkBean.getAttr().get(i).getPlustype()
                            && "imgmsg".equals(aiTalkBean.getAttr().get(i).getPlustype())) {
                        String picURL =adaIP + ":" + adaPort + aiTalkBean.getAttr().get(i).getPlusurl();
                        log.info("图片地址:"+ picURL);
                        articles.add(new Article(aiTalkBean.getAttr().get(i).getPlustitle(), "", picURL, link));
                    }
                }
                if (articles.size() > 0) {
                    msg = new NewsMessage(requestMap, articles);
                }else {
                    if (!"".equals(link)){
                        link = "<a href=\""+link+"?love"+"\">点击阅读全文</a>";
                    }
                    msg = new TextMessage(requestMap, aiTalkBean.getAnswer()+link+analysisAnswerLink(aiTalkBean.getAnswer_link()));
                   // msg = new TextMessage(requestMap, link);
                }

            } else {
                msg = new TextMessage(requestMap, aiTalkBean.getAnswer()+analysisAnswerLink(aiTalkBean.getAnswer_link()));
            }

        }
        //把消息对象处理为xml数据包
        if (msg != null) {
            return beanToXml(msg);
        }
        return null;
    }

    public static String getContent(Map<String, String> requestMap) {
        String msg = null;
        String msgType = requestMap.get("MsgType");
        switch (msgType) {
            //处理文本消息
            case "text":
                msg = requestMap.get("Content");
                break;
            case "image":
                break;
            case "voice":
                msg = requestMap.get("Recognition");
                break;
            case "video":
                break;
            case "shortvideo":
                break;
            case "location":
                break;
            case "link":
                break;
            case "event":
                break;
            default:
                break;
        }
        return msg;
    }

    /**
     * 把消息对象处理为xml数据包
     *
     * @param msg
     * @return
     */
    private static String beanToXml(BaseMessage msg) {
        XStream stream = new XStream();
        //设置需要处理XStreamAlias("xml")注释的类
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        String xml = stream.toXML(msg);
        return xml;
    }

    private static String analysisAnswerLink(List<String> answer_link){
        if (null==answer_link || answer_link.size()<=0){
            return "";
        }
        String answerLink = "\n";
        for (int i = 0; i < answer_link.size(); i++) {
            int position = answer_link.get(i).indexOf(">")+1;
            int sunCount = answer_link.get(i).length();
            String temp ="["+String.valueOf(i+1)+"]"+ answer_link.get(i).substring(position,sunCount-10)+"\n";
            answerLink = answerLink+temp;
        }

        return answerLink;
    }
}
