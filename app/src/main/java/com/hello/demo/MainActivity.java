package com.hello.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
    }

    public void addBigInt(View v) {
        byte[] src = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4,};
//                byte[] result = NativeAuthenticatorKernel.bigIntAdd();
        int length = src.length;
        byte[] encrypted = NativeAuthenticatorKernel.invokeCmd(1, src, length);
        StringBuilder res = new StringBuilder();
        Log.d("uTClient", encrypted.length + "");
        for (byte b : encrypted) {
            res.append(Integer.toHexString(b & 0xFF));
        }
        text.setText(res.toString());

        res.append("\n");
        byte[] decrypted = NativeAuthenticatorKernel.invokeCmd(2, encrypted, length);
        Log.d("uTClient", decrypted.length + "");
        for (byte b : decrypted) {
            res.append(Integer.toHexString(b & 0xFF));
        }
        text.setText(res.toString());
    }
}
