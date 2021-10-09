package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.about:
                Toast.makeText(getApplicationContext(),
                        "Abdulrahman Isegen \n isegen.a@northeasten.edu",
                        Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.clickyclicky:
                Intent toCLicky = new Intent(this,ClickyActivity.class);
                startActivity(toCLicky);
                break;
            case R.id.linkCollector:
                Intent toLinkCollector = new Intent(this,LinkActivity.class);
                startActivity(toLinkCollector);
                break;
            case R.id.locator:
                Intent toLocator = new Intent(this,LocatorActivity.class);
                startActivity(toLocator);
                break;
        }

    }

}