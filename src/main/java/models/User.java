package models;

public class User extends GenericModel {
    //    private long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private int userRole;

    public User() {}

    public User(String userFirstName, String userLastName, String userEmail, int userRole) {
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setUserEmail(userEmail);
        setUserRole(userRole);
    }

    public User(long userId, String userFirstName, String userLastName, String userEmail, int userRole) {
        setUserId(userId);
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setUserEmail(userEmail);
        setUserRole(userRole);
    }

    public User(long userId, String userFirstName, String userLastName, String userEmail, String userPassword, int userRole) {
        setUserId(userId);
        setUserFirstName(userFirstName);
        setUserLastName(userLastName);
        setUserEmail(userEmail);
        setUserPassword(userPassword);
        setUserRole(userRole);
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


    @Override
    public String toString() {
        return super.toString() +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
