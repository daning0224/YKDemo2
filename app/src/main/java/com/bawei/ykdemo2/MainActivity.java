package com.bawei.ykdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bawei.ykdemo2.bean.Bean;
import com.bawei.ykdemo2.bean.Content;
import com.bawei.ykdemo2.bean.Items;
import com.bawei.ykdemo2.util.OkHttpFramework;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private XRecyclerView xRecyclerView;
    private ArrayList<Content> clist = new ArrayList<>();//第二层的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        xRecyclerView = (XRecyclerView) findViewById(R.id.xRecyclerView);
        //网络请求
        requestData();

    }

    private void requestData() {
        String url = "http://i.dxy.cn/snsapi/home/feeds/list/all?" +
                "sid=4df0360f-2a20-4198-beb8-4dc5660c4f08&u=zhetianyishou&s=" +
                "10&mc=0000000049029dcaffffffff99d603a9&token=" +
                "TGT-13165-buaw5fHpqLlefw9bSOB0oF41fobaV4rMZmK-50&hardName=" +
                "iToolsAVM_T0008098S&ac=4124c5f1-2029-4fda-b06f-a87ac5ad8d11&bv=" +
                "2013&vc=6.0.6&tid=c25e673d-e82a-4e46-bd4e-c1e86d497126" +
                "&vs=4.4.4&ref_tid=54720e1a-7eed-4993-9f51-3d760f3d0b2e";

        HashMap<String, String> map = new HashMap<>();
        //将请求的路径和实体类传递给Okhttp工具类
        App.okHttpFramework.setUrl(url, map, Bean.class, OkHttpFramework.Methods.GET);
        //回调请求并解析好的数据
        App.okHttpFramework.setCallbackM(new OkHttpFramework.CallbackM() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Object response) {
                Bean bean = (Bean) response;
                ArrayList<Items> items = bean.getItems();//第一层的集合

                for (int i = 0; i < items.size(); i++) {
                    Gson gson = new Gson();
                    Content content = gson.fromJson(items.get(i).getContent(), Content.class);
                    clist.add(content);
                }
                //LayoutManager
                xRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                //适配器
                MyRecyclerAdapter adapter = new MyRecyclerAdapter(MainActivity.this, items,clist);
                xRecyclerView.setAdapter(adapter);
            }
        });
    }
}


