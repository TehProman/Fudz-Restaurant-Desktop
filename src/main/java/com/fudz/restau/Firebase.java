package com.fudz.restau;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Firebase {
    private static final String dbURL = "https://ordering-system-project-f28e7-default-rtdb.asia-southeast1.firebasedatabase.app";
    
    public static void initialize() {
        try {
            FirebaseOptions opt = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl(dbURL)
                    .build();
            
            FirebaseApp.initializeApp(opt);
        } catch (IOException ex) {
            Logger.getLogger(Firebase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
