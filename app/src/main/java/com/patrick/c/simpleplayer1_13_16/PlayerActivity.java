package com.patrick.c.simpleplayer1_13_16;

import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;


import com.github.pedrovgs.*;
import com.google.android.youtube.player.*;
import com.google.android.youtube.player.internal.*;
import com.patrick.c.simpleplayer1_13_16.*;

/**
 * Created by c on 1/2/16.
 */
public class PlayerActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    //YouTubePlayerView fragment ;

   public static final String KEY_VIDEO_ID = "KEY_VIDEO_ID";
    //private static final YouTubeIntents I = new YouTubeIntents() ;
    private YouTubePlayerView playerView;
    DraggablePanel draggablePanel;
    WindowManager wm;
    private LinearLayout ll;
    private LayoutInflater layoutInflater;
    private PopupWindow mPopupWindow;
    private RelativeLayout relativeLayout;
    private LinearLayout mLinearLayout;

    //String example = "example";


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
       // relativeLayout = (RelativeLayout) findViewById(R.id.videoview_container);

       // playerView = (YouTubePlayerView)findViewById(R.id.player_view);
       // Log.d("connector","connector");
       // playerView.initialize(YoutubeConnector.KEY, this);

      //  ll = new LinearLayout(this);


      //  layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
      //  ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.videoview_main,null);


      //  mPopupWindow = new PopupWindow(container,400,400, true);
      //  mPopupWindow.showAtLocation(relativeLayout,Gravity.NO_GRAVITY,500,500);



        setContentView(R.layout.activity_player);
        View view = findViewById(R.id.playeractivityview);


       // final WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_PHONE,
        //        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.UNKNOWN);
       // getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        playerView = (YouTubePlayerView)findViewById(R.id.player_view);
        playerView.initialize(YoutubeConnector.KEY, this);



      //  mLinearLayout.setLayoutParams(params);





       // mLinearLayout.setOnTouchListener(new View.OnTouchListener() {

        //    private WindowManager.LayoutParams updatedParameters = params;



      //      @Override
       //     public boolean onTouch(View v, MotionEvent event) {

       //         params.x = 0;
       //         params.y = 0;
       //         params.gravity = Gravity.CENTER | Gravity.CENTER;


       //         int x, y;
        //        float touchedX, touchedY;



      //              switch (event.getAction() ) {

        //                case MotionEvent.ACTION_DOWN:
        //                    Log.d("hey mama", "hey mama11");
//
         //                   x = updatedParameters.x;
          //                  Log.d("hey mama", "hey mama12");

           //                 y= updatedParameters.y;
            //                Log.d("hey mama", "hey mama13");

            //                touchedX = event.getRawX();
           //                 Log.d("hey mama", "hey mama14");
           //                 touchedY = event.getRawY();
           //                 Log.d("hey mama", "hey mama15");

                            //  updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
                            //  Log.d("hey mama", "hey mama7");
                            //  updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
                            //  Log.d("hey mama", "hey mama8");

                            //   wm.updateViewLayout(ll,updatedParameters);
                            //   Log.d("hey mama", "hey mama9");


           //                 break;
//
           //             case MotionEvent.ACTION_MOVE:




             //               updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
             //               Log.d("hey mama", "hey mama7");
             //               updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
             //               Log.d("hey mama", "hey mama8");

              //              wm.updateViewLayout(mLinearLayout,updatedParameters);
              //              Log.d("hey mama", "hey mama9");


                            //        Log.d("hey mama", "hey mama10");
               //             break;
              //      }





               //     return false;
          //  }
      //  });

        //setContentView(new YouTubePlayerView(this).initialize(YoutubeConnector.KEY, this) );
        //YouTubePlayerView ytpv = setContentView(new V);
            //    R.layout.activity_player);

       // protected void onCreateView(new YouTubePlayerView(this),)




        //View popupView = getLayoutInflater().inflate(R.layout.activity_player, null);

        //PopupWindow popupWindow = new PopupWindow(popupView,
          //      AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT);





     //  playerView = (YouTubePlayerView)findViewById(R.id.player_view);
      //  Log.d("connector","connector");
       // playerView.initialize(YoutubeConnector.KEY, this);





     //  YouTubePlayerFragment youTubePlayerFragment =
      //      (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
    //   youTubePlayerFragment.initialize(YoutubeConnector.KEY,this);


              }

      // YouTubePlayerView playerView = .findViewById(R.id.player_view);
        //assert playerView != null;
        //playerView.findViewById(R.id.fragment_youtube);
       // playerView.initialize(YoutubeConnector.KEY,this);


      //  wm = (WindowManager) getSystemService(WINDOW_SERVICE);









       // final WindowManager.LayoutParams params = new WindowManager.LayoutParams(400,400, WindowManager.LayoutParams.TYPE_PHONE,
       //         WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);


       // ll.setBackgroundColor(Color.argb(66,255,0,0));
     //  playerView.setLayoutParams(params);



      //  params.x = 0;
      //  params.y = 0;
      //  params.gravity = Gravity.CENTER | Gravity.CENTER;

      //  wm.addView(playerView,params);
        //wm.addView(new VideoView(this)), params);

      //  playerView.setOnTouchListener(new View.OnTouchListener() {

        //    private WindowManager.LayoutParams updatedParameters = params;
      //      int x, y;
      //      float touchedX, touchedY;

      //      @Override
      //      public boolean onTouch(View v, MotionEvent event) {

      //          switch (event.getAction() ) {

       //             case MotionEvent.ACTION_DOWN:
       //                 Log.d("hey mama", "hey mama11");

       //                 x = updatedParameters.x;
        //                Log.d("hey mama", "hey mama12");

       //                 y= updatedParameters.y;
        //                Log.d("hey mama", "hey mama13");

        //                touchedX = event.getRawX();
        //                Log.d("hey mama", "hey mama14");
        //                touchedY = event.getRawY();
        //                Log.d("hey mama", "hey mama15");

                        //  updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
                        //  Log.d("hey mama", "hey mama7");
                        //  updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
                        //  Log.d("hey mama", "hey mama8");

                        //   wm.updateViewLayout(ll,updatedParameters);
                        //   Log.d("hey mama", "hey mama9");


          //              break;

          //          case MotionEvent.ACTION_MOVE:




           //             updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
            //            Log.d("hey mama", "hey mama7");
            //            updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
           //             Log.d("hey mama", "hey mama8");

           //             wm.updateViewLayout(playerView,updatedParameters);
         //               Log.d("hey mama", "hey mama9");

                        //   default:
                        //        Log.d("hey mama", "hey mama10");
           //             break;
          //      }
        //        return false;
        //    }
     //   });




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
     //  };


        //setContentView(R.layout.activity_youtube_fragment);
//Log.d("clickable","clickedagain");



     //   YouTubeFragment fragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.fragment_youtube);
      //  fragment.set
      //  playerView = (YouTubePlayerView)findViewById(R.id.player_view);
      //  playerView.initialize(YoutubeConnector.KEY, this);






    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        Log.d("youtubeplayer3","youtubeplayer2");
      if(!b) {
            Log.d("youtubeplayer","youtubeplayer1");

    //  if(YouTubeIntents.canResolvePlayVideoIntentWithOptions(getActivity()))

        //youTubePlayer.play();
      //youTubePlayer.loadVideo(getIntent().getStringExtra("VIDEO_ID"));

       //   layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        //  ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.videoview_main,null);


       //   mPopupWindow = new PopupWindow(container,400,400, true);

        //  mPopupWindow.showAtLocation(relativeLayout,Gravity.NO_GRAVITY,500,500);

          youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID"));

      //      Intent i = new Intent(this, PopUpService.class);
        }
           //  YouTubeIntents yti = new YouTubeIntents();
           // I.createPlayVideoIntent(PopUpService.class,youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID")));
          //  I.create
           //youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID"));
            // putExtra(example,youTubePlayer.cueVideo(getIntent().getStringExtra("VIDEO_ID")));

       //     startService(i);
        }


        @Override
        public void onInitializationFailure (YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult){
            Log.d("fail", String.valueOf(youTubeInitializationResult));
            Toast.makeText(this, getString(R.string.failed), Toast.LENGTH_LONG).show();
        }

    int orgX, orgY;
    int offsetX, offsetY;
  //  @Override
    public boolean onTouch(View v, MotionEvent event) {




            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    orgX = (int) event.getX();
                    orgY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    offsetX = (int) event.getRawX() - orgX;
                    offsetY = (int) event.getRawY() - orgY;




                    //view.update(offsetX, offsetY, -1, -1, true);
                    break;
            }



        return false;
    }

    // private void initializeDraggablePanel() throws Resources.NotFoundException {
       // draggablePanel.setFragmentManager(getSupportFragmentManager());
       // draggablePanel.setTopFragment(placeFragment);
       // draggablePanel.setBottomFragment(mapFragment);
       // draggablePanel.initializeView();
    //}



}
