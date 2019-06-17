package com.example.vidzo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<Slide> slideList;
    private ViewPager sliderviewpager;
    private TabLayout indicator;
    private RecyclerView movieRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerview=findViewById(R.id.Rv_movie);

        //slider
        indicator=findViewById(R.id.indicator);

        sliderviewpager=findViewById(R.id.slider_pager);

        slideList = new ArrayList<>();
        slideList.add(new Slide(R.drawable.slide1,"Wolverine"));
        slideList.add(new Slide(R.drawable.slide2,"Civil War"));
        slideList.add(new Slide(R.drawable.slide3,"Fift Shades of Grey"));
        slideList.add(new Slide(R.drawable.slide4,"Twilight Saga"));

        Sliderpageradapter sliderpageradapter =  new Sliderpageradapter(this,slideList);

        sliderviewpager.setAdapter(sliderpageradapter);

        Timer timer= new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,6000);

        indicator.setupWithViewPager(sliderviewpager,true);
        //end slider

        //start popular movies recycler view

        List<Movie> movieList= new ArrayList<>();
        movieList.add(new Movie("VAULT",R.drawable.t1));
        movieList.add(new Movie("AFTERMATH",R.drawable.t2));
        movieList.add(new Movie("MOLLYWOOD",R.drawable.t3));
        movieList.add(new Movie("DEADWOOD",R.drawable.t4));
        movieList.add(new Movie("AVENGEMENT",R.drawable.t5));
        movieList.add(new Movie("PETS 2",R.drawable.t6));
        movieList.add(new Movie("LA LLORONA",R.drawable.t7));
        movieList.add(new Movie("CONVENT",R.drawable.t8));

        MovieAdapter movieAdapter = new MovieAdapter(this,movieList);
        movieRecyclerview.setAdapter(movieAdapter);
        movieRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }

    class SliderTimer extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderviewpager.getCurrentItem()<slideList.size()-1){
                        sliderviewpager.setCurrentItem(sliderviewpager.getCurrentItem()+1);
                    }
                    else
                        sliderviewpager.setCurrentItem(0);
                }
            });
        }
    }
}
