package com.example.arunr.hungamavideo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arunr.hungamavideo.Model.Movie;
import com.example.arunr.hungamavideo.Model.MovieResponse;
import com.example.arunr.hungamavideo.Rest.ApiClient;
import com.example.arunr.hungamavideo.Rest.ApiInterface;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class MainActivity extends AppCompatActivity {

    private final static String Url = "https://n-pvt.hungama.com/v2/content/movieapp/queue_data.json?device=1080x1920&section_id=1&genre=Gossip&bucket_id=5360&offset=0&user_type=1&version=2.0.10.7&app-id=e3MH8F20cr&limit=30&cp=33682232";
    private static ViewPager pager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ImagesArray.addAll(Arrays.asList(IMAGES));

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new SlidingImage_Adapter(MainActivity.this, ImagesArray));

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

        final float density = getResources().getDisplayMetrics().density;

        // Set circle indicator radius
        indicator.setRadius(5 * density);
        NUM_PAGES = IMAGES.length;

        // Auto start of view pager
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
