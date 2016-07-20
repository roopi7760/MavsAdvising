package com.uta.login.mavsadvising;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdvisorDashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advisor_dashboard);
        TextView advisor_date_txt_view = (TextView) findViewById(R.id.advisor_date_txt_view);
        String date = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
        advisor_date_txt_view.setText(date);
        Intent i = getIntent();
        String welcome_Advisor_str = "Welcome " + i.getStringExtra("AdvisorNetId").toString();
        String role = i.getStringExtra("role").toString();
        TextView welcome_Advisor_TxtView = (TextView) findViewById(R.id.advisor_welcome_msg_text_view);
        welcome_Advisor_TxtView.setText(welcome_Advisor_str);

    }
}
