package com.lvlw.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lvlw.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import solid.ren.skinlibrary.SkinLoaderListener;
import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.skinlibrary.loader.SkinManager;

/**
 * Created by Wantrer on 2017/4/5 0005.
 */

public class ThemFragment extends SkinBaseFragment {

    @BindView(R.id.ll_pink)
    LinearLayout llPink;
    @BindView(R.id.ll_red)
    LinearLayout llRed;
    @BindView(R.id.ll_blue)
    LinearLayout llBlue;
    @BindView(R.id.ll_green)
    LinearLayout llGreen;
    @BindView(R.id.ll_brown)
    LinearLayout llBrown;
    @BindView(R.id.ll_black)
    LinearLayout llBlack;
    private DrawerLayout mDrawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_chang_skin, null);
        //Toolbar
        ButterKnife.bind(this, rootView);
//        initToolbar();
        return rootView;
    }

//    private void initToolbar(){
//        Toolbar toolbar= (Toolbar) getActivity().findViewById(R.id.main_toolbar);
//        toolbar.setNavigationIcon(R.mipmap.ic_menu_white);
//        toolbar.setTitle("更换皮肤");
//        toolbar.setTitleTextColor(getResources().getColor(R.color.white_normal));
//        mDrawerLayout= (DrawerLayout) getActivity().findViewById(R.id.activity_main);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mDrawerLayout!=null){
//                    mDrawerLayout.openDrawer(Gravity.START);
//                }
//            }
//        });
//    }
    @OnClick({R.id.ll_pink, R.id.ll_red, R.id.ll_blue, R.id.ll_green, R.id.ll_brown, R.id.ll_black})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_pink:
                SkinManager.getInstance().restoreDefaultTheme();
                break;
            case R.id.ll_red:
                changeSkin("skin_red.skin");
                break;
            case R.id.ll_blue:
                changeSkin("skin_blue.skin");
                break;
            case R.id.ll_green:
                changeSkin("skin_green.skin");
                break;
            case R.id.ll_brown:
                changeSkin("skin_brown.skin");
                break;
            case R.id.ll_black:
                changeSkin("skin_black.skin");
                break;
        }
    }
    private void changeSkin(String skinname){
        SkinManager.getInstance().loadSkin(skinname, new SkinLoaderListener() {
            @Override
            public void onStart() {
//                Toast.makeText(getActivity(), "正在切换中", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess() {
//                Toast.makeText(getActivity(), "切换成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(String errMsg) {
                Toast.makeText(getActivity(), "切换失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgress(int progress) {

            }
        }
        );
    }
}
