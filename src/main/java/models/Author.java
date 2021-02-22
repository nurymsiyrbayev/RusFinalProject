package models;

import java.sql.Date;
import java.util.List;

public class Author extends GenericModel {
    private String authorName;
    private String authorBiography;
    private String authorImgUrl;
    private Date birthDate;
    private Date deathDate;

    public Author() {}

    public Author(long authorId, String authorName, String authorBiography, String authorImgUrl, Date birthDate, Date deathDate) {
        setAuthorId(authorId);
        this.authorName = authorName;
        this.authorBiography = authorBiography;
        this.authorImgUrl = authorImgUrl;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public long getAuthorId() {
        return super.getId();
    }

    public void setAuthorId(long authorId) {
        super.setId(authorId);
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    public String getAuthorImgUrl() {
        return authorImgUrl;
    }

    public void setAuthorImgUrl(String authorImgUrl) {
        this.authorImgUrl = authorImgUrl;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }
}
