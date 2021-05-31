package org.beginningandroid.intentexample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText myContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContact=(EditText)findViewById(R.id.myContact);
    }

    public void viewContact(View view) {
        String myContactNumber=myContact.getText().toString();
        Uri myUri = Uri.parse("content://contacts/people/"+myContactNumber);
        startActivity(new Intent(Intent.ACTION_VIEW, myUri));
    }

}