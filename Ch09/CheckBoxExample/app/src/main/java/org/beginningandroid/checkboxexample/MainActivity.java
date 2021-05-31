package org.beginningandroid.checkboxexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class MainActivity extends AppCompatActivity {

    CheckBox myCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCheckbox = (CheckBox)findViewById(R.id.check);
        myCheckbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    myCheckbox.setText("The checkbox is checked");
                }
                else
                {
                    myCheckbox.setText("The checkbox is unchecked");
                }
            }
        });
    }
}