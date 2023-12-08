package com.docfee.admin.utng.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.model.Mensaje;
import com.docfee.admin.utng.model.Usuario;
import com.docfee.admin.utng.util.TokenTwilio;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class MensajeService implements IMensajeService{
    
    @Autowired
    private IUsuarioService usuarioService; 

    @Override
    public Message mensajeWhastapp(Mensaje user) {
        Twilio.init(TokenTwilio.ACCOUNT_SID, TokenTwilio.AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+521"+user.getNumero()), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                user.getMensaje())      
            .create(); 
        
        return message;
    }

    @Override
    public Message mensajeSms(Usuario user) {
        
        Twilio.init(TokenTwilio.ACCOUNT_SID, TokenTwilio.AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+521"+user.getTelefono()),  
                "MGc7ea64c190862f195462bd880ccd37d8", 
                "Toma tu medicamento 😡😡")      
            .create(); 
 
        return message;
    }
    
    @Override
    public void correo(Mensaje mensaje) throws IOException {
        
//        Usuario usuario=usuarioService.findById(mensaje.getIdUsuario());
        
        Email from = new Email("ddocfee@gmail.com");
        String subject = "Código de verificación";
        Email to = new Email(mensaje.getCorreo());
        Content content = new Content("text/plain", "Estimado/a "+mensaje.getNombreUsuario()+"."
                + "\n\nEste es tu código de autenticación en dos pasos: "+mensaje.getMensaje()
                + "\n\nPor favor, ingresa este código en la aplicación para completar el proceso de inicio de sesión."
                + "\n\nAtentamente,\nEl equipo de Docfee");
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
    
    @Override
    public Message mensajeAutenticacion(Mensaje mensaje) {
        
        Usuario usuario=usuarioService.findById(mensaje.getIdUsuario());
        
        Twilio.init(TokenTwilio.ACCOUNT_SID, TokenTwilio.AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+521"+"4281176295"), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                "Tu codigo de autorización es "+mensaje.getMensaje())      
            .create(); 
        
        return message;
    }

}
