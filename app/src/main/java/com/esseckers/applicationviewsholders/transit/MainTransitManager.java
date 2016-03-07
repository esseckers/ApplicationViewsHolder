package com.esseckers.applicationviewsholders.transit;

import android.app.Activity;

import com.esseckers.applicationviewsholders.fragment.MainFragment;
import com.esseckers.applicationviewsholders.fragment.StartFragment;
import com.fsm.transit.core.AbstractTransitManager;
import com.fsm.transit.core.TransitData;
import com.fsm.transit.core.TransitResultData;

public class MainTransitManager extends AbstractTransitManager<FragmentAction> {

    {
        transitionsMap.put(new TransitData<FragmentAction>(StartFragment.class, FragmentAction.MAIN), new TransitResultData<FragmentAction>(MainFragment.class, true));
    }

    /**
     * Pass {@link Activity} in args
     *
     * @param activity {@link Activity}
     */
    public MainTransitManager(Activity activity) {
        super(activity);
    }
}
