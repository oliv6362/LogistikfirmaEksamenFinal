package Entity;

public class User {

    private int userID;
    private String fName;
    private String lName;
    private String licenceNr;

    public User() {
    }

    //til oprettelse af bruger
    public User(String fName, String lName, String licenceNr) {
        this.fName = fName;
        this.lName = lName;
        this.licenceNr = licenceNr;
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

    public String getLicenceNr() {
        return licenceNr;
    }
    public void setLicenceNr(String licenceNr) {
        this.licenceNr = licenceNr;
    }
}

