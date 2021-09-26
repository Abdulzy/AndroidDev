package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky);
        Button button_a = findViewById(R.id.Button_A);
        Button button_b = findViewById(R.id.Button_B);
        Button button_c = findViewById(R.id.Button_C);
        Button button_d = findViewById(R.id.Button_D);
        Button button_e = findViewById(R.id.Button_E);
        Button button_f = findViewById(R.id.Button_F);

        button_a.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        TextView display = findViewById(R.id.clickyDisplay);
                        display.setText("Pressed: A");
                        return false;
                    }
                }
        );

        button_b.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        TextView display = findViewById(R.id.clickyDisplay);
                        display.setText("Pressed: B");
                        return false;
                    }
                }
        );

        button_c.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        TextView display = findViewById(R.id.clickyDisplay);
                        display.setText("Pressed: C");
                        return false;
                    }
                }
        );

        button_d.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        TextView display = findViewById(R.id.clickyDisplay);
                        display.setText("Pressed: D");
                        return false;
                    }
                }
        );

        button_e.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        TextView display = findViewById(R.id.clickyDisplay);
                        display.setText("Pressed: E");
                        return false;
                    }
                }
        );

        button_f.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View view){
                        TextView display = findViewById(R.id.clickyDisplay);
                        display.setText("Pressed: F");
                        return false;
                    }
                }
        );


    }

    public void onClick(View view)
    {
        TextView display = findViewById(R.id.clickyDisplay);
        switch (view.getId()) {
            case R.id.Button_A:
            case R.id.Button_B:
            case R.id.Button_C:
            case R.id.Button_D:
            case R.id.Button_E:
            case R.id.Button_F:
                display.setText("Pressed:-");
                break;
        }

    }
}