package vd.android.ivdeAutoAuth.entry;

import android.content.Context;

import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import app.vd.framework.extend.annotation.ModuleEntry;
import app.vd.framework.extend.bean.WebCallBean;
import vd.android.ivdeAutoAuth.module.ivdeAutoAuthWebModule;
import vd.android.ivdeAutoAuth.module.ivdeAutoAuthAppModule;

@ModuleEntry
public class ivdeAutoAuthEntry {

    /**
     * APP启动会运行此函数方法
     * @param content Application
     */
    public void init(Context content) {

        //1、注册weex模块
        try {
            WXSDKEngine.registerModule("ivdeAutoAuth", ivdeAutoAuthAppModule.class);
        } catch (WXException e) {
            e.printStackTrace();
        }

        //2、注册web模块（web-view模块可通过requireModuleJs调用，调用详见：https://vd.io/component/web-view.html）
        WebCallBean.addClassData("ivdeAutoAuth", ivdeAutoAuthWebModule.class);
    }
}
