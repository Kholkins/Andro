package com.example.andro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.andro.util.Language;

public class LastActivity extends AppCompatActivity {

    private TextView txtLogin;
    private TextView txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtPassword = (TextView) findViewById(R.id.txtPassword);

        txtLogin.setText(getIntent().getStringExtra("login"));
        txtPassword.setText(getIntent().getStringExtra("password"));
    }

    public void onBack (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onSelectedLang (View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnEng:
                intent = new Intent();
                intent.putExtra("Lang", Language.ENGLISH.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
            case R.id.btnRus:
                intent = new Intent();
                intent.putExtra("Lang", Language.RUSSIAN.getLanguage());
                setResult(RESULT_OK, intent);
                finish();
        }
    }
}
