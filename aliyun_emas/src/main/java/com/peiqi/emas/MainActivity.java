package com.peiqi.emas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.ha.adapter.AliHaAdapter;
import com.alibaba.ha.adapter.AliHaConfig;
import com.alibaba.ha.adapter.Plugin;
import com.alibaba.ha.adapter.service.tlog.TLogLevel;
import com.alibaba.ha.adapter.service.tlog.TLogService;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readLog();
            }
        });


    }

    private void readLog() {
        String TAG = "HaDemo";
        String MODEL = "MainActivity";

        for (int i = 0; i < 10; ++i) {
            String uuid = getRandomNum();
            TLogService.loge(MODEL, TAG, i + "" + uuid);
            uuid = getRandomNum();
            TLogService.loge(MODEL, TAG, "tlog test error " + i + " hahh " + uuid);
            TLogService.logd(MODEL, TAG, "tlog test debug" + i + " hahh " + uuid);
        }

        Toast.makeText(MainActivity.this, "打日志完成，100条，model = " + MODEL + " tag = " + TAG,
                Toast.LENGTH_SHORT).show();
    }


    //随机数
    private String getRandomNum() {
        try {
            UUID uuid = UUID.randomUUID();
            return uuid.toString().replace("-", "");
        } catch (Exception e) {
            Log.w(AliHaAdapter.TAG, "get random num failure", e);
        }
        return null;
    }
}
