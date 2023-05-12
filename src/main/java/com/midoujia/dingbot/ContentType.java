package com.midoujia.dingbot;

/**
 * 文本类型枚举
 * https://open.dingtalk.com/document/robots/message-types-and-data-format
 * @author zfldiv <zfldiv@163.com>
 */
public enum ContentType {

    /** 消息类型 */
    Text("text"),
    Link("link"),
    Markdown("markdown"),
    ActionCard("actionCard"),
    FeedCard("feedCard"),
    ;

    private String type;

    ContentType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
