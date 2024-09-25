package com.dosoar.email_security_demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.dosoar.email_security_demo.model.dto.EmailDto;
import org.apache.commons.mail.util.MimeMessageParser;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailUtils {
    public static EmailDto parseEml(String path) {
        EmailDto emailDto = new EmailDto();
        try (InputStream inputStream = new FileInputStream(path)) {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage msg = new MimeMessage(session, inputStream);
            MimeMessageParser parser = new MimeMessageParser(msg).parse();
            //发件人
            String from = parser.getFrom();
            emailDto.setSenders(from);
            //收件人列表
            List<Address> toArray = parser.getTo();
            StringBuilder recipients = new StringBuilder();
            boolean flag = true;
            for (Address address : toArray) {
                if (flag) {
                    flag = false;
                } else {
                    recipients.append(", ");
                }
                recipients.append(address.toString());
            }
            emailDto.setRecipients(recipients.toString());
            //邮件发送时间
            Date sendDate = parser.getMimeMessage().getSentDate();
            emailDto.setSendDate(sendDate);
            //邮件主题
            String subject = parser.getSubject();
            emailDto.setTile(subject);
            //邮件内容
            String content = msg.getContent().toString();
            emailDto.setContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emailDto;
    }

    public static void main(String[] args) {
        String path = "E:\\work\\Dosoar\\project\\EmailSecurity\\test\\eml\\003.eml";
        EmailDto emailDto = parseEml(path);
        System.out.println(JSONObject.toJSONString(emailDto));
    }
}
