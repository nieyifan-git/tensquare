package com.tensquare.user.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tensquare.common.util.IdWorker;
import com.tensquare.user.dao.UserRepository;
import com.tensquare.user.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author nieyifan
 * @createTime 2019/12/26 11:40
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    IdWorker idWorker;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    /*
    * 发送短信验证码
    * @param mobile 手机号
    * */
    public void sendSms(String mobile){
        //生成6位数验证码
        Random random = new Random();
        int max = 999999;
        int min = 100000;
        int code = random.nextInt(max);
        if(code < min){
            code += min;
        }
       log.info(mobile + "收到的短信验证：" + code);
        //验证码存到redis
        redisTemplate.opsForValue().set("smscode_" + mobile, code + "", 5, TimeUnit.MINUTES);
        //将验证码和手机号发到rabbitMq中
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("code",code+"");
        rabbitTemplate.convertAndSend("sms",map);
    }

    /*
    *增加用户
    * */
    public void addUser(User user, String code){
        String syscode = (String) redisTemplate.opsForValue().get("smscode_" + user.getMobile());
        if(syscode == null ){
            throw new RuntimeException("请点击获取验证码");
        }
        if(!syscode.equals(code)){
            throw new RuntimeException("请输入正确的验证码");
        }
        user.setId(idWorker.nextId()+"");
        user.setPassword(encoder.encode(user.getPassword()));
        user.setFollowCount(0);
        user.setFansCount(0);
        user.setOnLine(0L);
        user.setRegDate(new Date());
        user.setUpdateDate(new Date());
        user.setLastLoginDate(new Date());
        userRepository.save(user);

    }

    public User login(Map<String, String> map) {
        String userName = map.get("userName");
        User byUserName = userRepository.findByUserName(userName);
        if(byUserName != null && encoder.matches(map.get("password"), byUserName.getPassword())){
            return byUserName;
        }
        return null;
    }
}
