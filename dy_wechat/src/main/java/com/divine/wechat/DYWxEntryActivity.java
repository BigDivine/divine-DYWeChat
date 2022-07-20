package com.divine.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public abstract class DYWxEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override
    public abstract void onReq(BaseReq baseReq);

    @Override
    public abstract void onResp(BaseResp baseResp);
}
