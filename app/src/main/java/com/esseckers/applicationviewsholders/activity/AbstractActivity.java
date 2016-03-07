package com.esseckers.applicationviewsholders.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.esseckers.applicationviewsholders.holders.AbstractActivityViewHolder;
import com.esseckers.applicationviewsholders.transit.FragmentAction;
import com.fsm.transit.core.ITransitManager;

public abstract class AbstractActivity<T extends AbstractActivityViewHolder> extends AppCompatActivity {

    protected ITransitManager<FragmentAction> transitManager;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(getActivityLayoutRes());

        createTransitManager();
        if (getTransitManager() != null) {
            getTransitManager().setCurrentContainer(getMainFragmentContainerRes());
        }
        if (savedInstanceState == null) {
            Class<? extends Fragment> clazz = getFragmentForStart();
            if (clazz != null && getTransitManager() != null) {
                getTransitManager().switchFragment(getFragmentForStart(), getIntent().getExtras(), false);
            }
        }
        initView();
    }

    protected void initView() {
    }

    protected Class<? extends Fragment> getFragmentForStart() {
        return null;
    }

    public ITransitManager<FragmentAction> getTransitManager() {
        return transitManager;
    }

    protected abstract void createTransitManager();

    protected abstract int getActivityLayoutRes();

    protected abstract int getMainFragmentContainerRes();

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1 && getTransitManager() != null)
            getTransitManager().back();
        else
            finish();
    }

    /**
     * start main activity and finish current
     */
    public void runStartActivity() {
        runActivity(null, StartActivity.class);
    }

    /**
     * start main activity and finish current
     */
    public void runMainActivity() {
        runActivity(null, MainActivity.class);
    }

    /**
     * run main activity and finish current
     *
     * @param bundle
     */
    private void runActivity(Bundle bundle, Class<? extends AbstractActivity> aClass) {
        Intent intent = new Intent(this, aClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

}
