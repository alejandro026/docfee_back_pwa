//package com.docfee.admin.utng.controller;
//import java.util.concurrent.ExecutionException;
//import org.springframework.http.MediaType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.docfee.admin.utng.model.Citas;
//import com.docfee.admin.utng.model.LoginUsuario;
//@RestController
//@CrossOrigin(origins = "*")
//public class sessionController {
//    private static final Logger LOG = LoggerFactory.getLogger(sessionController.class);
//    @Autowired
//    sessionService sessionService;
//
//    @GetMapping("/getSessiontDetails")
//    public LoginUsuario getSession(@RequestParam String name ) throws InterruptedException, ExecutionException{
//        LOG.info(".-------------------------------->");
//        
//        return sessionService.getSessionDetails(name);
//    }
//
//    @PostMapping("/createSession")
//    public String createSession(@RequestBody LoginUsuario usuario ) throws InterruptedException, ExecutionException {
//        LOG.info(usuario.getNombre()+" y "+usuario.getId());
//        return sessionService.saveSessionDetails(usuario);
//    }
//
//    @PutMapping("/updateSession")
//    public String updateSession(@RequestBody LoginUsuario session  ) throws InterruptedException, ExecutionException {
//        return sessionService.updateSessionDetails(session);
//    }
//
//    
//
////    @DeleteMapping(value="/deleteSession/{name}")
////    public String deleteSession(@PathVariable("name") String name) throws InterruptedException, ExecutionException{
////        LOG.info(".-------------------------------->DELETE");
////
////        return sessionService.deleteSession(name);
////    }
//    
//    @PostMapping(path = "/deleteSession", produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public String deleteSession(@RequestBody LoginUsuario objeto) throws InterruptedException, ExecutionException{
//        
//        
//        return sessionService.deleteSession(objeto.getNombre());
//        
//    }
//    
//}