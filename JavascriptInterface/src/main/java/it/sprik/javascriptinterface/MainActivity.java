package it.sprik.javascriptinterface;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView webview;
    private JavascriptInterfacePressure jsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);

        jsp = new JavascriptInterfacePressure(this);

        webview.addJavascriptInterface(jsp, "androidjsp");

        webview.loadUrl("file:///android_asset/indexpressure.html");


    }

    @Override
    protected void onResume() {
        super.onResume();
        jsp.registerSensor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        jsp.unregisterSensor();
    }

}
