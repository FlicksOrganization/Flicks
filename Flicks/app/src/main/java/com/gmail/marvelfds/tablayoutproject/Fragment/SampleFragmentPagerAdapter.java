package com.gmail.marvelfds.tablayoutproject.Fragment;

/**
 * Created by gaetanejulmiste on 6/30/16.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.gmail.marvelfds.tablayoutproject.Fragment.NowPlaying_Fragment.newInstance;

/**
 * Created by Core i7 on 6/23/2016.
 */
public  class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "TOP 10", "NOW PLAYING", "COMING SOON" };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
       if (position == 0) {
            return NowPlaying_Fragment.newInstance(0);
                    //new NowPlaying_Fragment();
        }else if (position == 1){
            return  ComingSoon_Fragment.newInstance(1)  ;
                    //new ComingSoon_Fragment();
        }else if (position==2) {
            return Top10_Fragment.newInstance(2);
           //new Top10_Fragment();
        }else {
            return null;
        }
       // return newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}