package com.androidtools.viewholder;

import android.os.Bundle;
import android.view.View;

/**
 * @author zju_wjf
 *
 */
public interface IViewHolder {
    /**
     * 对应的R.layout中 id
     * @return
     */
    public int getId() ;
    
    /**
     * 自定义实现, 根据数据设置View的展示等
     * @param data
     */
    public void initByData(Bundle data);
    
    /**
     * 获得该ViewHolder的根View
     * @return
     */
    public View getRootView();
    
    /**为该ViewHolder设置根View
     * 
     * @param rootView
     */
    public void setRootView(View rootView);
}
