//package com.docfee.admin.utng.service;
//import com.docfee.admin.utng.model.LoginUsuario;
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.DocumentReference;
//import com.google.cloud.firestore.DocumentSnapshot;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.WriteResult;
//import com.google.firebase.cloud.FirestoreClient;
//import org.springframework.stereotype.Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.util.concurrent.ExecutionException;
//
////CRUD operations
//@Service
//public class sessionService {
// private static final Logger LOG = LoggerFactory.getLogger(sessionService.class);
//    public static final String COL_NAME="users";
//
//    public String saveSessionDetails(LoginUsuario usuario) throws InterruptedException, ExecutionException {
//        LOG.info(usuario.toString());
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(usuario.getNombre()).set(usuario);
//        return collectionsApiFuture.get().getUpdateTime().toString();
//    }
//
//    public LoginUsuario getSessionDetails(String name) throws InterruptedException, ExecutionException {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
//        ApiFuture<DocumentSnapshot> future = documentReference.get();
//
//        DocumentSnapshot document = future.get();
//
//        LoginUsuario session = null;
//
//        if(document.exists()) {
//            session = document.toObject(LoginUsuario.class);
//            return session;
//        }else {
//            return null;
//        }
//    }
//
//    public String updateSessionDetails(LoginUsuario session) throws InterruptedException, ExecutionException {
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(session.getNombre()).set(session);
//        return collectionsApiFuture.get().getUpdateTime().toString();
//    }
//
//    public String deleteSession(String name) throws InterruptedException, ExecutionException{
//        Firestore dbFirestore = FirestoreClient.getFirestore();
//        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
//        
//        return writeResult.get().getUpdateTime().toString();
//        //return "Document with Patient ID "+name+" has been deleted";
//    }
//
//}