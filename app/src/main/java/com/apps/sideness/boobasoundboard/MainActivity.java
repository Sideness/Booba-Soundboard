package com.apps.sideness.boobasoundboard;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static Context context;
    private static final float ROTATE_FROM = 0.0f;
    private static final float ROTATE_TO = -3.0f * 360.0f;// 3.141592654f * 32.0f;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.context = getApplicationContext();

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

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
                    gridview.getChildAt(position - gridview.getFirstVisiblePosition()).startAnimation(r);
                    mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                        public void onCompletion(MediaPlayer mp) {

                            gridview.getChildAt(position - gridview.getFirstVisiblePosition()).clearAnimation();
                        }
                    });
                }catch(Exception e){
                    Log.e(e.getMessage().toString(), e.getMessage().toString());
                }

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
