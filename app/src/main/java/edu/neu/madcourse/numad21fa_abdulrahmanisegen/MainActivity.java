package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected Button toastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toastButton = findViewById(R.id.about);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),
                        "Abdulrahman Isegen \n isegen.a@northeasten.edu",
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}