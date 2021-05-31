package org.beginningandroid.callexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callWithActionDialIntent(View view) {
        EditText targetNumber=(EditText)findViewById(R.id.phonenumber);
        String dialThisNumber="tel:"+targetNumber.getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dialThisNumber)));
    }

    public void callWithActionCallIntent(View view) {
        EditText targetNumber=(EditText)findViewById(R.id.phonenumber);
        String callThisNumber="tel:"+targetNumber.getText().toString();
        //the following intent only works with CALL_PHONE permission in place
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(callThisNumber)));
    }

}