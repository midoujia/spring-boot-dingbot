package com.midoujia.dingbot;

import java.util.List;

/**
 * @author zfldiv@163.com
 */
public interface DingBotApi {

    /** 测试消息发送接口 */
    String sendMarkdownMsgTest(String botUrl, String botKey, String botToken, String content, List<String> mobileList);

    /** 消息发送普通文本接口 */
    String sendTextMsg(String content, List<String> mobileList);

    /** 消息发送link类型文本接口 */
    String sendLinkMsg(String title, String content, String picUrl, String messageUrl, List<String> mobileList);

    /** 消息发送markdown类型文本接口 */
    String sendMarkdownMsg(String title, String content, List<String> mobileList);

    /** 消息发送ActionCard类型文本接口 */
    String sendActionCardMsg(String title, String content, String singleURL, List<String> mobileList);

    /** 消息发送FeedCard类型文本接口 */
    String sendFeedCardMsg(List<DingContent> dingContent, List<String> mobileList);
}
