package com.sznews.www.isznews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sznews.www.isznews.fragment.UserFragment;

/**
 * Created by sznews on 2016/11/23.
 */

public class LoginActivity extends Activity{

    private ImageView login_back;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login);

        initView();
    }

    private void initView(){
        login_back = (ImageView) findViewById(R.id.login_back);
        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
