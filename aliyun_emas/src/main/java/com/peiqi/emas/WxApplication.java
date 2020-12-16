package com.peiqi.emas;

import android.app.Application;

import com.alibaba.ha.adapter.AliHaAdapter;
import com.alibaba.ha.adapter.AliHaConfig;
import com.alibaba.ha.adapter.Plugin;
import com.alibaba.ha.adapter.service.tlog.TLogLevel;
import com.alibaba.ha.adapter.service.tlog.TLogService;

/**
 * @author houjinbo
 * @date 2020/12/16
 */
public class WxApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initAliyunEmas(this);
    }

    /**
     * 阿里云移动性能分析库
     *
     * @param context
     */
    private void initAliyunEmas(Application context) {
        AliHaConfig config = new AliHaConfig();
        config.appKey = "333342259"; //配置项：appkey
        config.appVersion = "1.0.0"; //配置项：应用的版本号
        config.appSecret = "4a0ef2c8d1ef4d3db9606db7f89de3d4"; //配置项：appsecret
        config.channel = "jlpay"; //配置项：应用的渠道号标记，自定义
        config.userNick = "三星s10+"; //配置项：用户的昵称
        config.application = context; //配置项：应用指针
        config.context = context; //配置项：应用上下文
        config.isAliyunos = false; //配置项：是否为yunos
        config.rsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCItaSEJ77McFL8GMcCqNLxiydSUw+bAXKsHMbSGTzRA+w9n7PSeMUGUm6OBbTAnDbZCXUqU24RHHN9mxA59LZu7tWtCaVmtXbT7uux//2FI6j4Xl4u5Um59uVykSdhKyrROD5jHQC1slabbvC32rbxmvGs1BbukzilhyPXJ5y/jQIDAQAB"; //配置项：tlog公钥
        TLogService.updateLogLevel(TLogLevel.DEBUG); //配置项：控制台可拉取的日志级别

//        AliHaAdapter.getInstance().addPlugin(Plugin.crashreporter);    //崩溃分析，如不需要可注释掉
//        AliHaAdapter.getInstance().addPlugin(Plugin.apm);//性能监控，如不需要可注释掉
        AliHaAdapter.getInstance().addPlugin(Plugin.tlog);  //移动日志，如不需要可注、释掉
        AliHaAdapter.getInstance().openDebug(true);
        AliHaAdapter.getInstance().start(config);

    }


}
