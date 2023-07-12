package com.chj.thor.captcha;

import org.apache.commons.lang.StringUtils;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/11 23:37
 */
public class GoogleCapthcaUtil {
    private static final String clientKey = "35e305302007c686b48ae55eccc1e83dab878abd24188";
    private static final String createTaskUrl = "https://api.yescaptcha.com/createTask";

    public String createTask() {
        return StringUtils.EMPTY;
    }
}
