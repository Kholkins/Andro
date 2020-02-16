package com.example.andro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
    }

    public void sayHallo (View view) {
        textView.setText("Privet");

    }

    public void goToNewActivity (View view) {
        Intent intent = new Intent(this, LastActivity.class);
    }
}
