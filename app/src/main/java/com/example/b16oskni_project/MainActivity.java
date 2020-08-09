package com.example.b16oskni_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Band> arrayList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String about = new String("This app contains information about popular Swedish metal bands" +
                " for everyone new to the Swedish metal scene.");
        Button aboutBtn = findViewById(R.id.aboutButton);
        arrayList =  new ArrayList<>();
        listView = findViewById(R.id.myListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayList.get(position).info(), Toast.LENGTH_SHORT).show();
            }
        });
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, about, Toast.LENGTH_LONG).show();
            }
        });

        new JsonTask().execute ("https://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=b16oskni");


    }

    @SuppressLint("StaticFieldLeak")
    private class JsonTask extends AsyncTask<String, String, String> {


        private HttpURLConnection connection = null;
        private BufferedReader reader = null;



        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && !isCancelled()) {
                    builder.append(line).append("\n");
                }
                 return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String json) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject json1 = jsonArray.getJSONObject(i);
                    String name = json1.getString("name");
                    String company = json1.getString("company");
                    String category = json1.getString("category");
                    String url = json1.getString("auxdata");
                    Band band = new Band(name,company,category, url);
                    arrayList.add(band);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            CustomListAdapter adapter = new CustomListAdapter(getApplicationContext(), R.layout.list_item_textview, arrayList);
            listView.setAdapter(adapter);
            Log.d("TAG", json);




        }
    }

}

