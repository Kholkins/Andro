package com.example.andro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andro.util.RequestCode;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText login;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
    }

    public void sayHallo (View view) {
        textView.setText("Privet");

    }

    public void goToNewActivity (View view) {
        Intent intent = new Intent(this, LastActivity.class);
        startActivity(intent);
    }

    public void sentData (View view) {
        Intent intent = new Intent(this, LastActivity.class);
        intent.putExtra("login", login.getText().toString());
        intent.putExtra("password", password.getText().toString());
        startActivity(intent);
    }

    public void OnShow (View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Yahoo", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void onPresentations (View v ){
        Intent intent;
        switch (v.getId()){
            case R.id.btnPres:
                intent = new Intent(this, PresentedActivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_PRESENTED);
                break;
            case R.id.btnLan:
                intent = new Intent(this, LastActivity.class);
                startActivityForResult(intent, RequestCode.REQUEST_CODE_LANGUAGE);
                break;
        }

    }
}
