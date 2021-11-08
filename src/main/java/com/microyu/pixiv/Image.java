package com.microyu.pixiv;

import java.util.Objects;

public class Image {
    private String title;
    private String userName;
    private String date;
    private String pageUrl;
    private String smallUrl;
    private String bigUrlJPG;
    private String bigUrlPNG;
    private int rank;

    @Override
    public String toString() {
        return String.format("![](%s) **#%s** [%s](%s) download: [JPG](%s) [PNG](%s)", smallUrl, rank, title, pageUrl, bigUrlJPG, bigUrlPNG);
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

    public String getBigUrlJPG() {
        return bigUrlJPG;
    }

    public String getBigUrlPNG() {
        return bigUrlPNG;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public int getRank() {
        return rank;
    }

    public Image() {
    }

    public Image(String title, String userName, String date, String pageUrl, String smallUrl, String bigUrl, int rank) {
        this.title = title;
        this.userName = userName;
        this.date = date;
        this.pageUrl = pageUrl;
        this.smallUrl = smallUrl;
        this.bigUrlJPG = bigUrl;
        this.bigUrlPNG = bigUrl.replace("jpg", "png");
        this.rank = rank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return rank == image.rank && Objects.equals(title, image.title) && Objects.equals(userName, image.userName) && Objects.equals(date, image.date) && Objects.equals(pageUrl, image.pageUrl) && Objects.equals(smallUrl, image.smallUrl) && Objects.equals(bigUrlJPG, image.bigUrlJPG) && Objects.equals(bigUrlPNG, image.bigUrlPNG);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, userName, date, pageUrl, smallUrl, bigUrlJPG, bigUrlPNG, rank);
    }
}
