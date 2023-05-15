## 1 结合logback发送钉钉群消息

### Maven快速集成

```xml
<dependency>
    <groupId>com.midoujia.dingbot</groupId>
    <artifactId>spring-boot-dingbot</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 配置

申请Key说明文档：https://open.dingtalk.com/document/robots/custom-robot-access

```yaml
ding:
  bot-url: https://oapi.dingtalk.com/robot/send
  bot-key: SECaxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  bot-token: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  bot-enabled: true
  trigger-words:
    - 异常
    - OutofMemoryError
    - Java heap space
```

### logback配置

```xml
<!--配置自定义的日志处理了-->
<appender name="WlcLog" class="com.midoujia.dingbot.configuration.CusLogLogbackAppender">
    <filter class="ch.qos.logback.classic.filter.LevelFilter">
        <level>ERROR</level>
        <onMatch>ACCEPT</onMatch>
        <onMismatch>DENY</onMismatch>
    </filter>
</appender>
<root level="info">
<appender-ref ref="WlcLog"/>
</root>
```



## 2 单独自定义使用dingbot

### Maven快速集成

```xml
<dependency>
    <groupId>com.midoujia.dingbot</groupId>
    <artifactId>dingbot</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

### 配置

```yaml
ding:
  bot-url: https://oapi.dingtalk.com/robot/send
  bot-key: SECaxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  bot-token: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

### 使用

```java
@Autowired
private DingBotApi dingBotApi;
或
DingBotApi dingBotApi = SpringBeanFactory.getBean(DingBotApi.class);

```

### DingBotApi接口说明

```java
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
```