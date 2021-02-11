package models;

import java.util.List;

public class Club extends GenericModel {
    private String clubName;
    private String clubDescription;
    private String clubImgUrl;
    private List<User> clubMembers;
    private long clubOwnerId;

    public Club() {}

    public Club(long clubId, String clubName, String clubDescription, String clubImgUrl, long clubOwnerId) {
        setClubId(clubId);
        setClubName(clubName);
        setClubDescription(clubDescription);
        setClubImgUrl(clubImgUrl);
        setClubOwnerId(clubOwnerId);
    }

    public Club(long clubId, String clubName, String clubDescription, String clubImgUrl, List<User> clubMembers) {
        setClubId(clubId);
        setClubName(clubName);
        setClubDescription(clubDescription);
        setClubImgUrl(clubImgUrl);
        setClubMembers(clubMembers);
    }

    public Club(String newName, String newDescription, String newImgURL, long ownerId) {
        setClubName(newName);
        setClubDescription(newDescription);
        setClubImgUrl(newImgURL);
        setClubOwnerId(ownerId);
    }

    public Club(String newName, String newDescription, String newImgURL) {
        setClubName(newName);
        setClubDescription(newDescription);
        setClubImgUrl(newImgURL);
    }

    public long getClubOwnerId() {
        return clubOwnerId;
    }

    public void setClubOwnerId(long clubOwnerId) {
        this.clubOwnerId = clubOwnerId;
    }

    public long getClubId() {
        return super.getId();
    }

    public void setClubId(long clubId) {
        super.setId(clubId);
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

    public String getClubImgUrl() {
        return clubImgUrl;
    }

    public void setClubImgUrl(String clubImgUrl) {
        this.clubImgUrl = clubImgUrl;
    }

    public void addUserToClub(User user) {
        this.clubMembers.add(user);
    }

    public void removeUserFromClub(User user) {
        this.clubMembers.remove(user);
    }

    public List<User> getClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(List<User> clubMembers) {
        this.clubMembers = clubMembers;
    }
}
