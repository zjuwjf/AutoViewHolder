package com.androidtools.viewholder;

import java.lang.reflect.Field;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zju_wjf
 *
 */
public class ViewHolderUtils {
    
    /**
     * @param _class
     * @param context
     * @param viewGroup
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T extends IViewHolder> T create(final Class<T> _class, final Context context, final ViewGroup viewGroup) throws InstantiationException, IllegalAccessException {
        final T t = _class.newInstance();
        
        final View rootView = LayoutInflater.from(context).inflate(t.getId(), viewGroup);
        t.setRootView(rootView);
        
        injectViews(t);
        
        return t;
    }
    
    /**
     * @param viewSet
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void injectViews(IViewHolder viewSet) throws IllegalArgumentException, IllegalAccessException {
        final Class<? extends IViewHolder> _class = viewSet.getClass();
        final View rootView = viewSet.getRootView();
        
        final Field [] fields = _class.getFields();
        for(Field field:fields) {
            final ViewHolderInject viewInject = field.getAnnotation(ViewHolderInject.class);
            if(viewInject != null) {
                //去除检查, 提高反射效率
                field.setAccessible(true);
                final View sub = rootView.findViewById(viewInject.id());
                field.set(viewSet, sub);
            }
        }
    }
}
