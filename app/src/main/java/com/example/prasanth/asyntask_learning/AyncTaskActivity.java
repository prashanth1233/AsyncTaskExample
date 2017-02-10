package com.example.prasanth.asyntask_learning;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AyncTaskActivity extends Activity {
    private EditText entrFactorial;
    private Button showAns;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        entrFactorial=(EditText)findViewById(R.id.text1);
        showAns=(Button)findViewById(R.id.button1);
        showAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsynTaskExample asynTaskExample=new AsynTaskExample();
                String factorial=entrFactorial.getText().toString();
                asynTaskExample.execute(factorial);
            }
        });
    }

    public class AsynTaskExample extends AsyncTask<String,String,String> {
        TextView textView1;
        protected String doInBackground(String...params)
        {
            int factorial_result=1;
            int factorial_number=Integer.parseInt(params[0]);
            publishProgress("CALCULATING" );
            for(int i=1;i<=factorial_number;i++)
            {
                factorial_result=factorial_result*(i);
            }
            String s1=Integer.toString(factorial_result);
            return s1;
        }

        protected void onPostExecute(String result)
        {
            textView1=(TextView)findViewById(R.id.t2);
            textView1.setText(result);
        }

        protected void onPreExecute()
        {

        }

        protected void onProgressUpdate(String...text)
        {

        }
    }
}
