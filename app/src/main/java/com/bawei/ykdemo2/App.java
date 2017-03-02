package com.bawei.ykdemo2;

import android.app.Application;

import com.bawei.ykdemo2.util.OkHttpFramework;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 作    者：云凯文
 * 时    间：2017/3/2
 * 描    述：
 * 修改时间：
 */

public class App extends Application {

    public static OkHttpFramework okHttpFramework;

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader instance = ImageLoader.getInstance();
        instance.init(new ImageLoaderConfiguration.Builder(getApplicationContext()).build());

        okHttpFramework = OkHttpFramework.getOkHttpFramework();
    }
}
