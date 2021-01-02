package gr.uom.loginapp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import gr.uom.loginapp.R;
import gr.uom.loginapp.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser == null) {
            Log.e(TAG, "User is not logged in!");

            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }
        else {
            Intent intent = getIntent();
            if (intent != null) {

                String username = intent.getStringExtra("username");

                if (username != null) {

                    TextView textView = findViewById(R.id.userText);

                    String text = "Logged username = " + username;

                    textView.setText(text);

                }
            }
        }
    }
}