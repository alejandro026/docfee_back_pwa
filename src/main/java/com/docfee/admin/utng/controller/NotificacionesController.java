package com.docfee.admin.utng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docfee.admin.utng.dto.TokenSwDTO;
import com.docfee.admin.utng.service.PushNotificationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired
    private PushNotificationService service;


    @PostMapping(path = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> guardar(@RequestBody TokenSwDTO objeto){
        
        service.registrarToken(objeto);
        
        return ResponseEntity.ok(true);
        
    }
    
    
}
