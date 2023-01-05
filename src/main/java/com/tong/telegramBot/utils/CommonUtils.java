package com.tong.telegramBot.utils;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.tong.telegramBot.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by tong on 2023/1/2
 */
@Component
public class CommonUtils {

    private static ApplicationContext applicationContext;

    public static <T> T invokeBotCommandService(String methodName, Object... args) {
        Class<?> entryClass = ClassUtil.loadClass("com.tong.telegramBot.service.ILetletmeBotCommandService");
        Method method = Arrays.stream(entryClass.getMethods())
                .filter(o -> StringUtils.equals(o.getName(), methodName))
                .findFirst()
                .orElse(null);
        if (method == null) {
            return null;
        }
        Object[] params = null;
        if (entryClass.getDeclaredConstructors().length > 0) {
            Class<?>[] constructorClass = entryClass.getDeclaredConstructors()[0].getParameterTypes();
            params = new Object[constructorClass.length];
            for (int i = 0; i < constructorClass.length; i++) {
                params[i] = ReflectUtil.newInstanceIfPossible(constructorClass[i]);
            }
        }
        try {
            if (args == null || args[0] == null) {
                if (params == null) {
                    return ReflectUtil.invoke(applicationContext.getBean(entryClass), method);
                } else {
                    return ReflectUtil.invoke(applicationContext.getBean(entryClass, params), method);
                }
            } else {
                if (params == null) {
                    return ReflectUtil.invoke(applicationContext.getBean(entryClass), method, args);
                } else {
                    return ReflectUtil.invoke(applicationContext.getBean(entryClass, params), method, args);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String initPlayerValueData(String result) {
        StringBuilder builder = new StringBuilder();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern(Constant.SHORTDAY));
        String rise = "Rise";
        String fall = "Faller";
        Map<String, List<LinkedHashMap<String, Object>>> map = JsonUtils.json2obj(result, Map.class);
        if (CollectionUtils.isEmpty(map)) {
            return null;
        }
        // rise
        builder.append("Price_change: ").append(date).append("\r\n").append("\r\n");
        builder.append("Rise:").append("\r\n");
        if (!map.containsKey(rise) || CollectionUtils.isEmpty(map.get(rise))) {
            builder.append("None").append("\r\n");
        } else {
            map.get(rise).forEach(o ->
                    builder.append(o.get("webName"))
                            .append(" [").append(o.get("teamShortName")).append("]")
                            .append("  ")
                            .append(o.get("lastValue")).append("m").append(" => ").append(o.get("value")).append("m")
                            .append("\r\n")
            );
        }
        builder.append("\r\n");
        // fall
        builder.append("Fall:").append("\r\n");
        if (!map.containsKey(fall) || CollectionUtils.isEmpty(map.get(fall))) {
            builder.append("None").append("\r\n");
        } else {
            map.get(fall).forEach(o ->
                    builder.append(o.get("webName"))
                            .append(" [").append(o.get("teamShortName")).append("]")
                            .append("  ")
                            .append(o.get("lastValue")).append("m").append(" => ").append(o.get("value")).append("m")
                            .append("\r\n")
            );
        }
        return builder.toString();
    }

    @Autowired
    private void setApplicationContext(ApplicationContext applicationContext) {
        CommonUtils.applicationContext = applicationContext;
    }

}
