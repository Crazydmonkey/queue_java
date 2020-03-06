package com.briup.queue.qcheck.web.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;
import com.briup.queue.qcheck.bean.entity.*;
import com.briup.queue.qcheck.utils.Util;
import com.briup.queue.qcheck.utils.WxService;
import com.thoughtworks.xstream.XStream;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;
import org.json.JSONException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Api(description = "VIP业务相关接口")
@Validated
@RestController
@RequestMapping("/test")
public class TemplateMessageController {

    public static final String APP_ID = "11519092";
    public static final String API_KEY = "q3TlGWWqEBG9uGvlFIBtpvY5";
    public static final String SECRET_KEY = "A14W5VRNG8my1GXYYAyNND0RjzBwxI8A";

    @GetMapping("testGetUserInfo")
    public void testGetUserInfo(@RequestParam String openid) {
        System.out.println(openid);
        String user=openid;
        String info = WxService.getUserInfo(user);
        JSONObject jsonObject = JSONObject.fromObject(info);
        UserInfo parse = JSON.parseObject(info,UserInfo.class);
        System.out.println(parse.toString());
    }
    @GetMapping("allCustomer")
    public void allCustomer() {
        String ticket = WxService.findAll();
        System.out.println(ticket);
    }
    @GetMapping("testQrCode")
    public void testQrCode() {
        String ticket = WxService.getQrCodeTicket();
        System.out.println(ticket);
    }
    @GetMapping("testUpload")
        public void testUpload() {
        String file = "D:\\job\\排队叫号\\queue_number\\images\\20200302.jpg";
        String result = WxService.upload(file, "image");
        System.out.println(result);
        //TLfodwngsUr9rjHdITKiB9uT4Dq7K-QnV00MVd3_U6LnZeAqpZl3vYIICjUq48BY
    }
    @GetMapping("testPic")
    public void testPic() throws JSONException {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "/Users／Richard/Documents/2.png";
        org.json.JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
    }
    @GetMapping("testButton")
    public void testButton() {
        // 菜单对象
        Button btn = new Button();
        // 第一个一级菜单
        btn.getButton().add(new ClickButton("一级点击", "1"));
        // 第二个一级菜单
        btn.getButton().add(new ViewButton("一级跳转", "http://www.baidu.com"));
        // 创建第三个一级菜单
        SubButton sb = new SubButton("有子菜单");
        // 为第三个一级菜单增加子菜单
        sb.getSub_button().add(new PhotoOrAlbumButton("传图", "31"));
        sb.getSub_button().add(new ClickButton("点击", "32"));
        sb.getSub_button().add(new ViewButton("网易新闻", "http://news.163.com"));
        // 加入第三个一级菜单
        btn.getButton().add(sb);
        // 转为json
        JSONObject jsonObject = JSONObject.fromObject(btn);
        System.out.println(jsonObject.toString());
    }

    @GetMapping("testToken")
    public void testToken() {
        System.out.println(WxService.getAccessToken());
        System.out.println(WxService.getAccessToken());
    }

    @GetMapping("testMsg")
    public void testMsg() {
        Map<String, String> map = new HashMap<>();
        map.put("ToUserName", "to");
        map.put("FromUserName", "from");
        map.put("MsgType", "type");
        TextMessage tm = new TextMessage(map, "还好");
        XStream stream = new XStream();
        // 设置需要处理XStreamAlias("xml")注释的类
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        String xml = stream.toXML(tm);
        System.out.println(xml);

    }
    @GetMapping("set")
    public void set() {
        String at = WxService.getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token="+at;
        String data="{\n" +
                "          \"industry_id1\":\"1\",\n" +
                "          \"industry_id2\":\"4\"\n" +
                "       }";
        String result = Util.post(url, data);
        System.out.println(result);
    }

    /**
     * 获取行业
     * by 罗召勇 Q群193557337
     */
    @GetMapping("get")
    public void get() {
        String at = WxService.getAccessToken();
        String url="https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token="+at;
        String result = Util.get(url);
        System.out.println(result);
    }

    /**
     * 发送模板消息
     * by 罗召勇 Q群193557337
     */
    @GetMapping("sendTemplateMessage")
    public void sendTemplateMessage() {
        String at = WxService.getAccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at;
        String data="{\n" +
                "           \"touser\":\"oGNEkuNarNPIvM53ZlhGeqyfy2JI\",\n" +
                "           \"template_id\":\"-nELZnrYXmXoHBEvTK9HTECfZhnThMEoLIIVQkAkZp0\",         \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"排队已到您！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"phrase1\":{\n" +
                "                       \"value\":\"个人业务\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"character_string\": {\n" +
                "                       \"value\":\"001\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"phrase3\": {\n" +
                "                       \"value\":\"尽快办理\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"thing4\":{\n" +
                "                       \"value\":\"内蒙古！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result = Util.post(url, data);
        System.out.println(result);
    }
}
