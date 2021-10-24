package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WebServiceActivity extends AppCompatActivity {

    private static final String TAG = "WebServiceActivity";

    private EditText userInput;
    private TextView displayAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
        userInput = (EditText)findViewById(R.id.requestedName);
        displayAge = (TextView)findViewById(R.id.ageResult);
    }

    public void webserviceButtonHandler(View view){
        PingWebServiceTask task = new PingWebServiceTask();
        try {
            String url = NetworkUtil.validInput("https://theaudiodb.com/api/v1/json/1/search.php?s=" + userInput.getText().toString());
            task.execute(url); // This is a security risk.  Don't let your user enter the URL in a real app.
        } catch (NetworkUtil.MyException e) {
            Toast.makeText(getApplication(),e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

    private class PingWebServiceTask  extends AsyncTask<String, Integer, JSONArray> {

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Making progress...");
        }

        @Override
        protected JSONArray doInBackground(String... params) {

            JSONObject jObject = new JSONObject();
            JSONArray jArray = new JSONArray();
            try {

                // Initial website is "https://jsonplaceholder.typicode.com/posts/1"
                URL url = new URL( params[0]);
                // Get String response from the url address
                String resp = NetworkUtil.httpResponse(url);
                //Log.i("resp",resp);

                // JSONArray jArray = new JSONArray(resp);    // Use this if your web service returns an array of objects.  Arrays are in [ ] brackets.
                // Transform String into JSONObject
                //jObject = new JSONObject(resp);

                jObject = new JSONObject(resp);
                jArray = jObject.getJSONArray("artists");
                JSONObject jObject1 = new JSONObject();

//                jObject =  jArray.getJSONArray(0).getJSONObject(0);

                //Log.i("jTitle",jObject.getString("title"));
                //Log.i("jBody",jObject.getString("body"));
                return jArray;

            } catch (MalformedURLException e) {
                Log.e(TAG,"MalformedURLException");
                e.printStackTrace();
            } catch (ProtocolException e) {
                Log.e(TAG,"ProtocolException");
                e.printStackTrace();
            } catch (IOException e) {
                Log.e(TAG,"IOException");
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e(TAG,"JSONException");
                e.printStackTrace();
            }

            return jArray;
        }

        @Override
        protected void onPostExecute(JSONArray jArray) {
            super.onPostExecute(jArray);
            TextView result_view = (TextView)findViewById(R.id.ageResult);

            StringBuilder result = new StringBuilder();

            try {
                result.append("Name: ").append(jArray.getJSONObject(0).getString("strArtist")).append("\n");
                result.append("Birth Year: ").append(jArray.getJSONObject(0).getString("intBornYear")).append("\n");
                result.append("Gender: ").append(jArray.getJSONObject(0).getString("strGender")).append("\n");
                result.append("Location: ").append(jArray.getJSONObject(0).getString("strCountryCode")).append("\n");
                result.append("Label: ").append(jArray.getJSONObject(0).getString("strLabel")).append("\n");
                result.append("Genre: ").append(jArray.getJSONObject(0).getString("strGenre")).append("\n");
                result.append("Style: ").append(jArray.getJSONObject(0).getString("strStyle"));
                result_view.setText(result.toString());
            } catch (JSONException e) {
                result_view.setText("Something went wrong!\n Try a different name or spell it right!");
            }

        }
    }
}