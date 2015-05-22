
package com.androidtools.viewholder;

import android.os.Bundle;
import android.view.View;

/**
 * @author zju_wjf
 */
public abstract class AbstractViewHolder implements IViewHolder {

    private View rootView;
    
    @Override
    public View getRootView(){
        return rootView;
    }

    @Override
    public void setRootView(View rootView){
        this.rootView = rootView;
    }
    
    @Override
    public void initByData(Bundle data) {
    }
}
