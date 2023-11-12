package top.sharehome.share_study_mail.service;

import com.alibaba.fastjson2.JSONObject;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import top.sharehome.share_study_mail.utils.EmailUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

/**
 * MQ 邮件监听者
 *
 * @author AntonyCheng
 */
@Component
@Slf4j
public class MailService {
    /**
     * 注入发送邮件的接口
     */
    @Resource
    private EmailUtil emailUtil;
    public static final String MAIL_QUEUE = "mailQueue";

    @RabbitHandler
    @RabbitListener(queues = MailService.MAIL_QUEUE)
    public void mailMQ1(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String to = (String) rabbitResult.get("to");
            String subject = (String) rabbitResult.get("subject");
            String content = (String) rabbitResult.get("content");
            emailUtil.sendHtmlMail(to, subject, content);
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = MailService.MAIL_QUEUE)
    public void mailMQ2(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String to = (String) rabbitResult.get("to");
            String subject = (String) rabbitResult.get("subject");
            String content = (String) rabbitResult.get("content");
            emailUtil.sendHtmlMail(to, subject, content);
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = MailService.MAIL_QUEUE)
    public void mailMQ3(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String to = (String) rabbitResult.get("to");
            String subject = (String) rabbitResult.get("subject");
            String content = (String) rabbitResult.get("content");
            emailUtil.sendHtmlMail(to, subject, content);
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = MailService.MAIL_QUEUE)
    public void mailMQ4(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String to = (String) rabbitResult.get("to");
            String subject = (String) rabbitResult.get("subject");
            String content = (String) rabbitResult.get("content");
            emailUtil.sendHtmlMail(to, subject, content);
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = MailService.MAIL_QUEUE)
    public void mailMQ5(Message message, Channel channel) {
        long deliveryTag = 0;
        try {
            HashMap<String, Object> rabbitResult = JSONObject.parseObject(new String(message.getBody()));
            String to = (String) rabbitResult.get("to");
            String subject = (String) rabbitResult.get("subject");
            String content = (String) rabbitResult.get("content");
            emailUtil.sendHtmlMail(to, subject, content);
            deliveryTag = message.getMessageProperties().getDeliveryTag();
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                channel.basicNack(deliveryTag, true, true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
