package dataprovider.getdata;

public class GroupInfoData {
    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return description;
    }

    private String groupName;
    private String description;

    public GroupInfoData(String groupName, String description) {
        this.groupName = groupName;
        this.description = description;
    }
}
