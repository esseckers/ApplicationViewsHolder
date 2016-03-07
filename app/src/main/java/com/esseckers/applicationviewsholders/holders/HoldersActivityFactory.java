package com.esseckers.applicationviewsholders.holders;

import android.view.View;

import com.esseckers.applicationviewsholders.activity.AbstractActivity;
import com.esseckers.applicationviewsholders.activity.MainActivity;

/**
 * Created by Ivan Danilov on 06.03.2016.
 * Email: id@trinitydigital.ru
 */
public class HoldersActivityFactory {

    public static AbstractActivityViewHolder createHolder(Class<? extends AbstractActivity> aClass, View view) {
        AbstractActivityViewHolder viewHolder = null;
        if (aClass.equals(MainActivity.class)) {
            viewHolder = new MainActivityViewHolder();
        }
        if (viewHolder != null) {
            viewHolder.bind(view);
        }
        return viewHolder;
    }
}
