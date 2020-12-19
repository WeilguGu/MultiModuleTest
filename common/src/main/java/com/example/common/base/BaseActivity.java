package com.example.common.base;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.common.Constant;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

/**
 * Author : weilgu
 * Date   : 2020/12/19
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        HashMap<String, Object> map = new HashMap<>();
        map.put("requestCode",requestCode);
        map.put("resultCode",resultCode);
        map.put("data",data);
        EventBus.getDefault().post(new EventCenter<HashMap>(Constant.ON_ACTIVITY_RESULT,map));
    }
}
