package com.androidtools.viewholder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zju_wjf
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ViewHolderInject{
    /**
     * 对应R.layout里的id
     * @return
     */
    int id();
}
