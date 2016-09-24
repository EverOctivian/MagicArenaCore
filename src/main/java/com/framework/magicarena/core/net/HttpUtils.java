package com.framework.magicarena.core.net;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 16-8-5.
 */
public class HttpUtils {
    private static final String TAG = HttpUtils.class.getSimpleName();
    private static OkHttpClient client;
    private static Gson gson;
    private static final int DOWNLOAD_STATE_SUCCESS = 101;
    private static final int DWONLOAD_STATE_FAILED = 102;

    static {
        HttpUtils.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .build();

        HttpUtils.gson = new Gson();
    }

    public static String requestString(String url, String[] queryKeys, String[] queryValues) throws IOException {
        //        .addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; WPS; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET")
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();

        if (queryKeys != null && queryValues != null) {
            int queryCount = Math.min(queryKeys.length, queryValues.length);
            for (int index = 0; index < queryCount; index++) {
                builder.addQueryParameter(queryKeys[index], queryValues[index]);
            }
        }

        String urlAll = builder.build().url().toString();
        Log.e(TAG, "downloadString: " + urlAll);
        Request request = new Request.Builder().url(urlAll).get().build();
        Response response = HttpUtils.client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            return null;
        }
    }

    public static byte[] requestBytes(String url, String[] queryKeys, String[] queryValues) throws IOException {
        //        .addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; WPS; Maxthon; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET")
        HttpUrl.Builder builder = HttpUrl.parse(url).newBuilder();

        if (queryKeys != null && queryValues != null) {
            int queryCount = Math.min(queryKeys.length, queryValues.length);
            for (int index = 0; index < queryCount; index++) {
                builder.addQueryParameter(queryKeys[index], queryValues[index]);
            }
        }

        String urlAll = builder.build().url().toString();
        Log.e(TAG, "downloadString: " + urlAll);
        Request request = new Request.Builder().url(urlAll).get().build();
        Response response = HttpUtils.client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().bytes();
        } else {
            return null;
        }
    }

    //    public static boolean isNetworkAvailable(Activity activity) {
    //        Context context = activity.getApplicationContext();
    //        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
    //        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    //
    //        if (connectivityManager == null) {
    //            return false;
    //        } else {
    //            return connectivityManager.getActiveNetworkInfo().isAvailable();
    //            //            // 获取NetworkInfo对象
    //            //            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
    //            //
    //            //            if (networkInfo != null && networkInfo.length > 0) {
    //            //                for (int i = 0; i < networkInfo.length; i++) {
    //            //                    // 判断当前网络状态是否为连接状态
    //            //                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
    //            //                        return true;
    //            //                    }
    //            //                }
    //            //            }
    //        }
    //    }

    public static void requestStringAsync(final String url, final RequestCallback<String> requestCallback, final boolean isUpdate) {
        HttpUtils.requestStringAsync(url, null, null, requestCallback, isUpdate);
    }

    public static void requestStringAsync(final String url, final String[] queryKeys, final String[] queryValues, final RequestCallback<String> requestCallback, final boolean isUpdate) {
        HttpUtils.httpStringRequest(url, queryKeys, queryValues, requestCallback, new RequestResultHandler<String>() {
            @Override
            public String handlerResult(String content) {
                return content;
            }
        }, isUpdate);
    }

    public static <E> void requestJsonModelAsync(final String url, final Class<E> clazz, final RequestCallback<E> requestCallback, final boolean isUpdate) {
        HttpUtils.requestJsonModelAsync(url, null, null, clazz, requestCallback, isUpdate);
    }

    public static <E> void requestJsonModelAsync(final String url, final String[] queryKeys, final String[] queryValues, final Class<? extends E> clazz, final RequestCallback<E> requestCallback, final boolean isUpdate) {
        HttpUtils.httpStringRequest(url, queryKeys, queryValues, requestCallback,
                new RequestResultHandler<E>() {
                    @Override
                    public E handlerResult(String content) {
                        return HttpUtils.gson.fromJson(content, clazz);
                    }
                }, isUpdate);
    }

    public static <E> void requestJsonModelAsync(final String url, final String[] queryKeys, final String[] queryValues, final RequestCallback<E> requestCallback, final boolean isUpdate) {
        HttpUtils.httpStringRequest(url, queryKeys, queryValues, requestCallback,
                new RequestResultHandler<E>() {
                    @Override
                    public E handlerResult(String content) {
                        return HttpUtils.gson.fromJson(content, new TypeToken<E>() {
                        }.getType());
                    }
                }, isUpdate);
    }

    public static <R> void httpStringRequest(final String url, final String[] queryKeys, final String[] queryValues, final RequestCallback<R> callback, final RequestResultHandler<R> contentHandler, final boolean isUpdate) {
        final Handler hanlder = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case HttpUtils.DOWNLOAD_STATE_SUCCESS:
                        if (callback != null) {
                            callback.onSuccess(((R) msg.obj), isUpdate);
                        }
                        break;
                    case HttpUtils.DWONLOAD_STATE_FAILED:
                        if (callback != null) {
                            callback.onFailure();
                        }
                        break;
                }

                callback.onFinish();
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = HttpUtils.requestString(url, queryKeys, queryValues);

                    Log.e(url, "run: " + result);

                    if (result == null) {
                        hanlder.sendEmptyMessage(HttpUtils.DWONLOAD_STATE_FAILED);
                    }

                    hanlder.sendMessage(hanlder.obtainMessage(HttpUtils.DOWNLOAD_STATE_SUCCESS, contentHandler.handlerResult(result)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void requestBytesRequest(final String url, final RequestCallback<byte[]> callback) {
        HttpUtils.requestBytesAsync(url, null, null, callback);
    }


    public static void requestBytesAsync(final String url, final String[] queryKeys, final String[] queryValues, final RequestCallback<byte[]> callback) {
        final Handler hanlder = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case HttpUtils.DOWNLOAD_STATE_SUCCESS:
                        if (callback != null) {
                            callback.onSuccess((byte[]) msg.obj, true);
                        }
                        break;
                    case HttpUtils.DWONLOAD_STATE_FAILED:
                        if (callback != null) {
                            callback.onFailure();
                        }
                        break;
                }

                callback.onFinish();
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] result = HttpUtils.requestBytes(url, queryKeys, queryValues);

                    if (result == null) {
                        hanlder.sendEmptyMessage(HttpUtils.DWONLOAD_STATE_FAILED);
                    }

                    hanlder.sendMessage(hanlder.obtainMessage(HttpUtils.DOWNLOAD_STATE_SUCCESS, result));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public interface RequestResultHandler<T> {
        T handlerResult(String content);
    }

    public interface RequestCallback<T> {
        void onFailure();

        void onSuccess(T result, boolean isUpdate);

        void onFinish();
    }
}
