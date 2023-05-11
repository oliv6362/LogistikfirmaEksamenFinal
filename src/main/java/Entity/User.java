package Entity;

public class User {

    private int userID;
    private String fName;
    private String lName;
    private String password;
    private int company;
    private boolean status;

    private int location;

    public User() {
    }


    public User(int userID, String fName, String lName, String password, int company, boolean status, int location) {
        this.userID = userID;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.company = company;
        this.status = status;
        this.location = location;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}

