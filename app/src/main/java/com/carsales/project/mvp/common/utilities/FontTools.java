package com.carsales.project.mvp.common.utilities;

import android.content.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.carsales.project.R;
import com.carsales.project.mvp.common.global.Enums;


/**
 * Created by Enny Querales
 */
public class FontTools {

    /**
     * Attributes
     */
    private static Enums.CustomTypeface defaultTypeface = Enums.CustomTypeface.ROBOTO_REGULAR;
    private static final int FONT_ARRAY = R.array.fonts;


    public static String getFontTypeface(Context context, Integer typeface) {
        String fontArray[];
        fontArray = context.getResources().getStringArray(FONT_ARRAY);
        return fontArray[typeface];
    }

    public static String getDefaultFontType(Context context) {
        String fontArray[] = context.getResources().getStringArray(FONT_ARRAY);
        return fontArray[defaultTypeface.getValue()];
    }

    public final static boolean isValidEmail(CharSequence target) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z]).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
