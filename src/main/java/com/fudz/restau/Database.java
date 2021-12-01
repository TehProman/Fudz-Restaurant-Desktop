package com.fudz.restau;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

/**
 *
 * @author Rene Tajos Jr.
 */
public class Database {
    
    private static final FirebaseDatabase firebaseDB = FirebaseDatabase.getInstance();
    private static DatabaseReference mReference;
    private static ChildEventListener childListener;
    
    private static boolean isFromPush = false;
    
    public static class Server {
        
        public Server(final String reference) {
            mReference = firebaseDB.getReference(reference);
            _initDBListeners();
        }
        
        public Server pushData(final HashMap<String, Object> data) {
            isFromPush = true;
            mReference.push().updateChildrenAsync(data);
            return this;
        }
        
        private Server _initDBListeners() {
            childListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot ds, String string) {
                    System.out.println(".onChildAdded(): ADDED!");
                }

                @Override
                public void onChildChanged(DataSnapshot ds, String string) {}
                @Override
                public void onChildRemoved(DataSnapshot ds) {}
                @Override
                public void onChildMoved(DataSnapshot ds, String string) {}
                @Override
                public void onCancelled(DatabaseError de) {}
            };
            mReference.addChildEventListener(childListener);
            return this;
        }
    }
}
