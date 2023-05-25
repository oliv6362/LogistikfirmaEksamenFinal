package Entity;

public class Registration {

    private int regID;
    private int userID;
    private int companyID;
    private int locationID;
    private String checkTime;

    public Registration() {
    }

    public Registration(int userID, int companyId, int locationID, String checkTime) {
        this.userID = userID;
        this.companyID = companyId;
        this.locationID = locationID;
        this.checkTime = checkTime;
    }

    public int getRegID() {
        return regID;
    }
    public void setRegID(int regID) {
        this.regID = regID;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCheckTime() {
        return checkTime;
    }
    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getCompanyId() {
        return companyID;
    }

    public void setCompanyId(int companyId) {
        this.companyID = companyId;
    }
}
