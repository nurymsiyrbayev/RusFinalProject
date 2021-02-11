package models;

public class User extends GenericModel {
    //    private long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private int userRole;
    private long groupId;
    private long majorId;
    private int graduateYear;

    public User() {}

    public User(String userFirstName, String userLastName, String userEmail,
                int userRole, long groupId, long majorId, int graduateYear) {
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setUserEmail(userEmail);
        setUserRole(userRole);
        setGroupId(groupId);
        setMajorId(majorId);
        setGraduateYear(graduateYear);
    }

    public User(long userId, String userFirstName, String userLastName, String userEmail,
                int userRole, long groupId, long majorId, int graduateYear) {
        setUserId(userId);
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setUserEmail(userEmail);
        setUserRole(userRole);
        setGroupId(groupId);
        setMajorId(majorId);
        setGraduateYear(graduateYear);
    }

    public User(long userId, String userFirstName, String userLastName, String userEmail,
                String userPassword, int userRole, long groupId, long majorId, int graduateYear) {
        setUserId(userId);
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setUserEmail(userEmail);
        setUserPassword(userPassword);
        setUserRole(userRole);
        setGroupId(groupId);
        setMajorId(majorId);
        setGraduateYear(graduateYear);
    }

    public long getUserId() {
        return super.getId();
    }

    public void setUserId(long userId) {
        super.setId(userId);
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getMajorId() {
        return majorId;
    }

    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public int getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(int graduateYear) {
        this.graduateYear = graduateYear;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                ", groupId=" + groupId +
                ", majorId=" + majorId +
                ", graduateYear=" + graduateYear +
                '}';
    }
}
