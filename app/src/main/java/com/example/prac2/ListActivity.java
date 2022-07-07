package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Handler;
import android.widget.Button;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.Toast;
import java.util.concurrent.ThreadLocalRandom;

public class ListActivity extends AppCompatActivity {
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // initialize imageView
        // with method findViewById()
        View imageView = findViewById(R.id.imageView2);
        builder = new AlertDialog.Builder(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                //Setting message manually and performing action on button click
                builder.setMessage("MADness")
                        .setCancelable(false)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Insert random integer generation + transfer to main activity here!
                                int randomNum = ThreadLocalRandom.current().nextInt(0, 100000 + 1);
                                String value= String.valueOf(randomNum);
                                Intent i = new Intent(ListActivity.this, MainActivity.class);
                                i.putExtra("key",value);
                                startActivity(i); //code changes activity to mainactivity!

                                Toast.makeText(getApplicationContext(), value,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "you choose no action for alertbox",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();


        }
        });


    }
}