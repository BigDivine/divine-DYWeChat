package com.divine.wechat;

import android.content.Context;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class DYWeChatHelper {
    private static DYWeChatHelper mDYWeChatHelper;
    private IWXAPI WXApi;

    private DYWeChatHelper(Context mContext) {
        regToWeChat(mContext);
    }
    private void regToWeChat(Context mContext) {
        WXApi = WXAPIFactory.createWXAPI(mContext, DYWeChatBase.APP_KEY);
        WXApi.registerApp(DYWeChatBase.APP_KEY);
    }
    public static DYWeChatHelper instance(Context mContext) {
        if (null == mDYWeChatHelper) {
            synchronized (DYWeChatHelper.class) {
                if (null == mDYWeChatHelper) {
                    mDYWeChatHelper = new DYWeChatHelper(mContext);
                }
            }
        }
        return mDYWeChatHelper;
    }
    public IWXAPI getWXApi() {
        return WXApi;
    }
    public void weChatLogin() {
        SendAuth.Req loginReq = new SendAuth.Req();
//        获取用户个人信息则填写snsapi_userinfo
        loginReq.scope = "snsapi_userinfo";
//        该参数可用于防止csrf攻击（跨站请求伪造攻击），建议第三方带上该参数，可设置为简单的随机数加session进行校验
        loginReq.state = "wechat_sdk_demo_test";
        WXApi.sendReq(loginReq);
    }

}
