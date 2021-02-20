package com.example.dl_af_test_app;

import android.os.Bundle;

import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.widget.Button butt = findViewById(R.id.butt);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> eventValues = new HashMap<String, Object>();
                eventValues.put(AFInAppEventParameterName.REVENUE,1234);
                eventValues.put(AFInAppEventParameterName.CONTENT_TYPE,"Shirt");
                eventValues.put(AFInAppEventParameterName.CONTENT_ID,"567890");
                eventValues.put(AFInAppEventParameterName.CURRENCY,"RUB");
                AppsFlyerLib.getInstance().logEvent(getApplicationContext(), AFInAppEventType.PURCHASE, eventValues);

                Snackbar.make(view, "Thank you!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
    }

}





