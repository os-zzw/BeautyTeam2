package com.example.john.beautyteam2.model.login;

import com.example.john.beautyteam2.base.BaseInterFace;

/**
 * Created by ZheWei on 2016/9/14.
 */
public interface Login_Contract {
    /**
     * 继承BaseActivity 并且传入Presenter
     */
    interface View extends BaseInterFace.BaseView {

    }

    /**
     * 继承自BasePresenter
     */
    interface Presenter extends BaseInterFace.BasePresenter<View> {

    }
}
