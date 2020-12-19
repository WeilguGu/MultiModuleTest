package com.example.moduletest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment("/home/fragment");
            }
        });
        findViewById(R.id.tv_project).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment("/project/fragment");
            }
        });
        findViewById(R.id.tv_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment("/user/fragment");
            }
        });
        manager = getSupportFragmentManager();
        Fragment home = (Fragment) ARouter.getInstance().build("/home/fragment").navigation();
        manager.beginTransaction().replace(R.id.fl_content,home).commit();
    }

    private void openFragment(String path){
        Fragment home = (Fragment) ARouter.getInstance().build(path).navigation();
        manager.beginTransaction().replace(R.id.fl_content,home).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("MainActivity","MainActivity requestCode = " + requestCode + "   resultCode = " + resultCode);
    }
}