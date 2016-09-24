package com.framework.magicarena.core.thirdparty.xutils.https;

import android.util.Log;

import org.xutils.common.Callback;

/**
 * Created by 31098 on 9/13/2016.
 */
public abstract class DefaultRequestCallBackImp<T> implements Callback.CommonCallback<T> {

    private static final String TAG = DefaultRequestCallBackImp.class.getSimpleName();

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        Log.e(TAG, "onError: " + ex.getMessage());
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }
}
