//package com.system.recipe_app.contoller;
//
//import com.system.recipe_app.entity.User;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//
//
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.Map;
//
//public class emailSent {
//
//    @Autowired
//    @Qualifier("emailConfigBean")
//    private Configuration EmailConfig;
//
//    private  final JavaMailSender getJavaMailSender;
//
//    public emailSent(JavaMailSender getJavaMailSender) {
//        this.getJavaMailSender = getJavaMailSender;
//    }
//
//    public void sendResetEmail(User user) throws Exception {
//        try {
//            MimeMessage message = getJavaMailSender.createMimeMessage();
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
//                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
//            Template template = EmailConfig.getTemplate("emailTemp.ftl");
//            Map<String, String> model=new HashMap<>();
//            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
//            mimeMessageHelper.setTo("testabc@yopmail.com");
//            mimeMessageHelper.setText(html, true);
//            mimeMessageHelper.setSubject("for notification");
//            mimeMessageHelper.setFrom("no-reply@text.com.np");
//
//            getJavaMailSender.send(message);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        }
//    }
//
//}
