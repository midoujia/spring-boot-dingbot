import com.midoujia.dingbot.DingBotApi;
import com.midoujia.dingbot.service.DingBotService;

public class TestDemo {

    // @Test
    public void test() {
        DingBotApi dingBotApi = new DingBotService();
        String rep = dingBotApi.sendMarkdownMsgTest("https://oapi.dingtalk.com/robot/send",
                "SECa1bd5ad2185bc25346982a1b370129badfe4e0cae371496bb50edcf844378f91",
                "0abc91b514df6992436528d8cfc6f22bb53846b3b579730724898ee27101a5e9",
                "#### 北京天气 15:26分播报\n" +
                        "\n" +
                        "中雪，东北风 1级，空气良89，相对湿度 48%![screenshot](http://tukupic.tianqistatic.com/content/20221229/Fo1dokl6CErob8mQDfcCUTjB.jpg/nu)\n" +
                        "\n" +
                        "###### 15点27分发布 [天气](https://weathernew.pae.baidu.com/weathernew/pc?query=%E5%8C%97%E4%BA%AC%E5%A4%A9%E6%B0%94&srcid=4982)");
        System.out.println(rep);
    }
}
