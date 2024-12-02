package dataprovider.getdata;

public class UserInfoData {
    private String username;
    private String pwd;


    public UserInfoData(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUsername() {
        return username;
    }
}
