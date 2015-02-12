package org.androidtown.doltmission05;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends ActionBarActivity {

    SimpleDateFormat sdf;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);

        sdf = new SimpleDateFormat("yyyy년MM월dd일");

        button.setText(sdf.format(new Date()));
    }

    public void onButton1Clicked(View v){
        int year =new GregorianCalendar().get(Calendar.YEAR);
        int month =new GregorianCalendar().get(Calendar.MONTH);
        int day =new GregorianCalendar().get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this,listener,year,month,day).show();
    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            button.setText(year+"년"+(monthOfYear+1)+"월"+dayOfMonth+"일");

        }
    };

    public void onButton2Clicked(View v){
        EditText name = (EditText)findViewById(R.id.editText);
        EditText age = (EditText)findViewById(R.id.editText2);
        String birth =button.getText().toString();

        Toast.makeText(getApplicationContext(),"이름:"+name.getText().toString()+"\n"+
                                                "나이:"+age.getText().toString()+"\n"+
                                                "생년월일"+birth,Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
