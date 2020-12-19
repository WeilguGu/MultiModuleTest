package com.example.common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

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
    }
}
