package com.gudf.community;

public enum SeasonEnum {


    SPRING(1,"春天","春天天气不错哦"),
    SUMMER(2,"夏天","夏天有点热"),
    Autumn(3,"秋天","秋天到了很凉爽"),
    WINTER(3,"冬天","冬天有点冷");

    private int index;
    private String season;
    private String value;

    SeasonEnum(int i, String season, String value) {
        this.index = i;
        this.season = season;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
