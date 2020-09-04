package com.make.common;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/9/3
 * Description:
 */
public class EmailTool {
    public static void sendEmail(String to, String subject, String content) throws MessagingException, IOException {
        // 163邮箱 smtp服务配置
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.port", "25");

        //发送邮箱认证
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dengwenxingae86@163.com", "JTSPMIWTGUJDLBIK");
            }
        });
        Message msg = new MimeMessage(session);
        //设置发件人地址
        msg.setFrom(new InternetAddress("dengwenxingae86@163.com", false));
        //设置收件人地址
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        //设置邮件标题
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        //邮件正文设置 防止中文乱码
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(content, "text/html;charset=UTF-8");

        //多个附件发送
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();
        MimeBodyPart attachPart1 = new MimeBodyPart();

        attachPart.attachFile("E:\\idea_workspace\\spring_demo\\upload_data\\all_dict2.txt");
        attachPart1.attachFile("E:\\idea_workspace\\spring_demo\\upload_data\\Base64Utils.java");
        multipart.addBodyPart(attachPart);
        multipart.addBodyPart(attachPart1);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}
