package somani.siddharth.tophawkstraining;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;


public class CustomSwipeAdapter extends PagerAdapter {

    private Context ctx;
    private List<SlidesPojo> slides;
    private LayoutInflater layoutInflater;
    Firebase mDatabase1;
    Firebase mDatabase2;
    String no;
    int arr[]=new int[10000];static int i=0;
    public CustomSwipeAdapter(Context ctx,List<SlidesPojo> slides)
    {
        this.ctx=ctx;
        this.slides=slides;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        Firebase.setAndroidContext(ctx);
//        //Video
//        String str="https://firebasestorage.googleapis.com/v0/b/swipeimplementation.appspot.com/o/Nikon%20D7500-%20Time-lapse%20sample%20video.mp4?alt=media&token=3ae5b5b0-c72e-4ea1-9b87-e4442870b1ed";
//        Uri uri = Uri.parse(str);
//        VideoView mVideoView= (VideoView)findViewById(R.id.VideoView);
//        final ProgressBar progressBarLandScape=(ProgressBar)findViewById(R.id.progressbar);
//
//        mVideoView.setVideoURI(uri);
//        progressBarLandScape.setVisibility(View.VISIBLE);
//        mVideoView.requestFocus();
//        mVideoView.start();
//
//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                mp.setLooping(true);
//            }
//        });
//
//        mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
//            @Override
//            public boolean onInfo(MediaPlayer mp, int what, int extra) {
//                if (what == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
//                    return true;
//                }
//                else if(what == MediaPlayer.MEDIA_INFO_BUFFERING_START){
//                    return true;
//                }
//                return false;
//            }
//        });
        /*String str="https://firebasestorage.googleapis.com/v0/b/videoplay-e370a.appspot.com/o/Nikon%20D7500-%20Time-lapse%20sample%20video.mp4?alt=media&token=58cdbd51-a96f-481c-80b1-b755928ace58";
        Uri uri = Uri.parse(str);*/
        SlidesPojo slidesPojo = slides.get(position);
        ImageView imageView= (ImageView) item_view.findViewById(R.id.image_view);
        TextView textView= (TextView) item_view.findViewById(R.id.image_count);
        TextView textView2= (TextView) item_view.findViewById(R.id.image_info);
       /* final VideoView mVideoView= (VideoView)item_view.findViewById(R.id.VideoView);
        final ProgressBar progressBarLandScape=(ProgressBar)item_view.findViewById(R.id.progressbar);*/

        //Toast.makeText(ctx,Integer.toString(arr[0]),Toast.LENGTH_LONG).show();
        //Toast.makeText(ctx,Integer.toString(slides.size()),Toast.LENGTH_LONG).show();
        Glide.with(ctx).load(slidesPojo.getUrl()).into(imageView);
        textView.setText(slidesPojo.getHeading());
        textView2.setText(slidesPojo.getInfo());
       /* progressBarLandScape.setVisibility(View.VISIBLE);
        MediaController mediaController = new MediaController(ctx);
        mediaController.setAnchorView(mVideoView);
        mVideoView.setMediaController(mediaController);
        //mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample));
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
            }
        });
       int c=1;
        if(c==1)
        {
            imageView.setVisibility(View.GONE);
            progressBarLandScape.setVisibility(View.GONE);
            mVideoView.setVisibility(View.VISIBLE);
        }
        else if(c!=1)
        {
            imageView.setVisibility(View.VISIBLE);
            mVideoView.setVisibility(View.GONE);
            progressBarLandScape.setVisibility(View.GONE);
        }
*/

        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
    @Override
    public int getCount() {
        //return arr[0] ;
        // Toast.makeText(ctx,"Hello",Toast.LENGTH_LONG).show();
        no = Modules.no;
        //Toast.makeText(ctx, no, Toast.LENGTH_LONG).show();
       // if (Integer.parseInt(no) != 0)
            return Integer.parseInt(no);

        // return 2;
    }
}

