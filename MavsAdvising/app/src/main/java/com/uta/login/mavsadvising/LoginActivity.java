package com.uta.login.mavsadvising;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by karthyvr on 6/27/16.
 */
public class LoginActivity extends AppCompatActivity {
    String usernetid;
    String role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usernetid = getIntent().getStringExtra("Usernetid");
        role = getIntent().getStringExtra("role");
        if (role.equals("admin")) {
            setContentView(R.layout.admin_dashboard);
            TextView a = (TextView) findViewById(R.id.admin_welcome_msg);
            if (a != null) {
                a.setText("Welcome " + usernetid);
            }
        } else if (role.equals("advisor")) {
            setContentView(R.layout.advisor_dashboard);
            TextView a = (TextView) findViewById(R.id.advisor_welcome_msg);
            if (a != null) {
                a.setText("Welcome " + usernetid);
            }
        }
        if (role.equals("student")) {
            setContentView(R.layout.student_dashboard);
            TextView a = (TextView) findViewById(R.id.student_welcome_msg);
            if (a != null) {
                a.setText("Welcome " + usernetid);
            }
        }
    }

        public void onButtonClick(View v) {


            if (v.getId() == R.id.BTNStudentSchedule) {

                Intent i = new Intent(LoginActivity.this, StudentScheduleActivity.class);
                i.putExtra("Usernetid", usernetid);
                i.putExtra("role", role);

                startActivity(i);
            }else if (v.getId() == R.id.BTNStudentView){
                System.out.println("within the studentcancel functionality");
                Intent i = new Intent(LoginActivity.this, StudentViewCancelActivity.class);
                i.putExtra("Usernetid", usernetid);
                i.putExtra("role", role);

                startActivity(i);

            }else if (v.getId() == R.id.BTNLogOut){
                System.out.println("within the logout functionality");

                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);

            }
        }

    }

