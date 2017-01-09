package com.eueh.openeye;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.concern.ConcernFragment;
import com.eueh.openeye.downloadservice.DownLoadService;
import com.eueh.openeye.find.FindFragment;
import com.eueh.openeye.mine.MineFragment;
import com.eueh.openeye.selection.selection_main.SelectionFragment;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private FrameLayout frameLayout;
    private RadioButton rbtSelection, rbtFind, rbtConcern, rbtMine;
    private Intent intent;


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

        //悬浮按钮
        ImageView icon = new ImageView(this);
        icon.setImageResource(R.mipmap.photome);

        FloatingActionButton actionButton = new FloatingActionButton
                .Builder(this).setContentView(icon).build();

        actionButton.setScaleX(0.6f);
        actionButton.setScaleY(0.6f);
        actionButton.setX(-1f);
        actionButton.setY(-60f);



        SubActionButton.Builder itemBuilder = new
                SubActionButton.Builder(this);

        ImageView itemIconPhoto = new ImageView(this);
        ImageView itemIconSay = new ImageView(this);
        ImageView itemIconFind = new ImageView(this);


        itemIconPhoto.setImageResource(R.mipmap.email_filling);
        itemIconSay.setImageResource(R.mipmap.sayme);
        itemIconFind.setImageResource(R.mipmap.findme);

        SubActionButton buttonPhoto = itemBuilder.setContentView(itemIconPhoto).build();
        SubActionButton buttonSay = itemBuilder.setContentView(itemIconSay).build();
        SubActionButton buttonFind = itemBuilder.setContentView(itemIconFind).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonPhoto)
                .addSubActionView(buttonSay)
                .addSubActionView(buttonFind)
                .attachTo(actionButton)
                .build();


    }

    @Override
    public void initData() {

        intent = new Intent(this, DownLoadService.class);
        startService(intent);

    }

    public void replace(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl, fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
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
