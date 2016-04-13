package com.noindoin.translucentstatusbar;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import android.app.Activity;
import android.view.WindowManager.LayoutParams;
import android.view.Window;
import org.json.JSONArray;
import org.json.JSONException;


public class TranslucentStatusbar extends CordovaPlugin {
	private boolean enabled;

	@Override
	public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
	  super.initialize(cordova, webView);

		final Activity activity = cordova.getActivity();

		int id = activity.getResources().getIdentifier("config_enableTranslucentDecor", "bool", "android");
		if (id == 0) {
			enabled = false;
		} else {
			if (activity.getResources().getBoolean(id)) {
				activity.runOnUiThread(new Runnable() {
					@Override
		      public void run() {
		        Window window = activity.getWindow();
						window.clearFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
						window.addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
						enabled = true;
		      }
		    });
			}
		}
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if ("checkEnabled".equals(action)) {
      callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, enabled));
      return true;
    }
    return false;
	}
}
