package com.bawei.ykdemo2.bean;

import java.util.ArrayList;

/**
 * 作    者：云凯文
 * 时    间：2017/3/2
 * 描    述：
 * 修改时间：
 */

public class Bean {
    private ArrayList<Items> items;

    public Bean() {
    }

    public Bean(ArrayList<Items> items) {
        this.items = items;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "items=" + items +
                '}';
    }
}
