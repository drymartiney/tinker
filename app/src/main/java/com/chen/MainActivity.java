package com.chen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chen.tinker.TinkerManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END = ".apk";
    ///storage/emulated/0/Android/data/com.chen.andfix/cache/apatch/
    private String mPatchDir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPatchDir=getExternalCacheDir().getAbsolutePath()+"/tpatch/";
        //System.out.println("mPatchDir:"+mPatchDir);
        //为了创建我们的文件夹
        File file=new File(mPatchDir);
        if (file==null||!file.exists()){
            file.mkdir();
        }
    }

    public void loadPatch(View view){
        TinkerManager.loadPatch(getPatchName());
    }
    private String getPatchName(){
        return mPatchDir.concat("imooc").concat(FILE_END);
    }
}
