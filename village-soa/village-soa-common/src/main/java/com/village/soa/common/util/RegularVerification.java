package com.village.soa.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenwei on 2016/11/29.
 */
public class RegularVerification {

    public static boolean isMobile(String str) {
        if (StringUtils.isNotBlank(str)) {
            Pattern p = null;
            Matcher m = null;
            boolean b = false;
            p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
            m = p.matcher(str);
            b = m.matches();
            return b;
        } else {
            return false;
        }
    }

    public static boolean isPasswordCorrect(String password) {
        if (StringUtils.isNotBlank(password)) {
            //判断密码是否包含数字：包含返回1，不包含返回0
            int i = password.matches(".*\\d+.*") ? 3 : 0;
            //判断密码是否包含字母：包含返回1，不包含返回0
            int j = password.matches(".*[a-zA-Z]+.*") ? 1 : 0;
            //判断密码是否包含特殊符号(~!@#$%^&*()_+|<>,.?/:;'[]{}\)：包含返回1，不包含返回0
            int k = password.matches(".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*") ? 1 : 0;
            //判断密码长度是否在6-20位
            int l = password.length();
            if (i + j + k < 4 || l < 6 || l > 20) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPasswordCorrect("1343###"));
        System.out.println(isPasswordCorrect("abadf###"));
        System.out.println(isPasswordCorrect("ab124343"));
        System.out.println(isPasswordCorrect("ab12###"));
        System.out.println(isPasswordCorrect("1234324324"));
    }
}
