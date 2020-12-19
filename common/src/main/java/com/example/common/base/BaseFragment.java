package com.example.common.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.common.Constant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author : weilgu
 * Date   : 2020/12/19
 */
public class BaseFragment extends Fragment {

    private static ArrayList<Fragment> sChildFragments = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sChildFragments.add(this);
        EventBus.getDefault().register(this);
    }

    /**
     * EventBus
     * 主线程运行
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventCenter eventCenter) {
        if (eventCenter != null && eventCenter.getEventCode() == Constant.ON_ACTIVITY_RESULT) {
            HashMap<String, Object> data = (HashMap<String, Object>) eventCenter.getData();
            int requestCode = (int) data.get("requestCode");
            int resultCode = (int) data.get("resultCode");
            Intent intent = (Intent) data.get("data");
            onActivityResultCall(requestCode,resultCode,intent);
        }else if (eventCenter != null && eventCenter.getEventCode() != Constant.ON_ACTIVITY_RESULT){
            onEventBusCall(eventCenter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //应用在不同module中fragment的onActivityResult不回调的问题
    public void onActivityResultCall(int requestCode,int resultCode,Intent data){

    }

    //接收普通的eventBus消息
    public void onEventBusCall(EventCenter eventCenter){

    }
}
