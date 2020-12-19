package com.example.home;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Author : weilgu
 * Date   : 2020/12/18
 */
@Route(path = "/home/homeActivity")
public class HomeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
    }
}
