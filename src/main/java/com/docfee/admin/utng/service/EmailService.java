package com.docfee.admin.utng.service;
import com.docfee.admin.utng.util.TokenTwilio;
import com.sendgrid.*;
import java.io.IOException;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

    public void enviarEmail(String para, String motivo, String contenido)throws IOException {
        
            Email from = new Email("topd001130@gmail.com");
            String subject = motivo;
            Email to = new Email(para);
            Content content = new Content("text/plain", contenido);
            Mail mail = new Mail(from, subject, to, content);
        
            SendGrid sg = new SendGrid(TokenTwilio.SENDGRID_API_KEY);
            Request request = new Request();
            try {
              request.setMethod(Method.POST);
              request.setEndpoint("mail/send");
              request.setBody(mail.build());
              Response response = sg.api(request);
              System.out.println(response.getStatusCode());
              System.out.println(response.getBody());
              System.out.println(response.getHeaders());
            } catch (IOException ex) {
              throw ex;
            }
    }

}
