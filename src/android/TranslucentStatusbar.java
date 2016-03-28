package com.noindoin.translucentstatusbar;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import android.view.WindowManager.LayoutParams;
import android.view.Window;

public class TranslucentStatusbar extends CordovaPlugin {
	public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
	  super.initialize(cordova, webView);
		cordova.getActivity().runOnUiThread(new Runnable() {
      public void run() {
        Window window = cordova.getActivity().getWindow();
				window.clearFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				window.addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
      }
    });
	}
}
