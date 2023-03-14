package com.example.androidvinted.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidvinted.R;
import com.example.androidvinted.contract.LoginContract;
import com.example.androidvinted.model.pojo.User;
import com.example.androidvinted.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{
    private EditText edtUserLogin;
    private EditText edtEmailLogin;
    private EditText edtPasswordLogin;
    private Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponents();
        initPresenter();
    }

    private void initComponents(){
        edtUserLogin = findViewById(R.id.Username);
        edtEmailLogin = findViewById(R.id.Email);
        edtPasswordLogin = findViewById(R.id.Pass);
        btnLogin = findViewById(R.id.buttonLogin);
    }

    private void initPresenter(){
        loginPresenter = new LoginPresenter();
        loginPresenter.lstProducts(null);
    }

    @Override
    public void successLogin(User user, String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}
