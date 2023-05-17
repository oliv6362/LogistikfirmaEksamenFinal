package Entity;

public class User {

    private int userID;
    private String fName;
    private String lName;
    private int licenceNr;



    public User() {
    }



    //til oprettelse af bruger
    public User(String fName, String lName, int licenseNr) {
        this.fName = fName;
        this.lName = lName;
        this.licenceNr = licenseNr;

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

    public int getLicenceNr() {
        return licenceNr;
    }

    public void setLicenceNr(int licenceNr) {
        this.licenceNr = licenceNr;
    }


}

