package com.microyu.pixiv;

import java.util.Objects;

public class Image {
    private String title;
    private String userName;
    private String date;
    private String smallUrl;
    private String bigUrl;
    private int rank;

    @Override
    public String toString() {
        return String.format("![](%s) No.%s %s [download](%s)", smallUrl, rank, title, bigUrl);
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

    public int getRank() {
        return rank;
    }

    public Image() {
    }

    public Image(String title, String userName, String date, String smallUrl, String bigUrl, int rank) {
        this.title = title;
        this.userName = userName;
        this.date = date;
        this.smallUrl = smallUrl;
        this.bigUrl = bigUrl;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return rank == image.rank && Objects.equals(title, image.title) && Objects.equals(userName, image.userName) && Objects.equals(date, image.date) && Objects.equals(smallUrl, image.smallUrl) && Objects.equals(bigUrl, image.bigUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, userName, date, smallUrl, bigUrl, rank);
    }
}
