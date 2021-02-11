package models;

public class Group extends GenericModel {
    //    private long groupId;
    private String groupName;

    public Group() {}

    public Group(long groupId, String groupName) {
        setGroupId(groupId);
        setGroupName(groupName);
    }

    public long getGroupId() {
        return super.getId();
    }

    public void setGroupId(long groupId) {
        super.setId(groupId);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}