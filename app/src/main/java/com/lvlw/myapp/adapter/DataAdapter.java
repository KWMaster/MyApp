package com.lvlw.myapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lvlw.myapp.R;
import com.lvlw.myapp.entity.DataBean;
import com.lvlw.myapp.entity.DataInfo;
import com.lvlw.myapp.utils.MyAppImageCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w9859 on 2017/3/14.
 */

    public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataBean> mDatas;
    private LayoutInflater mInflater;
    private RequestQueue mQueue;
    private ImageLoader.ImageCache mImageCache;
    private ImageLoader mImageLoader;
    private ArrayList<DataInfo.Info> list;
    private ArrayList<DataInfo.Info> list2;

    public DataAdapter(Context context,ArrayList<DataInfo.Info> list) {
        super();
        mInflater=LayoutInflater.from(context);
        this.list = list;
        list2=list;
    }

    public DataAdapter(Context context, List<DataBean> datas, RequestQueue queue) {
        super();
        mInflater=LayoutInflater.from(context);
        mDatas = datas;
        mQueue = queue;
        //加载网络图片使用NetworkImageView   begin
        mImageCache=new MyAppImageCache();
        //加载网络图片使用NetworkImageView   end
        mImageLoader=new ImageLoader(mQueue,mImageCache);
    }

    public void loadMore(int page) {
        ArrayList<DataInfo.Info> infos=new ArrayList<>();
        for (DataInfo.Info info : list) {
            infos.add(info);
        }
        list.addAll(infos);
    }

    public  void getFirst(ArrayList<DataInfo.Info> arrayList){
        list.clear();
        list.addAll(arrayList);
    }
//    private void init(List<DataBean> datas) {
//
//    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new DataViewHolder(mInflater.inflate(R.layout.test_fragment_selected_item,parent,false));
        return new DataViewHolder(mInflater.inflate(R.layout.test_fragment_selected_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final DataViewHolder dataViewHolder= (DataViewHolder) holder;
//        dataViewHolder.textView.setText(mDatas.get(position).getName());
        dataViewHolder.textView.setText(list.get(position)._id);
//        ImageLoader imageLoader=new ImageLoader(mQueue,mImageLoader);
//        NetworkImageView networkImageView=dataViewHolder.networkImageView;
//        networkImageView.setDefaultImageResId(android.R.drawable.progress_indeterminate_horizontal);
//        networkImageView.setErrorImageResId(android.R.drawable.ic_menu_report_image);
//        networkImageView.setImageUrl(mDatas.get(position).getPicSmall(),mImageLoader);
//        Log.d(TAG,mDatas.get(position).getPicSmall());


        //加载网络图片 利用ImageRequest    begin  //有双缓存
        //第一个参数就是图片的URL地址,第二个参数是图片请求成功的回调,
        // 第三第四个参数分别用于指定允许图片最大的宽度和高度，如果指定的网络图片的宽度或高度大于这里的最大值，则会对图片进行压缩，指定成0的话就表示不管图片有多大，都不会进行压缩。
        // 第五个参数用于指定图片的颜色属性，Bitmap.Config下的几个常量都可以在这里使用，其中ARGB_8888可以展示最好的颜色属性，每个图片像素占据4个字节的大小，而RGB_565则表示每个图片像素占据2个字节大小。
        // 第六个参数是图片请求失败的回调，
        /*
        ImageRequest imageRequest=new ImageRequest(mDatas.get(position).getPicSmall(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                dataViewHolder.imageView.setTag(bitmap);
                dataViewHolder.imageView.setImageBitmap(bitmap);
            }
        }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                dataViewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
            }
        });
        mQueue.add(imageRequest);
        */
        //加载网络图片 利用ImageRequest    end  //有双缓存
//        dataViewHolder.imageView.setImageURI(mDatas.get(position).getPicSmall());
        dataViewHolder.imageView.setImageURI(list.get(position).url);
    }


    /**
     *
     * @return item的个数，最好加个为空判断。
     */
    @Override
    public int getItemCount() {
//        return mDatas!=null?mDatas.size():0;
        return list!=null?list.size():0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        //加载网络图片使用NetworkImageView   begin
//        NetworkImageView networkImageView;
        SimpleDraweeView imageView;

        //加载网络图片使用NetworkImageView   end
        public DataViewHolder(View itemView) {
            super(itemView);
            //完成Item View 和ViewHolder里属性的绑定，begin
            textView = (TextView) itemView.findViewById(R.id.item_name);
            //加载网络图片使用NetworkImageView   begin
            imageView = (SimpleDraweeView) itemView.findViewById(R.id.item_image);
            //加载网络图片使用NetworkImageView   end
            //完成Item View 和ViewHolder里属性的绑定，end
        }
    }

}
