package models;

public class News extends GenericModel {
    private String newsTitle;
    private String newsDescription;
    private String newsImgUrl;

    public News() {}

    public News(String newsTitle, String newsDescription, String newsImgUrl) {
        setNewsDescription(newsDescription);
        setNewsTitle(newsTitle);
        setNewsImgUrl(newsImgUrl);
    }

    public News(long newsId, String newsTitle, String newsDescription, String newsImgUrl) {
        setNewsId(newsId);
        setNewsDescription(newsDescription);
        setNewsTitle(newsTitle);
        setNewsImgUrl(newsImgUrl);
    }

    public long getNewsId() {
        return super.getId();
    }

    public void setNewsId(long newsId) {
        super.setId(newsId);
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsImgUrl() {
        return newsImgUrl;
    }

    public void setNewsImgUrl(String newsImgUrl) {
        this.newsImgUrl = newsImgUrl;
    }
}
