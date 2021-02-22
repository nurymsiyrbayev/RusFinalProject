package models;

import javax.persistence.Id;

public class Article extends GenericModel {
    private String articleTitle;
    private String articleDescription;
    private String articleImgUrl;

    public Article() {}

    public Article(String articleTitle, String articleDescription, String articleImgUrl) {
        setArticleDescription(articleDescription);
        setArticleTitle(articleTitle);
        setArticleImgUrl(articleImgUrl);
    }

    public Article(long articleId, String articleTitle, String articleDescription, String articleImgUrl) {
        setArticleId(articleId);
        setArticleDescription(articleDescription);
        setArticleTitle(articleTitle);
        setArticleImgUrl(articleImgUrl);
    }

    public long getArticleId() {
        return super.getId();
    }

    public void setArticleId(long newsId) {
        super.setId(newsId);
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleDescription() {
        return articleDescription;
    }

    public void setArticleDescription(String articleDescription) {
        this.articleDescription = articleDescription;
    }

    public String getArticleImgUrl() {
        return articleImgUrl;
    }

    public void setArticleImgUrl(String articleImgUrl) {
        this.articleImgUrl = articleImgUrl;
    }
}
