package org.beginningandroid.videoplayexample;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView vv;
    private MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startButton:
                doPlayVideo();
                break;
            case R.id.stopButton:
                doStopVideo();
                break;
        }
    }

    private void doPlayVideo() {
        vv =(VideoView)findViewById(R.id.video);

        mc = new MediaController(this);
        mc.setAnchorView(vv);

        vv.setMediaController(mc);
        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_file));
        vv.requestFocus();
        vv.start();
    }

    private void doStopVideo() {
        if (vv != null) {
            vv.stopPlayback();
        }
    }

}