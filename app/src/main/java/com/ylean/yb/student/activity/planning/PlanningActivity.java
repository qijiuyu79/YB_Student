package com.ylean.yb.student.activity.planning;

import android.view.KeyEvent;
import android.webkit.WebView;
import com.ylean.yb.student.R;
import com.ylean.yb.student.activity.webview.BaseWebView;
import com.zxdc.utils.library.http.HttpConstant;
import com.zxdc.utils.library.util.SPUtil;
import butterknife.BindView;

/**
 * 职业规划
 */
public class PlanningActivity extends BaseWebView {

    @BindView(R.id.webview)
    WebView webview;

    /**
     * 加载布局
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }


    /**
     * 初始化
     */
    @Override
    protected void initData() {
        super.initData();
        initWebView(webview);
        webview.loadUrl(HttpConstant.H5+"employmentlink.html?token="+ SPUtil.getInstance(this).getString(SPUtil.TOKEN));
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview.clearCache(true);
    }
}
