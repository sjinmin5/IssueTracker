package issuetrackerapplication;

public class Users {
    
    private String userName;
    private String pswd;
    private String group;

    public Users(String userName, String pswd, String group) {
        this.userName = userName;
        this.pswd = pswd;
        this.group = group;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
    

}
