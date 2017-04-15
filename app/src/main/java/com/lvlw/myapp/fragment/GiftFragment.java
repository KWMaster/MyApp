package com.lvlw.myapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lvlw.myapp.R;

import solid.ren.skinlibrary.base.SkinBaseFragment;


/**
 * 送礼物界面
 * @author ansen	
 * @create time 2016-04-19
 */
public class GiftFragment extends SkinBaseFragment {
	private TextView tvContent;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View rootView= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_gift, null);
		tvContent=(TextView) rootView.findViewById(R.id.tv_content);
//		initToolbar();
		return rootView;
	}
//	private void initToolbar(){
//		Toolbar toolbar= (Toolbar) getActivity().findViewById(R.id.main_toolbar);
//		toolbar.setNavigationIcon(R.mipmap.ic_menu_white);
//		toolbar.setTitle("礼物");
//		toolbar.setTitleTextColor(getResources().getColor(R.color.white_normal));
//		final DrawerLayout drawerLayout= (DrawerLayout) getActivity().findViewById(R.id.activity_main);
//		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				if (drawerLayout!=null){
//					drawerLayout.openDrawer(Gravity.START);
//				}
//			}
//		});
//	}
}
