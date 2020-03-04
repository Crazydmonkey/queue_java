package com.briup.queue.qcheck.utils;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

public class JsonMessage {
    public static  JSONObject JsonMsg(){
        JSONObject json = new JSONObject();
        try {
            JSONObject jsonFirst = new JSONObject();
            jsonFirst.put("value", "xxxx");
            jsonFirst.put("color", "#173177");
            json.put("first", jsonFirst);
            /**
             * 信息部分JSON
             */
            JSONObject k1 = new JSONObject();
            k1.put("value","hello");
            k1.put("color", "#173177");
            json.put("keyword1", k1);
            JSONObject k2 = new JSONObject();
            k2.put("value","aaa");
            k2.put("color", "#173177");
            json.put("keyword2", k2);
            //具体模板消息有几个参数就写几个 可查看小程序后台模板消息
            JSONObject jsonRemark = new JSONObject();
            jsonRemark.put("value", "xxxxx");
            jsonRemark.put("color", "#173177");
            json.put("Remark", jsonRemark);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
    public String sendWechatmsgToUser(){
        String tmpurl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";
        //公众号的发送模板消息连接是：https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=accessToken换成自己公众号的就好
        String accessToken="";//获取的accessToken 有效期为2小时 可以存储在库中，定时更新
        JSONObject json = new JSONObject();
        try {
            json.put("touser", openId);//所要发送的用户openId
            json.put("template_id", "xxx小程序后台的模板Id");
            json.put("page", "pages/index/index");//点击模板可以跳转到小程序的具体界面
            json.put("form_id", formId);//用户的fromId或者预订单Id
            json.put("topcolor", "#173177");
            json.put("data", data);//这个data可以直接调用上文的JsonMsg方法生成所需要发送给用户的信息
        } catch (JSONException e) {
            e.printStackTrace();
        }
/*
	公众号模板消息在发送给微信服务器的信息和小程序有一些不一样
	json.put("miniprogram", “此处json对象中放入小程序的appid和具体界面地址如：pages/index/index 点击模板消息是可以直接进入小程序”);
	json.put("url", "此处填写的url可以跳转到需要连接的地址，如果是支付的模板消息就可以跳转到该用户的支付详情");

*/
        //http带上json文件发起请求百度一下很多 下文也放一个
        String result = httpsRequest(url, "POST", json.toString());
        try {
            JSONObject resultJson = JSON.parseObject(result);
            System.out.println("模板消息返回数据:"+resultJson);
            String errmsg = (String) resultJson.get("errmsg");
            if(!"ok".equals(errmsg)){  //如果为errmsg为ok，则代表发送成功，公众号推送信息给用户了。
                return "error";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "success";
    }
    public  String httpsRequest(String requestUrl, String requestMethod, String outputStr){
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            System.out.println("连接超时：{}");
        } catch (Exception e) {
            System.out.println("https请求异常：{}");
        }
        return null;
    }
}
