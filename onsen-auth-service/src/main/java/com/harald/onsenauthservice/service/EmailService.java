package com.harald.onsenauthservice.service;


import com.harald.onsenauthservice.context.AbstractEmailContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    //
//     private final JavaMailSender emailSender;
//
    // if you want to use Thymeleaf to create a email formatted
//     private final SpringTemplateEngine templateEngine;
//

    // throws MessagingException
    void sendEmail(AbstractEmailContext email) throws RuntimeException {
//     MimeMessage message = emailSender.createMimeMessage();
//     MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
//             MessageHelper.MULTIPART_MODE_MIXED_RELATED,
//             StandardCharsets.UTF_8.name());
//     Context context = new Context();
//     context.setVariables(email.getContext());
//     String emailContent = email.getContent();;
//
//     mimeMessageHelper.setTo(email.getTo());
//     mimeMessageHelper.setSubject(email.getSubject());
//     mimeMessageHelper.setFrom(email.getFrom());
//     mimeMessageHelper.setText(emailContent, true);
//
//     emailSender.send(message)
//
    }

}
