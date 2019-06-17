package com.example.vidzo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Sliderpageradapter extends PagerAdapter {


    private Context mContext;
    private List<Slide> mList;

    public Sliderpageradapter(Context mContext, List<Slide> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }



    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayoutView=  inflater.inflate(R.layout.slider_item,null);

        ImageView  imageView=  slideLayoutView.findViewById(R.id.slie_img);
        TextView textView=slideLayoutView.findViewById(R.id.tvslide_title);

        imageView.setImageResource(mList.get(position).getImage());
        textView.setText(mList.get(position).getTitle());

        container.addView(slideLayoutView);
        return slideLayoutView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
