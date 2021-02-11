package models;

public class Major extends GenericModel {
//    private long majorId;
    private String majorName;

    public Major() {}

    public Major(long majorId, String majorName) {
        setMajorId(majorId);
        setMajorName(majorName);
    }

    public long getMajorId() {
        return super.getId();
    }

    public void setMajorId(long majorId) {
        super.setId(majorId);
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
