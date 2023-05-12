package com.midoujia.dingbot.configuration;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import ch.qos.logback.core.AppenderBase;
import com.midoujia.dingbot.DingBotApi;
import com.midoujia.dingbot.util.DingBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zfldiv <zfldiv@163.com>
 * @date 2023-01-12 15:43
 */
public class CusLogLogbackAppender extends AppenderBase {
    @Override
    protected void append(Object eventObject) {
        if(eventObject instanceof LoggingEvent){
            LoggingEvent loggingEvent = (LoggingEvent)eventObject;
            //拿到ThrowableProxy
            ThrowableProxy throwableProxy = (ThrowableProxy) loggingEvent.getThrowableProxy();
            if (Objects.nonNull(throwableProxy)) {
                //获取 throwable 顶级异常
                Throwable throwable = throwableProxy.getThrowable();
                //获取log的msg
                String formattedMessage = loggingEvent.getFormattedMessage();
                DingbotConfig dingbotConfig = DingBean.getBean(DingbotConfig.class);
                if (dingbotConfig.isBotEnabled()) {
                    DingBotApi dingBotApi = DingBean.getBean(DingBotApi.class);
                    List<String> triggerWords = dingbotConfig.getTriggerWords();
                    if (!CollectionUtils.isEmpty(triggerWords)) {
                        for (String word : triggerWords) {
                            if (formattedMessage != null && isContained(word, formattedMessage)) {
                                String active = DingBean.getEnvironment().getProperty("spring.profiles.active");
                                dingBotApi.sendTextMsg(active + "：" + formattedMessage + "\n" + throwable.toString());
                                break;
                            }
                        }
                    }
                }
            }
        }
        super.doAppend(eventObject);
    }

    /** 正则方法支持 */
    private boolean isContained(String regex, String content) {
        if (StringUtils.isEmpty(regex) && StringUtils.isEmpty(content)) {
            return false;
        }
        try {
            Pattern p = Pattern.compile(regex);
            Matcher matcher = p.matcher(content);
            return matcher.find();
        } catch (Exception e) {
            return false;
        }
    }
}
