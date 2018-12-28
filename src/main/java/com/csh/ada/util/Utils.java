package com.csh.ada.util;

import com.csh.ada.controller.WxController;
import com.csh.ada.pojo.InitBean;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Utils {



    /**
     * 初始化机器人，获得uid
     * @param code
     * @return
     */
    private static InitBean initOTalk(int code) {
        String result =null;
        String url ="http://123.57.67.197:8080/OTalkApi/init?code="+code;//请求接口地址
        try {
            result =get(url);
            //解析json
            JSONObject jsonObject = JSONObject.fromObject(result);
            InitBean initBean = (InitBean) JSONObject.toBean(jsonObject, InitBean.class);
            //取出返回的消息的内容
            System.out.println(result);
            return initBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 得到回复的信息
     * @param code
     * @param uid
     * @param word
     * @return
     */
    public static String aiTalk(int code,String uid,String word) {
        try {
            String result =null;
            String url ="http://123.57.67.197:8080/OTalkApi/aitalk?&code="+code+"&uid="+uid+"&Say="+ URLEncoder.encode(word , "UTF-8");
            result =get(url);
            //解析json
            //JSONObject jsonObject = JSONObject.fromObject(result);
            //InitBean initBean = (InitBean) JSONObject.toBean(jsonObject, InitBean.class);
            //取出返回的消息的内容
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向指定的地址发送一个post请求，带着data数据
     *
     * @param url
     * @param data
     */
    public static String post(String url, String data) {
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            // 要发送数据出去，必须要设置为可发送数据状态
            connection.setDoOutput(true);
            // 获取输出流
            OutputStream os = connection.getOutputStream();
            // 写出数据
            os.write(data.getBytes());
            os.close();
            // 获取输入流
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向指定的地址发送get请求
     *
     * @param url
     */
    public static String get(String url) {
        try {
            URL urlObj = new URL(url);
            // 开连接
            URLConnection connection = urlObj.openConnection();
            //获取返回流
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line="";
            while ((line=in.readLine())!=null){
                line = new String(line.getBytes("UTF-8"),"UTF-8");
                result += line;
            }
            System.out.println("请求返回结果get："+result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
