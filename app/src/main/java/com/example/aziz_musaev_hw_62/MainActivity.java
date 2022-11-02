package com.example.aziz_musaev_hw_62;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvInput, tvWelcome, tvRegistration, tvForgotPassword, tvClickHere;
    private Button btnToComeIn;
    private EditText etEnterEmail, etEnterPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkWithXml();
        onTextChange(etEnterEmail);
        onTextChange(etEnterPassword);
        clicker();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


    }


    private void onTextChange(EditText et) {
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et.getText().length() != 0) {
                    btnToComeIn.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    btnToComeIn.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
         });

    }
private void clicker(){
        btnToComeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etEnterEmail.getText().toString();
                String password = etEnterPassword.getText().toString();
                switch (login)
                {
                    case "admin@gmail.com":
                        switch (password)
                        {
                            case "admin":
                                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(".MainActivity2");
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Ваш логин: admin@gmail.com", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                                break;
                        }
                       break;
                    default:
                        Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                   break;
                }


            }
        });
}




    private void linkWithXml() {
        tvInput = findViewById(R.id.input);
        tvWelcome = findViewById(R.id.welcome);
        tvRegistration = findViewById(R.id.registration);
        tvForgotPassword = findViewById(R.id.Forgot_Password);
        tvClickHere = findViewById(R.id.click_here);
        btnToComeIn = findViewById(R.id.to_come_in);
        etEnterEmail = findViewById(R.id.enter_email);
        etEnterPassword = findViewById(R.id.enter_password);
    }

}