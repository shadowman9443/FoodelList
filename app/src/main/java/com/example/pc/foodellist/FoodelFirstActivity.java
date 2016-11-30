package com.example.pc.foodellist;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FoodelFirstActivity extends Activity {
    Button findPlace;
    TextView bookTabletxt,ordertaketxt,orderTbaletxt;
    RelativeLayout rlbookTbl,relordederTke,relordTbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_foodel_first);
        findPlace= (Button) findViewById(R.id.btnFindPLace);
        bookTabletxt= (TextView) findViewById(R.id.txtBokTbl);
        ordertaketxt= (TextView) findViewById(R.id.txtOrderTake);
        orderTbaletxt= (TextView) findViewById(R.id.txtOrderTable);
        findPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RestaurentListActivity.class);
                startActivity(intent);
            }
        });
  /*      bookTabletxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CardPaymentActivity.class);
                startActivity(intent);
            }
        });
        ordertake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),OrderConfirmationActivity.class);
                startActivity(intent);
            }
        });*/


        rlbookTbl = (RelativeLayout)findViewById(R.id.relBoktbl);


        rlbookTbl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
             //   rlbookTbl.setBackgroundColor(Color.parseColor("#01AAE3"));
                rlbookTbl.setBackgroundResource(R.drawable.left_side_corners);
                bookTabletxt.setTextColor(Color.WHITE);
                Intent intent=new Intent(getApplicationContext(),RestaurentActivity.class);
                startActivity(intent);
            }
        });
        relordederTke = (RelativeLayout)findViewById(R.id.relOrdTake);

        relordederTke.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               // relordederTke.setBackgroundColor(Color.parseColor("#01AAE3"));
                relordederTke.setBackgroundResource(R.drawable.middle_button_r);
                ordertaketxt.setTextColor(Color.WHITE);
                Intent intent=new Intent(getApplicationContext(),PaymentCashActivity.class);
                startActivity(intent);
            }
        });
        relordTbl = (RelativeLayout)findViewById(R.id.relOrdTbl);

        relordTbl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               // relordTbl.setBackgroundColor(Color.parseColor("#01AAE3"));
                relordTbl.setBackgroundResource(R.drawable.right_side_corners);
                orderTbaletxt.setTextColor(Color.WHITE);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_foodel_first, menu);
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
