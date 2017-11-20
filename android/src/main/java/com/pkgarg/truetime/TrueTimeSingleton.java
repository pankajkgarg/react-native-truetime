package com.pkgarg.truetime;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.instacart.library.truetime.TrueTime;

import java.io.IOException;
/*
import com.instacart.library.truetime.TrueTimeRx;
import java.util.Date;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
*/

/**
 * Created by pankaj on 4/8/17.
 */

public class TrueTimeSingleton {
    private static final String TAG = "TrueTimeSingleton";

    private static TrueTimeSingleton instance;
    //private TrueTimeRx trueTimeInstance;

    private boolean initialized = false;
    private String username;
    //no outer class can initialize this class's object
    private TrueTimeSingleton() {}

    public static TrueTimeSingleton Instance()
    {
        //if no instance is initialized yet then create new instance
        //else return stored instance
        if (instance == null){
            instance = new TrueTimeSingleton();
        }
        return instance;
    }

    public void initialize(Context context) throws IOException {
        if(!initialized){
            /*
            AsyncTask.execute(new Runnable() {
               @Override
               public void run() {
                  //TODO your background code
                   TrueTime.build().initialize();
               }
            });
            */
            TrueTime.build()
                    .withNtpHost("time.google.com")
                    .withLoggingEnabled(false)
                    .withServerResponseDelayMax(1000) // (in ms)
                    .initialize();

            /*
            TrueTimeRx.build()
                    .withConnectionTimeout(31_428)  // (in ms) underscore don't mean anything 2_5 = 25
                    .withRetryCount(100)
                    .withSharedPreferences(context)
                    .withLoggingEnabled(true)
                    .initializeRx("time.google.com")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Date>() {
                        @Override
                        public void accept(Date date) throws Exception {
                            Log.v(TAG, "TrueTime was initialized and we have a time: " + date);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            throwable.printStackTrace();
                            Log.e(TAG, "something went wrong when trying to initializeRx TrueTime", throwable);
                        }
                    });
            */

            initialized = true;
        }
    }

}
