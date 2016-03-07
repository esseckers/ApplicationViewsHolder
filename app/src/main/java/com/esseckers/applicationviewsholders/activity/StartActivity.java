package com.esseckers.applicationviewsholders.activity;

import com.esseckers.applicationviewsholders.R;
import com.esseckers.applicationviewsholders.transit.StartTransitManager;

/**
 * Created by Ivan Danilov on 07.03.2016.
 * Email: id@trinitydigital.ru
 */
public class StartActivity extends AbstractActivity {

    @Override
    protected void createTransitManager() {
        transitManager = new StartTransitManager(this);
    }

    @Override
    protected int getActivityLayoutRes() {
        return R.layout.activity_start;
    }

    @Override
    protected int getMainFragmentContainerRes() {
        return R.id.fragment_container;
    }
}
