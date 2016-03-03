package edu.uw.bn22.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        final EditText title = (EditText)findViewById(R.id.addTitle);
        final EditText name = (EditText)findViewById(R.id.addName);
        final EditText map = (EditText)findViewById(R.id.addMap);
        final Button submit = (Button) findViewById(R.id.search);
        final Firebase myFirebaseRef = new Firebase("https://INFO498ANDROID.firebaseio.com/");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("A", title.getText().toString() + " " + " " + name.getText().toString() + " " + map.getText().toString());
                request[] requests = new request[10];
                request a = new request(title.getText().toString(), name.getText().toString(), map.getText().toString());
                Firebase newRef = myFirebaseRef.child("feeds");
                requests[0] = a;
                newRef.child("feeds").push().setValue(requests);
                Toast.makeText(getBaseContext(), "Added to Database", Toast.LENGTH_SHORT).show();
            }
        });

        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //TextView result = (TextView)findViewById(R.id.result);
                //result.setText(snapshot.getValue().toString());
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."

            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });

    }
}
