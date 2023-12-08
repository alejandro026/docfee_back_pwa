package com.docfee.admin.utng.service;

import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docfee.admin.utng.dto.NotificationPayload;
import com.docfee.admin.utng.dto.TokenSwDTO;
import com.docfee.admin.utng.model.TokensNotificaciones;
import com.docfee.admin.utng.repository.ITokensNotificacionesRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PushNotificationService {
    
    @Autowired
    private ITokensNotificacionesRepository notificacionesRepository;

    private PushService pushService;

    public PushNotificationService() throws GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());

        pushService = new PushService();
        pushService.setPublicKey(
                "BNbKdoGiuuGcZzadTU6KPxfKXgqvaIQs7bKkchFA9T9UM1oJEukHJeKqkUNDHZKRDqdeC5mEUDVObu9_A-YNh6U");
        pushService.setPrivateKey("8UJkzGpL63qexpMyRykRlN_f02sQ21idvA3ZdoV2y0w");
    }

//    public void sendPushMessage(TokenSwDTO token) throws InterruptedException, ExecutionException, JoseException, GeneralSecurityException, IOException {
//        Notification notification = new Notification(
//                token.getEndpoint(),
//                token.getKeys().getP256dh(),
//                token.getKeys().getAuth(),
//                "{\"notification\":{\"title\":\"😄😄 Saludos\",\"body\":\"Subscribete a mi canal de YOUTUBE\",\"vibrate\":[100,50,100],\"image\":\"https://avatars2.githubusercontent.com/u/15802366?s=460&u=ac6cc646599f2ed6c4699a74b15192a29177f85a&v=4\",\"actions\":[{\"action\":\"explore\",\"title\":\"Go to the site\"}]}}"
//        );
//
//        pushService.send(notification);
//    }

    public void sendPushMessage()
            throws InterruptedException, ExecutionException, JoseException, GeneralSecurityException, IOException {

        NotificationPayload payload = new NotificationPayload();
        NotificationPayload.Notification notification = new NotificationPayload.Notification();
        notification.setTitle("Citas disponibles");
        notification.setBody("En este momento hay citas disponibles");
        notification.setVibrate(new int[] { 100, 50, 100 });
        notification.setImage(
                "https://www.clipartkey.com/mpngs/m/152-1520578_icono-palomita-png.png");
        notification.setActions(new NotificationPayload.Notification.Action[] {
                new NotificationPayload.Notification.Action("explore", "Ver citas")
        });
        payload.setNotification(notification);

        String jsonPayload = payload.toJson();

        //Enviando notificacion a todos los usuarios
        List<TokensNotificaciones> listaToken=notificacionesRepository.findAll();
        
        if (!listaToken.isEmpty()) {
            for (Iterator iterator = listaToken.iterator(); iterator.hasNext();) {
                TokensNotificaciones tokensNotificaciones = (TokensNotificaciones) iterator.next();
                Notification notificacionPWA = new Notification(
                        tokensNotificaciones.getEndpoint(),
                        tokensNotificaciones.getP256dh(),
                        tokensNotificaciones.getAuth(),
                        jsonPayload);
                log.info("Enviando notificacion");

                pushService.send(notificacionPWA);
            }
            
        }
        
    }
    
    public void registrarToken(TokenSwDTO token) {
        
        Optional<TokensNotificaciones> optional= notificacionesRepository.findByAuth(token.getKeys().getAuth());
        if(!optional.isPresent()) {
            TokensNotificaciones tokenNotificaciones= new TokensNotificaciones();
            tokenNotificaciones.setEndpoint(token.getEndpoint());
            tokenNotificaciones.setAuth(token.getKeys().getAuth());
            tokenNotificaciones.setP256dh(token.getKeys().getP256dh());
            notificacionesRepository.save(tokenNotificaciones);
            log.info("guardando token");
        }
    }
}
