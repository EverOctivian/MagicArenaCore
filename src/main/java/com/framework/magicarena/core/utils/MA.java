package com.framework.magicarena.core.utils;

import android.content.Context;

/**
 * Created by 31098 on 9/9/2016.
 */
public final class MA {
    private static Context sContext;

    private static void init(Context context) {
        if (MA.sContext == null) {
            synchronized (MA.class) {
                if (MA.sContext == null) {
                    MA.sContext = context;
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public static Context getInstance() {
        if (MA.sContext == null) {
            throw new IllegalStateException("Context must be initialized!");
        }

        return MA.sContext;
    }
}
