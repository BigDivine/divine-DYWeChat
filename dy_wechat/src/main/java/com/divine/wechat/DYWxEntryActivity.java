package com.divine.wechat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public abstract class DYWxEntryActivity extends Activity implements IWXAPIEventHandler {
    /**
     * @param baseReq
     *  String transaction;
     *  String openId;
     */
    @Override
    public  void onReq(BaseReq baseReq){
        this.onReq(baseReq.openId,baseReq.transaction);
    }
    /**
     * @param baseResp
     *  int errCode;
     *  String errStr;
     *  String transaction;
     *  String openId;
     */
    @Override
    public  void onResp(BaseResp baseResp){
        this.onResp(baseResp.errCode,baseResp.errStr,baseResp.transaction,baseResp.openId);
    }
    protected abstract void onReq(String openId, String transaction);

    protected abstract void onResp(int errCode, String errStr, String transaction, String openId);
}
