package com.example.john.beautyteam2.model.login;

/**
 * Created by ZheWei on 2016/9/13.
 */
public class Login_Presenter implements Login_Contract.Presenter {

    private Login_Contract.View mView;

    @Override
    public void attachView(Login_Contract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
