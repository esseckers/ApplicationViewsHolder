package com.esseckers.applicationviewsholders.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esseckers.applicationviewsholders.activity.AbstractActivity;
import com.esseckers.applicationviewsholders.annotation.Layout;
import com.esseckers.applicationviewsholders.holders.AbstractFragmentViewHolder;
import com.esseckers.applicationviewsholders.holders.HoldersFragmentFactory;
import com.esseckers.applicationviewsholders.transit.FragmentAction;
import com.fsm.transit.core.ITransitManager;

import butterknife.ButterKnife;


public abstract class AbstractFragment<T extends AbstractFragmentViewHolder> extends Fragment {

    protected T viewHolder;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getViewLayout(), container, false);
        bindView(view);
        initView(view);
        return view;
    }

    private void bindView(View view) {
        viewHolder = (T) HoldersFragmentFactory.createHolder(this.getClass(), view);
        if (viewHolder == null) {
            ButterKnife.bind(this, view);
        }
    }

    protected void initView(View view) {
    }

    protected int getViewLayout() {
        Layout layout = this.getClass().getAnnotation(Layout.class);
        return layout != null ? layout.value() : 0;
    }

    /**
     * special fragment manager, do all switch use this object.
     *
     * @return instance of {@link ITransitManager}
     */
    public ITransitManager<FragmentAction> getTransitManager() {
        if (getActivity() != null) {
            return ((AbstractActivity) getActivity()).getTransitManager();
        } else {
            return null;
        }
    }
}
