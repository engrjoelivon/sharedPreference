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
       // sp = getPreferences(MODE_PRIVATE);    ///This shared preference object must be maintained between saving and retrieving datas.
        //spe = sp.edit();//shared preference editor is initiated to handle storing datas in the sharedpreference
        textEntered= sharedPreferenceHelper.getData(STRINGVALUE);
                //sp.getString(STRINGVALUE,"NO VALUE STORED YET");//in an application through this line of code one can know if the application has been used before or it is the first time
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
            //spe.clear();
           // spe.commit();////when clear is used it must be committed
            sharedPreferenceHelper.removeData();
            display.setText(sharedPreferenceHelper.getData(STRINGVALUE));




        }
        ///////////////////responds when the save button is clicked////////////////////////
        else
        {
            //spe.putString(STRINGVALUE,enteredText.getText().toString() );
           // spe.commit();
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
private class UsingPreference
{
public void saveDatas(int input){}
public void saveDatas(String input){}
public void saveDatas(Long input){}
public void saveDatas(char input){}


public void clearDatas(String key)
{

}
public int collectDatas(String key)
{
    int value=0;
 return value;
}


    public Long collectDatas()
    {
        Long value=0L;
        return value;
    }



}
}



