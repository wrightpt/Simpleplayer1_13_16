package com.patrick.c.simpleplayer1_13_16;

import android.content.*;
import android.os.*;
import android.util.*;
import android.widget.*;


import com.google.android.youtube.player.*;
import com.patrick.c.simpleplayer1_13_16.*;

/**
 * Created by c on 1/2/16.
 */
public class PlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView fragment ;

    public static final String KEY_VIDEO_ID = "KEY_VIDEO_ID";
    //private static final YouTubeIntents I = new YouTubeIntents() ;
    private YouTubePlayerView playerView;
    String example = "example";


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_player);

        YouTubePlayerView playerView = (YouTubePlayerView)findViewById(R.id.player_view);
        Log.d("connector","connector");
        playerView.initialize(YoutubeConnector.KEY, this);

     //   fragment.initialize("DEVELOPER_KEY", new YouTubePlayer.OnInitializedListener() {
       //     @Override
       //     public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {


         //       if(!b) {
         //           youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID"));
         //       }


//            }

  //          @Override
    //        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
             //  Toast.makeText(this,getString(R.string.failed), Toast.LENGTH_LONG)
             //   Toast.makeText(this, getString(R.string.failed), Toast.LENGTH_LONG).show();

        //    }
      //  });


        //setContentView(R.layout.activity_youtube_fragment);
//Log.d("clickable","clickedagain");



     //   YouTubeFragment fragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.fragment_youtube);
      //  fragment.set
      //  playerView = (YouTubePlayerView)findViewById(R.id.player_view);
      //  playerView.initialize(YoutubeConnector.KEY, this);
    }





    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        Log.d("youtubeplayer3","youtubeplayer2");
      if(!b) {
            Log.d("youtubeplayer","youtubeplayer1");

    //  if(YouTubeIntents.canResolvePlayVideoIntentWithOptions(getActivity()))

        //youTubePlayer.play();
      //youTubePlayer.loadVideo(getIntent().getStringExtra("VIDEO_ID"));
     youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID"));

      //      Intent i = new Intent(this, PopUpService.class);
        }
           //  YouTubeIntents yti = new YouTubeIntents();
           // I.createPlayVideoIntent(PopUpService.class,youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID")));
          //  I.create
           youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID"));
            // putExtra(example,youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID")));

       //     startService(i);
        }


        @Override
        public void onInitializationFailure (YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult){
            Log.d("fail", String.valueOf(youTubeInitializationResult));
            Toast.makeText(this, getString(R.string.failed), Toast.LENGTH_LONG).show();
        }



}
