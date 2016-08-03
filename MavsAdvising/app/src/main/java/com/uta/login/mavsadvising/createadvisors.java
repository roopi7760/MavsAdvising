package com.uta.login.mavsadvising;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View.OnClickListener;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;


public class createadvisors extends AppCompatActivity {

    //Variables for storing the data
    //private EditText NetID;
    private EditText starttime;
    private EditText endtime;
    private EditText dayofweek;
    private EditText startdate;
    private EditText enddate;
    private Button submit_button;
    private String url = "http://omega.uta.edu/~sxs8285/insertadv.php";
    private String NetID;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_advisors);


        Button button;
        final Context context = this;
        button = (Button) findViewById(R.id.add_button);

        startdate = (EditText) findViewById(R.id.sdate_txt);
        enddate = (EditText) findViewById(R.id.edate_text);
        dayofweek = (EditText) findViewById(R.id.dayofweek_text);
        starttime = (EditText) findViewById(R.id.stime_txt);
        endtime = (EditText) findViewById(R.id.etime_text);
        submit_button = (Button) findViewById(R.id.submit_button);

        NetID = getIntent().getStringExtra("AdvisorNetId").toString();
        //String role = i1.getStringExtra("role").toString();
        TextView netid_TxtView = (TextView) findViewById(R.id.netdisp_txt_view);
        netid_TxtView.setText(NetID);

        submit_button = (Button) findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Error", "Inside the button");
                queue = Volley.newRequestQueue(getApplicationContext());
                insert_advisor_schedule();
                Toast.makeText(createadvisors.this, "Advising Successfully created", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });


        button.setOnClickListener(new OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          queue = Volley.newRequestQueue(getApplicationContext());
                                          insert_advisor_schedule();
                                          clearData();
                                          // Intent retData = new Intent();


                                          //NetID = (EditText) findViewById(R.id.netid_txt);


                                         // AppController.getmInstance().addToRequestQueue(request);
                                          Toast.makeText(createadvisors.this, "Advising Successfully created", Toast.LENGTH_LONG).show();

                                      }
                                  }
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //Redirecting the Add Button


                    // drop down menu for the Reason
        /*Spinner dropdown = (Spinner) findViewById(R.id.dayweek_spinner);
        String[] items = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        final Spinner dropdown1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(dataAdapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                Object item = arg0.getItemAtPosition(arg2);Toast.makeText(createadvisors.this, "Selected",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }*/
//function to insert schedule

    public void insert_advisor_schedule()
    {
        String URL = "http://omega.uta.edu/~sxs8285/insertadv.php";
        Log.e("inside insert", "inserted data");
        StringRequest stringReq = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // Assign the response to an TextView
                try{
                    if(response.equals("Success"))
                    {

                        Toast msg = Toast.makeText(getApplicationContext(),"submit Button clicked", Toast.LENGTH_LONG);
                        msg.show();

                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.d(TAG , error.toString());
            }
        })
        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> parameters =new HashMap<String, String>();
                if(NetID!= null) parameters.put("NetID", "sajib123");
                else parameters.put("NetID", NetID);
                parameters.put("StartDate", startdate.getText().toString());
                Log.e("inside",startdate.getText().toString());
                parameters.put("EndDate", enddate.getText().toString());
                parameters.put("DayOfWeek", dayofweek.getText().toString());
                parameters.put("StartTime", starttime.getText().toString());
                parameters.put("EndTime", endtime.getText().toString());
                return parameters;
            }
        };
        queue.add(stringReq);
    }

public void clearData()
{
    startdate.setText("");
    enddate.setText("");
    dayofweek.setText("");
    starttime.setText("");
    endtime.setText("");
}

    //Logout Buuton
    public void logout(View v)
    {
        Intent i = new Intent(createadvisors.this,MainActivity.class);
        startActivity(i);
    }

}







