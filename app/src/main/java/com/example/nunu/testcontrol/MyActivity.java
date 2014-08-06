package com.example.nunu.testcontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	public void clickButton(View view){
		Intent i = new Intent (this, MyActivity2.class);
		startActivity(i);
	}

	public void clickText(View view){
		Log.d("TEST", "clickText");
		switch(view.getId()) {
			case R.id.textView:
				((TextView) view).setText("CLICK_SELF");
				break;
			default:
				((TextView) findViewById(R.id.textView)).setText("CLICK_" + ((TextView) view).getText());
		}
	}

	public void clickCheck(View view){
		Log.d("TEST","clickCheck");
		TextView tv = (TextView) findViewById(R.id.textViewP);
		CheckBox cb = (CheckBox)view;

		tv.setText((cb.isChecked() ? getString(R.string.check_on) : getString(R.string.check_off)));
		cb.setText((cb.isChecked() ? getString(R.string.check_on): getString(R.string.check_off)));
	}

	public void clickSwitch(View view){
		Log.d("TEST","clickSwitch");
		Switch sw = (Switch) findViewById(R.id.switch1);
		sw.setText((sw.isChecked() ? getString(R.string.switch_on): getString(R.string.switch_off)));
	}

	/*さらに複数のonClick処理を一括化するならこの方法！
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button1:
				Intent i = new Intent (this, SampleActivity2.class);
				startActivity(i);
				break;
		}
	}*/

}
