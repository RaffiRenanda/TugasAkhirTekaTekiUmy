package com.example.tugasakhir.TemanAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.tugasakhir.R;

public class ImgAdapter extends PagerAdapter {
    private Context contex;
    private int[]images = new int[]{R.drawable.ft1, R.drawable.ft2,R.drawable.ft3,R.drawable.ft4};
    public ImgAdapter(Context ctx){
        contex = ctx;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageview = new ImageView(contex);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setImageResource(images[position]);
        container.addView(imageview,0);
        return imageview;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
}
