package com.esseckers.applicationviewsholders.holders;

import android.view.View;

import com.esseckers.applicationviewsholders.fragment.AbstractFragment;
import com.esseckers.applicationviewsholders.fragment.MainFragment;

public class HoldersFragmentFactory {

    public static AbstractFragmentViewHolder createHolder(Class<? extends AbstractFragment> aClass, View view) {
        AbstractFragmentViewHolder viewHolder = null;
        if (aClass.equals(MainFragment.class)) {
            viewHolder = new MainFragmentViewHolder();
        }
        if (viewHolder != null) {
            viewHolder.bind(view);
        }
        return viewHolder;
    }
}
