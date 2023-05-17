package Entity;

public class Registration {

    private int regID;
    private int userID;
    private String checkTime;

    private int locationId;

    private int companyId;

    public Registration() {
    }

    //checkin


    public Registration(int userID, int companyId, int locationId, String checkTime) {
        this.userID = userID;
        this.companyId = companyId;
        this.locationId = locationId;
        this.checkTime = checkTime;
    }

    public Registration(int regID, int userID, String checkTime, String checkOutTime) {
        this.regID = regID;
        this.userID = userID;
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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
