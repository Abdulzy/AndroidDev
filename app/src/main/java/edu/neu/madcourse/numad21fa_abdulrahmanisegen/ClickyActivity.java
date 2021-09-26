package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClickyActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky);
    }

    public void onClick(View view)
    {
        TextView display = findViewById(R.id.clickyDisplay);
        switch (view.getId()) {
            case R.id.Button_A:
                display.setText("Pressed:A");
                break;
            case R.id.Button_B:
                display.setText("Pressed:B");
                break;
            case R.id.Button_C:
                display.setText("Pressed:C");
                break;
            case R.id.Button_D:
                display.setText("Pressed:D");
                break;
            case R.id.Button_E:
                display.setText("Pressed:E");
                break;
            case R.id.Button_F:
                display.setText("Pressed:F");
                break;
            default:
                display.setText("Pressed:-");
                break;
        }

    }
}