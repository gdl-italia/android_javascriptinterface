package it.sprik.javascriptinterface;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class JavascriptInterface {
    private Context context;

    public JavascriptInterface(Context context) {
        this.context = context;
    }

    public void getToast(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
