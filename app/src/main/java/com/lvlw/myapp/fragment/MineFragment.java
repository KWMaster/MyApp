package com.lvlw.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lvlw.myapp.R;
import com.lvlw.myapp.eventmessage.EventMessage;

//import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by w9859 on 2017/3/10.
 */

public class MineFragment extends Fragment {
    //重命名参数设置中的参数，选择匹配的参数名
    //初始化fragment的参数设置，比如参数个数
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //重命名和选择参数的类型
    private String mParam1;
    private String mParam2;
    @BindView(R.id.btnGoHome)
    Button mBtnGoHome;
    @BindView(R.id.btnGoShopCart)
    Button mBtnGoShopCart;
    @BindView(R.id.btnGoMessage)
    Button mBtnGoMessage;

    public MineFragment() {

    }

    /**
     * 根据已经提供的参数去用机械化的方法创建新的fragment实例
     *
     * @param param1
     * @param param2
     * @return MineFragment的一个新的fragment实例
     */
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.btnGoHome, R.id.btnGoShopCart, R.id.btnGoMessage})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGoHome:
                goSelect(EventMessage.EventMessageAction.TAG_GO_MAIN);
                break;
            case R.id.btnGoShopCart:
                goSelect(EventMessage.EventMessageAction.TAG_GO_SHOPCART);
                break;
            case R.id.btnGoMessage:
                goSelect(EventMessage.EventMessageAction.TAG_GO_MESSAGE);
                break;
        }
    }

    private void goSelect(int tag) {
        EventMessage eventMessage=new EventMessage();
        eventMessage.setTag(tag);
//        EventBus.getDefault().post(eventMessage);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
