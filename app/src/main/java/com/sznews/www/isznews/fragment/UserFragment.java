package com.sznews.www.isznews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.sznews.www.isznews.LoginActivity;
import com.sznews.www.isznews.R;

/**
 * Created by Yuan on 2016/10/25.
 */
public class UserFragment extends Fragment{

    private View view;

    private LinearLayout login;
    private LinearLayout mycomment;
    private LinearLayout feedback;

    private RadioButton collection;
    private RadioButton nightmode;
    private RadioButton setting;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.user,null);



        return view;
    }

    public void init(){

        login = (LinearLayout) view.findViewById(R.id.user_login);
        mycomment = (LinearLayout) view.findViewById(R.id.user_mycomment);
        feedback = (LinearLayout) view.findViewById(R.id.user_feedback);

        collection = (RadioButton) view.findViewById(R.id.user_collection);
        nightmode = (RadioButton) view.findViewById(R.id.user_nightmode);
        setting = (RadioButton) view.findViewById(R.id.user_setting);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        mycomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

//        feedback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), LoginActivity.class);
//                startActivity(intent);
//            }
//        });

        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        nightmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
