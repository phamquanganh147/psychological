package dev147.com.vn.projectpsychological.utils;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {

    /**
     * used to get typeface
     *
     * @param context
     * @param nameType
     * @return
     */
    public static Typeface getTypeFace(Context context, String nameType) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + nameType);
        return typeface;
    }
}
