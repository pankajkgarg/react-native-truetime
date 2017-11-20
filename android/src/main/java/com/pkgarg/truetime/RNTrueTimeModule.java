
package com.pkgarg.truetime;

import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.Callback;
import com.instacart.library.truetime.TrueTime;

import java.io.IOException;

public class RNTrueTimeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNTrueTimeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNTrueTime";
  }



    public static void initTrueTime(Context context) throws IOException {
        TrueTimeSingleton.Instance().initialize(context);
    }

    @ReactMethod
    public void initTrueTime(Promise promise){
        Context currentActivity = getCurrentActivity();
        try {
            initTrueTime(currentActivity);
        } catch (IOException e) {
            e.printStackTrace();
            promise.reject("TRUETIME_INIT_ERR", e);
            return;
        }
        promise.resolve("");
    }

    /**
     * Return ntp server time in millisecond that cannot be influenced by the user
     * @param promise
     */
    @ReactMethod
    public void getTrueTime(Promise promise) {
        // System time in milliseconds
        long time = TrueTime.now().getTime();

        // React Native bridge complains if we try to pass back a long directly
        promise.resolve(Long.toString(time));
    }


}