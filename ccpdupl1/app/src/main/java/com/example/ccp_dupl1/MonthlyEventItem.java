package com.example.ccp_dupl1;

public class MonthlyEventItem {
    private String eventName;
    private String hashtags;

    public String getEventName() {
        return eventName;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    MonthlyEventItem(String eventName, String hashtags){
        this.eventName = eventName;
        this.hashtags = hashtags;
    }
}
