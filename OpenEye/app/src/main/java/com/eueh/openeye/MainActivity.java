package com.eueh.openeye;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.concern.ConcernFragment;
import com.eueh.openeye.find.FindFragment;
import com.eueh.openeye.mine.MineFragment;
import com.eueh.openeye.selection.selection_main.SelectionFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private FrameLayout frameLayout;
    private RadioButton rbtSelection, rbtFind, rbtConcern, rbtMine;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        rbtSelection = (RadioButton) findViewById(R.id.rbt_selection);
        rbtFind = (RadioButton) findViewById(R.id.rbt_find);
        rbtConcern = (RadioButton) findViewById(R.id.rbt_concern);
        rbtMine = (RadioButton) findViewById(R.id.rbt_mine);

        rbtSelection.setOnClickListener(this);
        rbtMine.setOnClickListener(this);
        rbtConcern.setOnClickListener(this);
        rbtFind.setOnClickListener(this);

        replace(new SelectionFragment());
    }

    @Override
    public void initData() {

    }

    public void replace(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.rbt_selection:
                replace(new SelectionFragment());
                break;

            case R.id.rbt_find:
                replace(new FindFragment());
                break;

            case R.id.rbt_concern:
                replace(new ConcernFragment());
                break;

            case R.id.rbt_mine:
                replace(new MineFragment());
                break;
        }
    }
}
