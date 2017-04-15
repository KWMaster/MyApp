package com.lvlw.myapp;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.lvlw.myapp.eventmessage.EventMessage;
import com.lvlw.myapp.fragment.GiftFragment;
import com.lvlw.myapp.fragment.HomeFragment;
import com.lvlw.myapp.fragment.MessageFragment;
import com.lvlw.myapp.fragment.MineFragment;
import com.lvlw.myapp.fragment.ShareFragment;
import com.lvlw.myapp.fragment.ShopcartFragment;
import com.lvlw.myapp.fragment.ThemFragment;

//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import solid.ren.skinlibrary.base.SkinBaseActivity;

public class MainActivity extends SkinBaseActivity {

    private static final String TAG = "wiwi";
    @BindView(R.id.content)
    FrameLayout mContent;
    //    @BindView(R.id.rbHome)
    //    RadioButton mRbHome;
    //    @BindView(R.id.rbShop)
    //    RadioButton mRbShop;
    //    @BindView(R.id.rbMessage)
    //    RadioButton mRbMessage;
    //    @BindView(R.id.rbMine)
    //    RadioButton mRbMine;
    //    @BindView(R.id.rgTools)
    //    RadioGroup mRgTools;
    @BindView(R.id.rl_home)
    RelativeLayout mRlHome;
    @BindView(R.id.rl_gift)
    RelativeLayout mRlGift;
    @BindView(R.id.rl_share)
    RelativeLayout mRlShare;
    @BindView(R.id.activity_main)
    DrawerLayout mActivityMain;
    //    @BindView(R.id.bottom_menu)
    //    LinearLayout mBottomMenu;
    @BindView(R.id.rl_create_subject)
    RelativeLayout rlCreateSubject;
    //    @BindView(R.id.appBarLayout)
    //    AppBarLayout appBarLayout;
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.iv_gift)
    ImageView ivGift;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.iv_cooperation)
    ImageView ivCooperation;
    @BindView(R.id.left_drawer)
    FrameLayout leftDrawer;
    @BindView(R.id.main_appBarLayout)
    AppBarLayout mainAppBarLayout;
    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;

    private Fragment[] mFragments;
    private int mIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        setWindowStatus();
        ButterKnife.bind(this);
//        EventBus.getDefault().register(this);
        //        init();
        dynamicAddView(mainToolbar,"background",R.color.main_color);
        initFragment();
    }

    private void init() {
        //        toolbar.inflateMenu(R.menu.toolbar_menu);
        //        toolbar.setNavigationIcon(R.mipmap.ic_menu_white);
        //        toolbar.setTitle("コンパイラ原理");
        //        toolbar.setTitleTextColor(getResources().getColor(R.color.white_normal));
        //        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                if (mActivityMain!=null){
        //                    mActivityMain.openDrawer(Gravity.START);
        //                }
        //            }
        //        });
    }

    private void initFragment() {
        HomeFragment homeFragment = new HomeFragment();
        ShopcartFragment shopcartFragment = new ShopcartFragment();
        MessageFragment messageFragment = new MessageFragment();
        MineFragment mineFragment = new MineFragment();

        //左滑菜单
        GiftFragment giftFragment = new GiftFragment();
        ShareFragment shareFragment = new ShareFragment();
        ThemFragment themFragment = new ThemFragment();


        mFragments = new Fragment[]{homeFragment, shopcartFragment, messageFragment, mineFragment, giftFragment, shareFragment, themFragment};

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, homeFragment).commit();
        setIndexSelected(0);
        mRlHome.setSelected(true);
    }

    @OnClick({/*R.id.rbHome, R.id.rbShop, R.id.rbMessage, R.id.rbMine,*/ R.id.rl_home, R.id.rl_gift, R.id.rl_share, R.id.rl_create_subject})
    public void onClick(View view) {
        switch (view.getId()) {
            /*
            case R.id.rbHome:
                setIndexSelected(0);
                mRlHome.setSelected(true);
                break;
            case R.id.rbShop:
                onLeftMenuItemSelected();
                setIndexSelected(1);
                break;
            case R.id.rbMessage:
                onLeftMenuItemSelected();
                setIndexSelected(2);
                break;
            case R.id.rbMine:
                onLeftMenuItemSelected();
                setIndexSelected(3);
                break;
                */
            //左滑菜单
            case R.id.rl_home:
                mainAppBarLayout.setVisibility(View.GONE);
                onLeftMenuItemSelected();
                //                mRbHome.performClick();
                setIndexSelected(0);
                mRlHome.setSelected(true);
                //                mBottomMenu.setVisibility(View.VISIBLE);
                mActivityMain.closeDrawer(Gravity.LEFT);
                break;
            case R.id.rl_gift:
                initToolbar("礼物");
                mainAppBarLayout.setVisibility(View.VISIBLE);
                onLeftMenuItemSelected();
                setIndexSelected(4);
                mRlGift.setSelected(true);
                //                mBottomMenu.setVisibility(View.GONE);
                mActivityMain.closeDrawer(Gravity.LEFT);
                break;
            case R.id.rl_share:
                initToolbar("分享");
                mainAppBarLayout.setVisibility(View.VISIBLE);
                onLeftMenuItemSelected();
                setIndexSelected(5);
                mRlShare.setSelected(true);
                //                mBottomMenu.setVisibility(View.GONE);
                mActivityMain.closeDrawer(Gravity.LEFT);
                break;
            case R.id.rl_create_subject:
                initToolbar("更换皮肤");
                mainAppBarLayout.setVisibility(View.VISIBLE);
                onLeftMenuItemSelected();
                setIndexSelected(6);
                rlCreateSubject.setSelected(true);
                //                mBottomMenu.setVisibility(View.GONE);
                mActivityMain.closeDrawer(Gravity.LEFT);
                break;
        }
    }

    //    public void changeBottommenuHeight(LinearLayout linearLayout, boolean isvisible) {
    //        if (isvisible) {
    //            ViewGroup.LayoutParams lp = linearLayout.getLayoutParams();
    //            lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
    //        } else {
    //            ViewGroup.LayoutParams lp = linearLayout.getLayoutParams();
    //            lp.height = 0;
    //        }
    //    }

    private void initToolbar(String menuitem) {
        mainToolbar.setNavigationIcon(R.mipmap.ic_menu_white);
        mainToolbar.setTitle(menuitem);
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.white_normal));
        mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mActivityMain != null) {
                    mActivityMain.openDrawer(Gravity.START);
                }
            }
        });
    }

    public void onLeftMenuItemSelected() {
        mRlHome.setSelected(false);
        mRlGift.setSelected(false);
        mRlShare.setSelected(false);
        rlCreateSubject.setSelected(false);
    }

    public void setIndexSelected(int index) {
        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.hide(mFragments[mIndex]);

        if (!mFragments[index].isAdded()) {
            ft.add(R.id.content, mFragments[index]);
        } else {
            ft.show(mFragments[index]);
        }
        ft.commit();

        mIndex = index;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mRbHome.performClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void setGoIndex(EventMessage eventNessage) {
//        Log.d(TAG, "setGoIndex" + eventNessage.getTag());
//        if (eventNessage != null) {
//            int tag = eventNessage.getTag();

            //            if (tag == EventMessage.EventMessageAction.TAG_GO_MAIN) {
            //                mRbHome.performClick();
            //                mRlHome.setSelected(true);
            //                setIndexSelected(0);
            //            } else if (tag == EventMessage.EventMessageAction.TAG_GO_SHOPCART) {
            //                mRbShop.performClick();
            //                setIndexSelected(1);
            //            } else if (tag == EventMessage.EventMessageAction.TAG_GO_MESSAGE) {
            //                mRbMessage.performClick();
            //                setIndexSelected(2);
            //            }
//        }
//    }


    // 设置状态栏
    private void setWindowStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            //            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            // 设置状态栏颜色
            getWindow().setBackgroundDrawableResource(R.color.main_color);
        }
    }

}
