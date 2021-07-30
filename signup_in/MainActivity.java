package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.signup.R;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText un_et, pwd_et;
    Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        un_et = findViewById(R.id.uneditText);
        pwd_et = findViewById(R.id.pwdeditText);
        signup_btn = findViewById(R.id.signupbtn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String userName = un_et.getText().toString();
                String passWord = pwd_et.getText().toString();

                if(!isValidPassword(passWord)){
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("passWord",passWord);
                startActivity(intent);
            }

        });
    }

    Pattern lowerCase = Pattern.compile("^.*[a-z].*$");
    Pattern upperCase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern spclChars = Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private Boolean isValidPassword(String password){
        if(password.length()<8){
            return false;
        }
        if(!upperCase.matcher(password).matches()){
            return false;
        }
        if(!number.matcher(password).matches()){
            return false;
        }
        if(!spclChars.matcher(password).matches()){
            return false;
        }

        return true;
    }
}