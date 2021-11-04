package com.microyu.pixiv;

import java.util.Objects;

/**
 * @author niujinpeng
 * @date 2021/02/08
 * @link https://github.com/niumoo
 */
public class Image {
    private String title;
    private String userName;
    private String date;
    private String smallUrl;
    private String bigUrl;

    @Override
    public String toString() {
        return String.format("![](%s)%s [download](%s)", smallUrl, title, bigUrl);
    }

    public String getTitle() {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public String getBigUrl() {
        return bigUrl;
    }

    public Image() {
    }

    public Image(String title, String userName, String date, String smallUrl, String bigUrl) {
        this.title = title;
        this.userName = userName;
        this.date = date;
        this.smallUrl = smallUrl;
        this.bigUrl = bigUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image images = (Image) o;
        return Objects.equals(title, images.title) && Objects.equals(userName, images.userName) && Objects.equals(date, images.date) && Objects.equals(smallUrl, images.smallUrl) && Objects.equals(bigUrl, images.bigUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, userName, date, smallUrl, bigUrl);
    }
}
