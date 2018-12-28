package com.csh.ada.controller;

import com.csh.ada.pojo.AdaBC;
import com.csh.ada.pojo.AdaResult;
import com.csh.ada.pojo.AiTalkBean;
import com.csh.ada.service.IBCService;
import com.csh.ada.service.impl.WxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/wx")
public class WxController {

    @Autowired
    private IBCService iBCService;
    @Value("${ada.TOKEN}")
    private String TOKEN;
    //微信公众号
    @Value("${ada.APPID}")
    private String APPID;
    @Value("${ada.APPSECRET}")
    private String APPSECRET;
    //@Value("${ada.Port}")
    //private String adaPort;
    //@Value("${ada.IP}")
    //private String adaIP;
    //默认code
    //@Value("${ada.Code}")
    //private int code;
    //调用第三方的uid
   // private String uid = null;
    /**
     * 测试公众号连接成功或者失败
     * @return
     */
    @GetMapping("/message")
    public String getTest(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf8");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        //校验证签名
        if(WxService.check(TOKEN,timestamp,nonce,signature)) {
            log.info("接入成功");
            log.info("signature:"+signature);
            log.info("echostr:"+echostr);
            return echostr;
        }else {
            log.info("接入失败，签名校验不通过");
            log.info("signature:"+signature);
            log.info("echostr:"+echostr);
            return null;
        }
    }

    /**
     * 接收公众号xml请求
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST, consumes = { "text/xml" }, produces = { "application/xml" })
    @ResponseBody
    public Object wxMessage(HttpServletRequest request)throws IOException{
        //处理消息和事件推送
        Map<String, String> requestMap = WxService.parseRequest(request.getInputStream());
        System.out.println(requestMap);
        AdaResult<AdaBC> adaResult = iBCService.adaSelect(requestMap.get("ToUserName"));
        if (adaResult.getState()!=200){
            //查询不到这个数据
            log.info("查询不到这个开发者微信号,请先在后台配置该微信账号："+requestMap.get("ToUserName"));
            return "success";
        }
        //code = adaResult.getData().getAdacode();
       // uid = adaResult.getData().getAdauid();
        //log.info("uid为"+uid);
        if (null==adaResult.getData().getAdauid() || "".equals(adaResult.getData().getAdauid())){
            //第一次请求要初始化
            String adaUid = WxService.getUid(adaResult.getData().getAdaip(),adaResult.getData().getAdaport(),adaResult.getData().getAdacode());
            if (null==adaUid || "".equals(adaUid)){
                return "success";
            }
            adaResult = iBCService.adaChangeUid(adaResult.getData().getAdaid(), adaUid);
            if (adaResult.getState()!=200){
                log.info("更新uid失败");
                return "success";
            }

        }
        String speak = WxService.getContent(requestMap);
        if (null==speak ){
            //可能用户使用图片或者位置什么，并非语音或者文字
            System.out.println("不会做出回复，可能用户使用图片或者位置什么");
            return "success";
        }
        AiTalkBean aiTalkBean = WxService.aiTalk(adaResult.getData().getAdaip(),adaResult.getData().getAdaport(), adaResult.getData().getAdacode(), adaResult.getData().getAdauid(),speak );

        //如果请求回来是uid过期，重试一次
        if (!aiTalkBean.getUstatus().equals("0")){
            String adaUid = WxService.getUid(adaResult.getData().getAdaip(),adaResult.getData().getAdaport(),adaResult.getData().getAdacode());
            if (null==adaUid || "".equals(adaUid)){
                return "success";
            }
            adaResult = iBCService.adaChangeUid(adaResult.getData().getAdaid(), adaUid);
            if (adaResult.getState()!=200){
                log.info("更新uid失败");
                return "success";
            }
            aiTalkBean = WxService.aiTalk(adaResult.getData().getAdaip(),adaResult.getData().getAdaport(), adaResult.getData().getAdacode(), adaResult.getData().getAdauid(),speak );
        }

        //准备回复的数据包
        String respXml = WxService.getRespose(adaResult.getData().getAdaip(),adaResult.getData().getAdaport(),aiTalkBean,requestMap);
        if (null==respXml){
            //可能用户使用图片或者位置什么，并非语音或者文字
            return "success";
        }
        return respXml;
    }


}
