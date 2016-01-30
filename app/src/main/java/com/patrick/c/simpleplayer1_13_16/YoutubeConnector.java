package com.patrick.c.simpleplayer1_13_16;

import android.content.*;
import android.provider.*;
import android.util.*;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.*;
import com.google.api.client.json.jackson2.*;
import com.google.api.services.youtube.*;
import com.google.api.services.youtube.model.*;

import java.io.*;
import java.util.*;

/**
 * Created by c on 1/2/16.
 */
public class YoutubeConnector {

        private YouTube youtube;
        private YouTube.Search.List query;
        private YouTube.Videos.List video;

        // Your developer key goes here
        public static final String KEY
                = "AIzaSyBtR6Rc_m_9AUXHa9UY9UURbPAuUxlVfZc";

        public YoutubeConnector(Context context) {
            youtube = new YouTube.Builder(new NetHttpTransport(),
                    new JacksonFactory(), new HttpRequestInitializer() {
                @Override
                public void initialize(HttpRequest hr) throws IOException {}
            }).setApplicationName(context.getString(R.string.app_name)).build();



            try{
                query = youtube.search().list("id, snippet");
               // video = youtube.videos().list("id, snippet,statistics, contentDetails");
               // video.setKey(KEY);

               query.setKey(KEY);
               query.setType("video");
                query.setMaxResults((long) 50);
                query.getVideoDuration();

                query.setMaxResults((long)100);
                query.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)");
               // video.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url," +
                    //    "statistics/viewCount,statistics/likeCount,statistics/favoriteCount,statistics/commentCount,contentDetails/duration");

            }catch(IOException e){
                Log.d("YC", "Could not initialize: "+e);
            }
        }

    public List<VideoItem> search(String keywords){
        query.setQ(keywords);
        try{
            SearchListResponse response = query.execute();

          //  VideoListResponse L = video.execute();

         //   List<Video> Lresults = L.getItems();
            List<SearchResult> results = response.getItems();

            List<VideoItem> items = new ArrayList<VideoItem>();
            for(SearchResult result:results){
                VideoItem item = new VideoItem();

                item.setTitle(result.getSnippet().getTitle());

              //  item.setViewCount(result.getVideoId().get);

              item.setDescription(result.getSnippet().getDescription());
                item.setThumbnailURL(result.getSnippet().getThumbnails().getDefault().getUrl());

                item.setId(result.getId().getVideoId());
                items.add(item);
            }


         //   for(Video Lresult:Lresults){
            //    VideoItem item2 = new VideoItem();
            //    item2.setViewCount(Lresult.getStatistics().getViewCount());
            //    item2.setLikeCount(Lresult.getStatistics().getLikeCount());


            //    items.add(item2);
          //  }

            return items;

        }catch(IOException e){
            Log.d("YC", "Could not search: "+e);
            return null;
        }
    }
}
