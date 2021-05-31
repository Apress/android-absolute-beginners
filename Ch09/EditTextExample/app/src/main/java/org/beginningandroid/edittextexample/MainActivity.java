package org.beginningandroid.edittextexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText myfield=(EditText)findViewById(R.id.myfield);
        myfield.setText("Our EditText widget");

    }
}