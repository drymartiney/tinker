package com.chen.tinker;

import android.app.Application;
import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Created by yy on 2020/1/16.
 * @function 对Tinker的所有api做一层封装
 */

public class TinkerManager {

    private static boolean isInstalled=false;

    private static ApplicationLike mAppLike;

    /**
     * 完成Tinker的初始化
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike){
        mAppLike=applicationLike;
        if (isInstalled){
            return;
        }
        TinkerInstaller.install(mAppLike);//完成tinker初始化
        isInstalled=true;
    }

    public static void loadPatch(String path){
        if (Tinker.isTinkerInstalled()){
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),path);
        }
    }

    //通过ApplicationLike获取context
    private static Context getApplicationContext(){
        if (mAppLike!=null){
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
