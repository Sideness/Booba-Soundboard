package com.apps.sideness.boobasoundboard;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;


public class MainActivity extends Activity {

    private static Context context;
    private static final float ROTATE_FROM = 0.0f;
    private static final float ROTATE_TO = -3.0f * 360.0f;// 3.141592654f * 32.0f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.context = getApplicationContext();

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(MainActivity.this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {
                try{
                    String pos = "";
                    if(position == 0){
                        pos = "im1";
                    }else{
                        pos = "im" + Integer.toString(position + 1);
                    }
                    final MediaPlayer mPlayer = MediaPlayer.create(context, getResources().getIdentifier(pos, "raw","com.apps.sideness.boobasoundboard"));
                    mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mPlayer.start();

                    RotateAnimation r = new RotateAnimation(ROTATE_FROM, ROTATE_TO, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    r.setDuration((long) 2 * 1500);
                    //gridview.getAdapter().getView(position, this, this);
                    gridview.getChildAt(position - gridview.getFirstVisiblePosition()).findViewById(R.id.icon_image).startAnimation(r);
                            //.startAnimation(r);
                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }
                    });
                }catch(Exception e){
                    Log.e(e.getMessage().toString(), e.getMessage().toString());
                }

            }
        });
    }
}
