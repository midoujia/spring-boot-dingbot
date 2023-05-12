package com.midoujia.dingbot;

import java.util.List;

/**
 * @author zfldiv <zfldiv@163.com>
 */
public interface DingBotApi {

    /** 测试消息发送接口 */
    String sendMarkdownMsgTest(String botUrl, String botKey, String botToken, String content);

    /** 消息发送普通文本接口 */
    String sendTextMsg(String content);

    /** 消息发送link类型文本接口 */
    String sendLinkMsg(String title, String content, String picUrl, String messageUrl);

    /** 消息发送markdown类型文本接口 */
    String sendMarkdownMsg(String title, String content);

    /** 消息发送ActionCard类型文本接口 */
    String sendActionCardMsg(String title, String content, String singleURL);

    /** 消息发送FeedCard类型文本接口 */
    String sendFeedCardMsg(List<DingContent> dingContent);
}
