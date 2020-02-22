package com.example.andro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.andro.util.Language;

public class LastActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtLogin;
    private TextView txtPassword;
    private TextView tvOut;
    private Button btnOk;
    private Button btnOkOk;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtPassword = (TextView) findViewById(R.id.txtPassword);

        txtLogin.setText(getIntent().getStringExtra("login"));
        txtPassword.setText(getIntent().getStringExtra("password"));

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("Нажата кнопка ОК");
            }
        };
        btnOk.setOnClickListener(oclBtnOk);

        btnOkOk = (Button) findViewById(R.id.btnOkOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        // присваиваем обработчик кнопкам
        btnOkOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOkOk:
                // кнопка ОК
                tvOut.setText("Нажата кнопка ОК");
                break;
            case R.id.btnCancel:
                // кнопка Cancel
                tvOut.setText("Нажата кнопка Cancel");
                break;
        }
    }
}
