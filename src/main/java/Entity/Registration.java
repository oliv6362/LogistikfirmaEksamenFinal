package Entity;

public class Registration {

    private int regID;
    private int userID;
    private String checkTime;
    public Registration() {
    }

    //checkin
    public Registration(int userID, String checkTime) {
        this.userID = userID;
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
}
