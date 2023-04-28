package com.example.sit_305_51c;

public class News {
    String newsHeading, newsDetails;
    boolean isTopStory;
    int groupId;
    public News (String newsHeading, String newsDetails, boolean isTopStory, int groupId)
    {
        this.newsHeading = newsHeading;
        this.newsDetails = newsDetails;
        this.isTopStory = isTopStory;
        this.groupId = groupId;
    }

    public String GetHeading()
    {
        return this.newsHeading;
    }
    public String GetNewsDetail()
    {
        return this.newsDetails;
    }
    public Boolean GetIsTopStory()
    {
        return this.isTopStory;
    }
    public int GetGroupId()
    {
        return this.groupId;
    }

}
