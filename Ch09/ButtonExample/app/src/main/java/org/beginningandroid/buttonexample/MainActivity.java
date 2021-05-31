package org.beginningandroid.buttonexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button myButton;
    Integer myInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myButton = new Button(this);
        myButton.setOnClickListener(this);
        myInt = 0;
        updateClickCounter();
        setContentView(myButton);
    }

    @Override
    public void onClick(View v) {
        updateClickCounter();
    }

    private void updateClickCounter() {
        myInt++;
        myButton.setText(myInt.toString());
    }
}