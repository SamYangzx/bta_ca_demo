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
                byte[] src = {1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};
//                byte[] result = NativeAuthenticatorKernel.bigIntAdd();
                byte[] result = NativeAuthenticatorKernel.invokeCmd(1,src, 16);
                StringBuilder res = new StringBuilder();

                Log.d("uTClient", result.length + "");
                for(byte b : result)
                {
                    res.append(Integer.toHexString(b & 0xFF));
                }
                text.setText(res.toString());
	}
}
