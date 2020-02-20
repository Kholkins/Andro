package com.example.andro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    private TextView txtName;
    private TextView txtLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        txtName =(TextView) findViewById(R.id.txtName);
        txtLang = (TextView) findViewById(R.id.txtLang);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case RequestCode.REQUEST_CODE_PRESENTED:
                    String name = data.getStringExtra("name");
                    txtName.setText("Hi, "+ name);
                    break;

                case RequestCode.REQUEST_CODE_LANGUAGE:
                    String language = data.getStringExtra("Lang");
                    txtLang.setText(language);
                    break;
            }
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

}
