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


public class MainActivity extends ActionBarActivity {
    private final String STRINGVALUE="first";
    SharedPreferences sp;
    private EditText enteredText;
    private Button saveButton;
    private TextView  Display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enteredText=(EditText)findViewById(R.id.editText);
         saveButton=(Button)findViewById(R.id.saveButton);
        Display=(TextView)findViewById(R.id.showtext);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor spe = sp.edit();
                spe.putString(STRINGVALUE,enteredText.getText().toString() );
                spe.commit();
                Display.setText(enteredText.getText().toString());

            }
        });

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
