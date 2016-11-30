package com.example.pc.foodellist;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CardPaymentActivity extends Activity {
    EditText datetimePicker;
    SimpleDateFormat format;
    Calendar c;
    int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_card_payment);
        datetimePicker= (EditText) findViewById(R.id.m_expiarydate);
        datetimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date

                DatePickerDialog dd = new DatePickerDialog(CardPaymentActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                try {
                                    SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                                    String dateInString = dayOfMonth + "/" + (monthOfYear + 1) + "/";
                                    Date date = formatter.parse(dateInString);

                                    datetimePicker.setText(formatter.format(date).toString());

                                    formatter = new SimpleDateFormat("MMM/yyyy");

                                    datetimePicker.setText(datetimePicker.getText().toString()+"\n"+formatter.format(date).toString());

                                    formatter = new SimpleDateFormat("MM-yyyy");

                                    datetimePicker.setText(datetimePicker.getText().toString()+"\n"+formatter.format(date).toString());

                                    formatter = new SimpleDateFormat("MMM.yyyy");

                                    datetimePicker.setText(datetimePicker.getText().toString()+"\n"+formatter.format(date).toString());



                                } catch (Exception ex) {

                                }


                            }
                        },year,month, day);
                dd.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_payment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
