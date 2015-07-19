package com.joel.aivco.sharedpreference;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private final String STRINGVALUE="first";
    SharedPreferences sp;
    SharedPreferences.Editor spe;
    private EditText enteredText;
    private Button clearButton;
    private Button saveButton;
    private TextView  display;
    private String textEntered;
    private SharedPreferenceHelper sharedPreferenceHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferenceHelper=new SharedPreferenceHelper(getApplicationContext());
         textEntered= sharedPreferenceHelper.getString(STRINGVALUE);

        enteredText=(EditText)findViewById(R.id.editText);
        saveButton=(Button)findViewById(R.id.saveButton);
        display=(TextView)findViewById(R.id.showtext);
        clearButton=(Button)findViewById(R.id.Clear);
        display.setText(textEntered);
        saveButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);



    }


//////////////////////////////////////////responds when any of the button is clicked/////////////////////////////////

    public void onClick(View v)
    {
        ///////////////////responds when the clear button is clicked////////////////////////
        if(v==clearButton)
        {

            sharedPreferenceHelper.removeData();
            display.setText(sharedPreferenceHelper.getString(STRINGVALUE));




        }
        ///////////////////responds when the save button is clicked////////////////////////
        else
        {

            sharedPreferenceHelper.setData(STRINGVALUE,enteredText.getText().toString());

            display.setText(enteredText.getText().toString());

        }



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



