package com.esseckers.applicationviewsholders.holders;

import android.widget.TextView;

import com.esseckers.applicationviewsholders.R;

import butterknife.Bind;

/**
 * Created by Ivan Danilov on 06.03.2016.
 * Email: id@trinitydigital.ru
 */
public class MainActivityViewHolder extends AbstractActivityViewHolder {

    @Bind(R.id.tv_fragm_one)
    public TextView one;

    @Bind(R.id.tv_main_two)
    public TextView two;

    @Bind(R.id.tv_main_three)
    public TextView three;
}
