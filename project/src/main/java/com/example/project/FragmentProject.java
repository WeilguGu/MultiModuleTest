package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.Constant;
import com.example.common.base.BaseFragment;

/**
 * Author : weilgu
 * Date   : 2020/12/18
 */
@Route(path = "/project/fragment")
public class FragmentProject extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Constant.HOME_ACTIVITY).navigation(getActivity(),1021);
            }
        });
    }

    @Override
    public void onActivityResultCall(int requestCode, int resultCode, Intent data) {
        Log.d("FragmentProject","requestCode = " + requestCode + "   resultCode = " + resultCode + "  data = " + data);
    }
}
