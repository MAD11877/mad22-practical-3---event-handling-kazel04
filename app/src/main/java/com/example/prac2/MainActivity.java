package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button3);
        String buttonText = (String) button.getText();
        System.out.println(buttonText);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    button.setText("Unfollow");
            }
        });
    }


}