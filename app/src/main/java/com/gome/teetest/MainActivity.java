package com.gome.teetest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import  com.gome.teetest.BeanpodTEEClient.*;

public class MainActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
    }

    public void encrypt(View v) {
        byte[] src = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4,};
//                byte[] result = BeanpodTEEClient.bigIntAdd();
        int length = src.length;
        byte[] encrypted = BeanpodTEEClient.invokeCmd(BeanpodTEEClient.ENCRYPT, src, length);
        StringBuilder res = new StringBuilder();
        Log.d("uTClient", encrypted.length + "");
        for (byte b : encrypted) {
            res.append(Integer.toHexString(b & 0xFF));
        }
        text.setText(res.toString());

        res.append("\n");
        byte[] decrypted = TEEClient.invokeCmd(BeanpodTEEClient.DECRYPT, encrypted, length);
        Log.d("uTClient", decrypted.length + "");
        for (byte b : decrypted) {
            res.append(Integer.toHexString(b & 0xFF));
        }
        text.setText(res.toString());
    }
}
