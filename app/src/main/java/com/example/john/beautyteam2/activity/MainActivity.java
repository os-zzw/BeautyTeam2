package com.example.john.beautyteam2.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.john.beautyteam2.R;
import com.example.john.beautyteam2.base.BaseActivity;
import com.example.john.beautyteam2.bean.Bean_Hello;
import com.example.john.beautyteam2.service.Api;
import com.example.john.beautyteam2.utils.UIUtils;
import com.orhanobut.logger.Logger;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected Object setPresenter() {
        return null;
    }

    @Override
    protected void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setCommonBackToolBack(toolbar, "Main");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        test();
    }

    private void test() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(Api.BASE).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        final Api api = retrofit.create(Api.class);
        Observable<Bean_Hello> hello = api.getToken(Api.AppId, Api.AppSecret);
        //        hello
        //                .subscribeOn(Schedulers.io())
        //                .observeOn(AndroidSchedulers.mainThread())
        //                .subscribe(new Action1<Bean_Hello>() {
        //            @Override
        //            public void call(Bean_Hello bean_hello) {
        //                UIUtils.showToast(bean_hello.getResult());
        //                Logger.i(bean_hello.getResult());
        //            }
        //        });
        hello
                .flatMap(new Func1<Bean_Hello, Observable<Bean_Hello>>() {
                    @Override
                    public Observable<Bean_Hello> call(Bean_Hello bean_hello) {
                        return api.postLogin("123456789@qq.com", "123456789", true);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bean_Hello>() {
                    @Override
                    public void call(Bean_Hello bean_hello) {
                        UIUtils.showToast(bean_hello.getResult());
                        Logger.i(bean_hello.getResult());
                    }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
