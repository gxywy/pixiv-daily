package com.microyu.pixiv;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author niujinpeng
 * @date 2021/02/08
 * @link https://github.com/niumoo
 */
public class Pixiv {

    // BING API
    private static String PIXIV_API = "https://www.pixiv.net/ranking.php?format=json&mode=daily&p=1";

    public static void main(String[] args) throws IOException {

        String httpContent = HttpUtls.getHttpContent(PIXIV_API);
        JSONObject jsonObject = JSON.parseObject(httpContent);
        JSONArray jsonArray = jsonObject.getJSONArray("contents");

        List<Image> imagesList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            System.out.println(jsonObject.toString());

            // 图片地址
            String originUrl = (String) jsonObject.get("url");
            String smallUrl = originUrl.replace("i.pximg.net", "pixiv.microyu.workers.dev");
            String bigUrl = smallUrl.replace("/c/240x480/img-master/", "/img-original/").replace("_master1200", "");
            System.out.println(bigUrl);

            // 图片时间
            String data = (String) jsonObject.get("data");
            // 图片标题
            String title = (String) jsonObject.get("title");
            // 图片作者
            String userName = (String) jsonObject.get("user_name");

            imagesList.add(new Image(title, userName, data, smallUrl, bigUrl));
        }

        FileUtils.writeReadme(imagesList);
    }

}
