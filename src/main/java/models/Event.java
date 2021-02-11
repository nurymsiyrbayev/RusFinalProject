package models;

public class Event extends GenericModel {
    private String eventTitle;
    private String eventDescription;
    private String eventImgUrl;
    private long clubId;

    public Event() {}

    public Event(long eventId, String eventTitle, String eventDescription, String eventImgUrl) {
        setEventId(eventId);
        setEventTitle(eventTitle);
        setEventDescription(eventDescription);
        setEventImgUrl(eventImgUrl);
    }

    public Event(String eventTitle, String eventDescription, String eventImgUrl, long clubId) {
        setEventTitle(eventTitle);
        setEventDescription(eventDescription);
        setEventImgUrl(eventImgUrl);
        setClubId(clubId);
    }

    public Event(long eventId, String eventTitle, String eventDescription, String eventImgUrl, long clubId) {
        setEventId(eventId);
        setEventTitle(eventTitle);
        setEventDescription(eventDescription);
        setEventImgUrl(eventImgUrl);
        setClubId(clubId);
    }

    public long getEventId() {
        return super.getId();
    }

    public void setEventId(long eventId) {
        super.setId(eventId);
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventImgUrl() {
        return eventImgUrl;
    }

    public void setEventImgUrl(String eventImgUrl) {
        this.eventImgUrl = eventImgUrl;
    }

    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventImgUrl='" + eventImgUrl + '\'' +
                ", clubId=" + clubId +
                '}';
    }
}
