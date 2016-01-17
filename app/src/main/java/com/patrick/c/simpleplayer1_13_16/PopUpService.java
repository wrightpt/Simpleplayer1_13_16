package com.patrick.c.simpleplayer1_13_16;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.annotation.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import com.google.android.youtube.player.*;
import com.squareup.picasso.*;

import java.util.*;

/**
 * Created by c on 1/16/16.
 */
public class PopUpService extends Service implements YouTubePlayer {

    private LinearLayout ll;
    private WindowManager wm;
   // public static final String KEY_VIDEO_ID = "KEY_VIDEO_ID";
    private static final String KEY_VIDEO_TIME = "KEY_VIDEO_TIME";
    private List<VideoItem> searchResults;
    public static final String KEY_VIDEO_ID = "KEY_VIDEO_ID";
    private YouTubePlayerView playerView;




    @Override
    public void onCreate() {
        super.onCreate();



      //  youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID"));








       // Intent intent = new Intent(getApplicationContext(), PlayerActivity.class);
       // intent.putExtra(PlayerActivity.KEY_VIDEO_ID,searchResults.get(position).getId());
        //    startActivity(intent);
        //    Log.d("test","clicked");
        ll = new LinearLayout(this);

      //  youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID");


        final WindowManager wm;








        wm = (WindowManager) getSystemService(WINDOW_SERVICE);









        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(400,400, WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);





        // vv = (VideoView)findViewById(R.id.VideoView);
        // vv.setLayoutParams(params);
        // vv.start();



        ll.setBackgroundColor(Color.argb(66,255,0,0));
        ll.setLayoutParams(params);



        params.x = 0;
        params.y = 0;
        params.gravity = Gravity.CENTER | Gravity.CENTER;

        wm.addView(ll,params);
        //wm.addView(new VideoView(this)), params);

        ll.setOnTouchListener(new View.OnTouchListener() {

            private WindowManager.LayoutParams updatedParameters = params;
            int x, y;
            float touchedX, touchedY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction() ) {

                    case MotionEvent.ACTION_DOWN:
                        Log.d("hey mama", "hey mama11");

                        x = updatedParameters.x;
                        Log.d("hey mama", "hey mama12");

                        y= updatedParameters.y;
                        Log.d("hey mama", "hey mama13");

                        touchedX = event.getRawX();
                        Log.d("hey mama", "hey mama14");
                        touchedY = event.getRawY();
                        Log.d("hey mama", "hey mama15");

                        //  updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
                        //  Log.d("hey mama", "hey mama7");
                        //  updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
                        //  Log.d("hey mama", "hey mama8");

                        //   wm.updateViewLayout(ll,updatedParameters);
                        //   Log.d("hey mama", "hey mama9");


                        break;

                    case MotionEvent.ACTION_MOVE:




                        updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
                        Log.d("hey mama", "hey mama7");
                        updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
                        Log.d("hey mama", "hey mama8");

                        wm.updateViewLayout(ll,updatedParameters);
                        Log.d("hey mama", "hey mama9");

                 //   default:
                        //        Log.d("hey mama", "hey mama10");
                        break;
                }



                return false;
            }
        });
    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void release() {

    }

    @Override
    public void cueVideo(String s) {

    }

    @Override
    public void cueVideo(String s, int i) {

    }

    @Override
    public void loadVideo(String s) {

    }

    @Override
    public void loadVideo(String s, int i) {

    }

    @Override
    public void cuePlaylist(String s) {

    }

    @Override
    public void cuePlaylist(String s, int i, int i1) {

    }

    @Override
    public void loadPlaylist(String s) {

    }

    @Override
    public void loadPlaylist(String s, int i, int i1) {

    }

    @Override
    public void cueVideos(List<String> list) {

    }

    @Override
    public void cueVideos(List<String> list, int i, int i1) {

    }

    @Override
    public void loadVideos(List<String> list) {

    }

    @Override
    public void loadVideos(List<String> list, int i, int i1) {

    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public void next() {

    }

    @Override
    public void previous() {

    }

    @Override
    public int getCurrentTimeMillis() {
        return 0;
    }

    @Override
    public int getDurationMillis() {
        return 0;
    }

    @Override
    public void seekToMillis(int i) {

    }

    @Override
    public void seekRelativeMillis(int i) {

    }

    @Override
    public void setFullscreen(boolean b) {

    }

    @Override
    public void setOnFullscreenListener(OnFullscreenListener onFullscreenListener) {

    }

    @Override
    public void setFullscreenControlFlags(int i) {

    }

    @Override
    public int getFullscreenControlFlags() {
        return 0;
    }

    @Override
    public void addFullscreenControlFlag(int i) {

    }

    @Override
    public void setPlayerStyle(PlayerStyle playerStyle) {

    }

    @Override
    public void setShowFullscreenButton(boolean b) {

    }

    @Override
    public void setManageAudioFocus(boolean b) {

    }

    @Override
    public void setPlaylistEventListener(PlaylistEventListener playlistEventListener) {

    }

    @Override
    public void setPlayerStateChangeListener(PlayerStateChangeListener playerStateChangeListener) {

    }

    @Override
    public void setPlaybackEventListener(PlaybackEventListener playbackEventListener) {

    }
}
