package com.patrick.c.simpleplayer1_13_16;

import android.app.*;
import android.app.Activity;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v7.app.*;
import android.support.v7.widget.SearchView;
import android.util.*;
import android.view.*;
import android.widget.*;

import com.google.android.gms.appindexing.*;
import com.google.android.gms.appindexing.AppIndex;

import com.google.android.gms.appindexing.AppIndex.*;
import com.google.android.gms.auth.api.*;
import com.google.android.gms.auth.api.signin.*;
import com.google.android.gms.common.*;
import com.google.android.gms.common.api.*;
import com.google.android.gms.common.api.GoogleApiClient.*;
//import com.google.android.gms.games.video.*;
import com.google.android.youtube.player.*;
import com.google.api.services.youtube.model.*;
import com.squareup.picasso.*;

import java.util.*;



/**
 * Created by c on 1/2/16.
 */
public class SearchActivity extends AppCompatActivity implements OnConnectionFailedListener, ConnectionCallbacks
 {

    private static final int RC_SIGN_IN = 9001;
    private EditText searchInput;
    private ListView videosFound;
    private android.support.v7.widget.Toolbar Toolbar;
    private Button Sign_in;
    private GoogleApiClient mGoogleApiClient;
     private LinearLayout ll;
     private VideoView vv;
     private Video mVideo;
     public static final String KEY_VIDEO_ID = "VIDEO_ID";




    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        android.support.v7.widget.Toolbar Toolbar =
                (android.support.v7.widget.Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(Toolbar);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // ATTENTION: This "addApi(AppIndex.API)"was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mGoogleApiClient = new Builder(this)
                //.enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addOnConnectionFailedListener(this)
                //    .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) )
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .addApi(AppIndex.API).build();


        //searchInput = (EditText)findViewById(R.id.);
        videosFound = (ListView) findViewById(R.id.videos_found);

        handler = new Handler();
       // searchOnYoutube("hello");
       // ll = new LinearLayout(this);
       // vv = new VideoView(this);


        //    Button Sign_in = (Button)findViewById(R.id.sign_in_button);
        //   Sign_in.setEnabled(true);
        //    Sign_in.setOnClickListener(new View.OnClickListener() {
        //         @Override
        //         public void onClick(View v) {

        //            switch (v.getId()) {
        //                 case R.id.sign_in:
        //                      signIn();
        //                      break;


        //   }


        // }



       /* searchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_DONE){
                    searchOnYoutube(v.getText().toString());
                    return false;
                }
                return true;
            }


        });
        */


        //   });

        addClickListener();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onstart", "onstart");
        mGoogleApiClient.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Search Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.patrick.c.simpleplayer1_13_16/http/host/path")
        );
        AppIndex.AppIndexApi.start(mGoogleApiClient, viewAction);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Search Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.patrick.c.simpleplayer1_13_16/http/host/path")
        );
        AppIndex.AppIndexApi.end(mGoogleApiClient, viewAction);
        mGoogleApiClient.disconnect();
    }

    private void signIn() {
        Log.d("sign in", "sign in");
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient );
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    //private void setSupportActionBar(Toolbar myToolbar) {
    //}

    private List<VideoItem> searchResults;

    private void searchOnYoutube(final String keywords){
        new Thread(){
            public void run(){
                YoutubeConnector yc = new YoutubeConnector(SearchActivity.this);
                searchResults = yc.search(keywords);
                handler.post(new Runnable(){
                    public void run(){
                        updateVideosFound();
                    }
                });
            }
        }.start();
    }


    private void updateVideosFound(){
        ArrayAdapter<VideoItem> adapter = new ArrayAdapter<VideoItem>(getApplicationContext(), R.layout.video_item, searchResults){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.video_item, parent, false);
                }
                ImageView thumbnail = (ImageView)convertView.findViewById(R.id.video_thumbnail);
                TextView title = (TextView)convertView.findViewById(R.id.video_title);
                TextView description = (TextView)convertView.findViewById(R.id.video_description);

                VideoItem searchResult = searchResults.get(position);

                Picasso.with(getApplicationContext()).load(searchResult.getThumbnailURL()).into(thumbnail);
              title.setText(searchResult.getTitle());
                description.setText(searchResult.getDescription());
                return convertView;
            }
        };

        videosFound.setAdapter(adapter);
    }


//     public void startMethod() {

  //       Intent i = new Intent(this, PopUpService.class );
  //       startService(i);
 //        Intent intent = new Intent(getApplicationContext(), Custompopupactivity.class);
   //       intent.putExtra(Custompopupactivity.KEY_VIDEO_ID,searchResults.get(position).getId());
  //           startActivity(intent);
    //         Log.d("test","clicked");



    // }



    private void addClickListener(){
        videosFound.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  Log.d("test","clickedggggggggg");

      //          startMethod();

                //Intent i = new Intent(this, PopUpService.class );
                //startService(i);

               // Intent intent1 = YouTubeStandalonePlayer.createVideoIntent((Activity) getApplicationContext(), YoutubeConnector.KEY, "VIDEO_ID");
               // startActivity(intent1);
                Intent intent = new Intent(getApplicationContext(), PlayerActivity.class);
                intent.putExtra("VIDEO_ID", searchResults.get(position).getId());
                startActivity(intent);
                Log.d("test","clicked");


            }});}


     //   final WindowManager wm;







           //     wm = (WindowManager) getSystemService(WINDOW_SERVICE);










           //     final WindowManager.LayoutParams params = new WindowManager.LayoutParams(400,400, WindowManager.LayoutParams.TYPE_PHONE,
           //             WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);

           //     vv = (VideoView)findViewById(R.id.VideoView);
               // vv.setLayoutParams(params);
               // vv.start();



          //      ll.setBackgroundColor(Color.argb(66,255,0,0));
          //      ll.setLayoutParams(params);



          //      params.x = 0;
          //      params.y = 0;
          //      params.gravity = Gravity.CENTER | Gravity.CENTER;

          //      wm.addView(ll,params);
                //wm.addView(new VideoView(this)), params);

          //      ll.setOnTouchListener(new View.OnTouchListener() {

          //      private WindowManager.LayoutParams updatedParameters = params;
           //         int x, y;
          //          float touchedX, touchedY;

          //          @Override
          //          public boolean onTouch(View v, MotionEvent event) {

          //            switch (event.getAction() ) {

          //               case MotionEvent.ACTION_DOWN:
          //                   Log.d("hey mama", "hey mama11");

         //             x = updatedParameters.x;
          //                   Log.d("hey mama", "hey mama12");

          //              y= updatedParameters.y;
           //                   Log.d("hey mama", "hey mama13");

         //           touchedX = event.getRawX();
          //                  Log.d("hey mama", "hey mama14");
         //             touchedY = event.getRawY();
          //                  Log.d("hey mama", "hey mama15");

                           //  updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
                           //  Log.d("hey mama", "hey mama7");
                           //  updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
                           //  Log.d("hey mama", "hey mama8");

                          //   wm.updateViewLayout(ll,updatedParameters);
                          //   Log.d("hey mama", "hey mama9");


          //                   break;

          //                  case MotionEvent.ACTION_MOVE:



//                                updatedParameters.x = (int)(x + (event.getRawX() - touchedX));
//                               Log.d("hey mama", "hey mama7");
  //                            updatedParameters.y = (int) (y + (event.getRawY() - touchedY));
  //                            Log.d("hey mama", "hey mama8");

    //                         wm.updateViewLayout(ll,updatedParameters);
 //                            Log.d("hey mama", "hey mama9");

  //                      default:
                        //        Log.d("hey mama", "hey mama10");
 //                              break;
   //                     }



     //                   return false;
     //               }
     //           });




                // LinearLayout linearLayoutCompatLayout = (LinearLayout) findViewById(R.id.linear_layout_searchview);

                //relativeLayout = (RelativeLayout)findViewById(R.id.)


              //  LayoutInflater layoutInflater =
              //          (LayoutInflater)getBaseContext()
             //                   .getSystemService(LAYOUT_INFLATER_SERVICE);
              //  ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup,null);


                //Log.d("test","LayoutInflater");

              //  View popupView = layoutInflater.inflate(R.layout.popup, null);
              //  final PopupWindow popupWindow = new PopupWindow(
               //         popupView, 500, 500,true);

               // Log.d("test", "beforeshowatLocation");



               // popupWindow.showAtLocation(linearLayoutCompatLayout, Gravity.NO_GRAVITY, 500,500 );

                //Log.d("test", "aftershowatLocation");
                //popupView.setOnTouchListener(new View.OnTouchListener() {
               //     int orgX, orgY;
                 //   int offsetX, offsetY;

                 //   @Override
                 //   public boolean onTouch(View v, MotionEvent event) {
                 //       switch (event.getAction()) {
                 //           case MotionEvent.ACTION_DOWN:
                 //               orgX = (int) event.getX();
                  //              orgY = (int) event.getY();
                 //               break;
                //            case MotionEvent.ACTION_MOVE:
                //                offsetX = (int)event.getRawX() - orgX;
                //                offsetY = (int)event.getRawY() - orgY;
               //                 popupWindow.update(offsetX, offsetY, -1, -1, true);
               //                 break;
               //         }
              //          return true;
             //       }});




          //       Intent intent = new Intent(getApplicationContext(), Custompopupactivity.class);
          //     intent.putExtra(Custompopupactivity.KEY_VIDEO_ID,searchResults.get(position).getId());
           //     startActivity(intent);
           //     Log.d("test","clicked");

    //        }
    //    });

        //"VIDEO_ID"



  //  }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //handleSignInResult(result);
        }
    }

    //private void handleSignInResult(GoogleSignInResult result) {
    //    Log.d(TAG, "handleSignInResult:" + result.isSuccess());
    //    if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
   //         GoogleSignInAccount acct = result.getSignInAccount();
   //         mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
   //         updateUI(true);
   //     } else {
            // Signed out, show unauthenticated UI.
  //          updateUI(false);
  //      }
  //  }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        Log.d("hello", "hello");
        searchView.setQueryHint("Search: ");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

     searchView.setOnSearchClickListener(new View.OnClickListener() {
          @Override
         public void onClick(View v) {
            Log.d("click", "click");



           }


      });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("click", "click2");

                searchOnYoutube(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("click", "click1");
                searchOnYoutube(newText);
                return true;
            }
        });











        return true;
    }
















        //
        // .setIconifiedByDefault(true);

   //  searchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
   //         @Override
    //        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
   //             return false;
    //       }





          //      searchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
          //  @Override
         //   public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

           //     if(actionId == EditorInfo.IME_ACTION_DONE){
           //         searchOnYoutube(v.getText().toString());
           //         return false;
           //     }
           //     return true;
          //  }



        //getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;

       // return true;}

  @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       //  Handle action bar item clicks here. The action bar will
       //  automatically handle clicks on the Home/Up button, so long
       //  as you specify a parent activity in AndroidManifest.xml.
       int id = item.getItemId();

        //noinspection SimplifiableIfStatement

      switch (item.getItemId()) {

          case R.id.action_settings :
              return true;

          case R.id.sign_in_button :
              Log.d("sign_in_button","sign in button");
              signIn();
              return true;

          case R.id.sign_in:
              Log.d("sign_in_button1","sign in button1");
              signIn();
              return true;


          // if (id == R.id.action_settings) {

          // }

          default:
          return super.onOptionsItemSelected(item);
      }
  }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}









