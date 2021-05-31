package org.beginningandroid.clientexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startSharing:
                startSharing(view);
                break;
            case R.id.stopSharing:
                stopSharing(view);
                break;
        }
    }

    public void startSharing(View view) {
        Intent myIntent=new Intent(this, ServiceExample.class);
        myIntent.putExtra(ServiceExample.EXTRA_ALBUM, "My Holiday Snaps");
        startService(myIntent);
    }

    public void stopSharing(View v) {
        stopService(new Intent(this, ServiceExample.class));
    }

}