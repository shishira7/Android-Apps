package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText un_et1, pwd_et1;
    Button signin;
    int count = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        un_et1 = findViewById(R.id.usrName);
        pwd_et1 = findViewById(R.id.passwd);
        signin = findViewById(R.id.signinbtn);

        String regUserName = getIntent().getStringExtra("userName");
        String regPassWord = getIntent().getStringExtra("passWord");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName1 = un_et1.getText().toString();
                String passWord1 = pwd_et1.getText().toString();

                if (regUserName.equals(userName1) && regPassWord.equals(passWord1)) {
                    Intent intent1 = new Intent(LoginActivity.this, LoginSuccessful.class);
                    startActivity(intent1);
                } else if(count == 2){
                    Toast.makeText(getBaseContext(), "Login attempt left 1", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Failed Login Attempts", Toast.LENGTH_LONG).show();
                    signin.setEnabled(false);
                }
                count--;
            }
        });
    }
}