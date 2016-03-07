package com.esseckers.applicationviewsholders.holders;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Ivan Danilov on 06.03.2016.
 * Email: id@trinitydigital.ru
 */
public abstract class AbstractActivityViewHolder {

    public AbstractActivityViewHolder() {
    }

    protected void bind(View view) {
        ButterKnife.bind(this, view);
    }
}
