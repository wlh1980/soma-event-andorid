package com.joymates.soma.util.sqbprinter;

import android.content.Context;
import android.util.Log;

import com.pax.dal.IDAL;
import com.pax.neptunelite.api.NeptuneLiteUser;

public class GetObj {

    private static IDAL dal;
    public static String logStr = "";

    // 获取IDal dal对象
    public static IDAL getDal(Context context) {
//        dal = DALTestActivity.idal;
        try {
            dal = NeptuneLiteUser.getInstance().getDal(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dal == null) {
            Log.e("NeptuneLiteDemo", "dal is null");
        }
        return dal;
    }

}
