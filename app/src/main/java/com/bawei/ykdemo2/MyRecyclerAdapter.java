package com.bawei.ykdemo2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.ykdemo2.bean.Content;
import com.bawei.ykdemo2.bean.Items;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * 作    者：云凯文
 * 时    间：2017/3/2
 * 描    述：
 * 修改时间：
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String titleurl = "http://img.dxycdn.com/avatars/120/";
    private String url = "http://res.dxycdn.com/upload/";
    private Context context;
    private ArrayList<Items> items;
    private ArrayList<Content> clist;

    public MyRecyclerAdapter(Context context, ArrayList<Items> items, ArrayList<Content> clist) {
        this.context = context;
        this.items = items;
        this.clist = clist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.viewitem, null);
            return new ViewHolder1(view);
        } else {
            View view = View.inflate(context, R.layout.viewitem2, null);
            return new ViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ImageLoader instance = ImageLoader.getInstance();
            instance.displayImage(titleurl + items.get(position).getInfoAvatar(), ((ViewHolder1) holder).iv_infoAvatar);
            ((ViewHolder1) holder).tv_nickname.setText(clist.get(position).getNickname());
            ((ViewHolder1) holder).tv_body.setText(clist.get(position).getBody());
        } else if (holder instanceof ViewHolder2) {
            ImageLoader instance = ImageLoader.getInstance();
           instance.displayImage(titleurl + items.get(position).getInfoAvatar(), ((ViewHolder2) holder).iv_infoAvatar);
            ((ViewHolder2) holder).tv_nickname.setText(clist.get(position).getNickname());
            ((ViewHolder2) holder).tv_body.setText(clist.get(position).getBody());
            instance.displayImage(url + clist.get(position).getUrl(), ((ViewHolder2) holder).iv_image);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (clist.get(position).getUrl() == null) {
            return 1;
        } else {
            return 2;
        }
    }

   @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        private ImageView iv_infoAvatar;
        private TextView tv_nickname;
        private TextView tv_body;

        public ViewHolder1(View itemView) {
            super(itemView);
            iv_infoAvatar = (ImageView) itemView.findViewById(R.id.iv_infoAvatar);
            tv_nickname = (TextView) itemView.findViewById(R.id.tv_nickname);
            tv_body = (TextView) itemView.findViewById(R.id.tv_body);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private ImageView iv_infoAvatar;
        private TextView tv_nickname;
        private TextView tv_body;
        private ImageView iv_image;

        public ViewHolder2(View itemView) {
            super(itemView);
            tv_nickname = (TextView) itemView.findViewById(R.id.tv_nickname);
            iv_infoAvatar = (ImageView) itemView.findViewById(R.id.iv_infoAvatar);
            tv_body = (TextView) itemView.findViewById(R.id.tv_body);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }

}
