package com.tensquare.sms.common;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author nieyifan
 * @createTime 2019/12/26 14:41
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    /*
    * 发送短信
    * */
    @RabbitHandler
    public void sendSms(Map<String,String> message){
        System.out.println("手机号: " + message.get("mobile"));
        System.out.println("验证码： " + message.get("code"));
        //todo 阿里大于短信api
    }

}
