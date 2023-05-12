package Entity;

public class User {

    private int userID;
    private String fName;
    private String lName;
    private String password;
    private int company;
    private int status;

    private int location;

    public User() {
    }


    //til at ændre status bool TEEST
    public User(int status) {
        this.status = status;
    }


    //til oprettelse af bruger
    public User(String fName, String lName, String password, int company, int location, int status) {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.company = company;
        this.location = location;
    }

    public User(int userID, String fName, String lName, String password, int company, int status, int location) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
}

