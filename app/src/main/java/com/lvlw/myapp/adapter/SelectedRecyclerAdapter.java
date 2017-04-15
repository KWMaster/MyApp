package com.lvlw.myapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lvlw.myapp.R;
import com.lvlw.myapp.entity.SelectedArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * 精选列表适配器
 * Created by w9859 on 2017/3/12.
 */

public class SelectedRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<SelectedArticle> mSelectedArticles;
    private LayoutInflater mInflater;

    public SelectedRecyclerAdapter(Context context) {
        super();
        mInflater=LayoutInflater.from(context);
        mSelectedArticles=new ArrayList<>();
        initData();
    }

    private void initData() {
        for (int i=0;i<10;i++){
            SelectedArticle selectedArticle=new SelectedArticle(i,"RecyclerView精选片段",i,i,"");
            mSelectedArticles.add(selectedArticle);
        }
    }

    public void loadMore(int page) {
        for (int i=0;i<5;i++){
            SelectedArticle selectedArticle=new SelectedArticle(i,"第"+page+"页数据",i,i,"");
            mSelectedArticles.add(selectedArticle);
        }
    }

    public  void getFirst(){
        mSelectedArticles.clear();
        initData();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        SelectedRecyclerHolder holder= (SelectedRecyclerHolder) viewHolder;
        SelectedArticle selectedArticle=mSelectedArticles.get(position);
        holder.title.setText(selectedArticle.getTitle());
        holder.like.setText(""+selectedArticle.getLikeNumber());
        holder.comment.setText(""+selectedArticle.getCommentNumber());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.fragment_selected_item,null);
        return new SelectedRecyclerHolder(view);
    }

    @Override
    public int getItemCount() {
        return mSelectedArticles.size();
    }

    public  class SelectedRecyclerHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView like;
        private TextView comment;

        public SelectedRecyclerHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.tv_title);
            like= (TextView) itemView.findViewById(R.id.tv_like);
            comment= (TextView) itemView.findViewById(R.id.tv_comment);
        }
    }
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}
