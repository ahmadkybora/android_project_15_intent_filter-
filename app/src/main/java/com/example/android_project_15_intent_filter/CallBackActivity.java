package com.example.android_project_15_intent_filter;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class CallBackActivity extends AppCompatActivity {

    private ImageView img_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_back);
        initViews();
        Uri data = getIntent().getData();

        if (data != null) {
            /*Log.i("google", "host : " + data.getHost());
            Log.i("google", "scheme" + data.getScheme());
            Log.i("google", "success" + data.getQueryParameter("success"));*/
            try {
                int success = Integer.parseInt(data.getQueryParameter("success"));
                if (success == 1) {
                    img_status.setColorFilter(ContextCompat.getColor(this, R.color.purple_200));
                    img_status.setImageResource(R.drawable.ic_baseline_mood_24);
                } else {
                    img_status.setColorFilter(ContextCompat.getColor(this, R.color.black));
                    img_status.setImageResource(R.drawable.ic_baseline_mood_bad_24);
                }
            } catch (Exception e) {
                img_status.setColorFilter(ContextCompat.getColor(this, R.color.black));
                img_status.setImageResource(R.drawable.ic_baseline_mood_bad_24);
            }

        }
    }

    private void initViews() {
        img_status = findViewById(R.id.img_status);
    }
}
