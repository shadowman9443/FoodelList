package com.example.pc.foodellist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toolbar;


public class RestaurentListActivity extends AppCompatActivity{
    ListView list;
    String[] web = {
            "Bangkok Eatery",
            "Kitchen Madras",
            "Green Chilis",
            "New Bombay",
            "Bangkok Eatery",
            "Kitchen Madras",
            "Green Chilli"
    } ;
    Integer[] imageId = {
            R.drawable.belogo,
            R.drawable.greenchilli,
            R.drawable.logo_bombay,
            R.drawable.logomadras,
            R.drawable.belogo,
            R.drawable.logo_bombay,
            R.drawable.greenchilli

    };
    RelativeLayout filtersRelative,sortRelative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_restaurent_list);
        list= (ListView) findViewById(R.id.listView);
        filtersRelative= (RelativeLayout) findViewById(R.id.relFilters);
        sortRelative= (RelativeLayout) findViewById(R.id.relsort);
        final BottomSheetDialogFragment myBottomSheet = FilterSheetDialogFragment.newInstance("Filter Bottom Sheet");


        filtersRelative.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBottomSheet.show(getSupportFragmentManager(), myBottomSheet.getTag());




            }
        });
        final BottomSheetDialogFragment sortBottomSheet = SortSheetDialogFragment.newInstance("Sort Bottom Sheet");


        sortRelative.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sortBottomSheet.show(getSupportFragmentManager(), sortBottomSheet.getTag());
                    }
                });


        ReastaurentListAdapter adapter = new
                ReastaurentListAdapter(RestaurentListActivity.this, web, imageId);
      /*  LinearLayout relative1 = (LinearLayout) findViewById(R.id.tell_a_frnd_rel);
        relative1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(RestaurentListActivity.this, TellAFrndActvity.class) );
            }
        });*/

        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurent_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
