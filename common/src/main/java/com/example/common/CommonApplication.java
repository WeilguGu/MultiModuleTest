package com.example.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author : weilgu
 * Date   : 2020/12/18
 */
public class CommonApplication extends Application {

    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();

        if (isDebugARouter){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
