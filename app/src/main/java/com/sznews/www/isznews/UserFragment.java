package com.sznews.www.isznews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Yuan on 2016/10/25.
 */
public class UserFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(),"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.user,null);
//        Toast.makeText(UserFragment.this,"view4",Toast.LENGTH_SHORT).show();
        System.out.println("view3");
        Button button=(Button) view.findViewById(R.id.test2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("news");
                Toast.makeText(getActivity(),"news",Toast.LENGTH_SHORT).show();
            }
        });

        return inflater.inflate(R.layout.user, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button=(Button) getActivity().findViewById(R.id.test2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("getactivity");
                Toast.makeText(getActivity(),"getA",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
