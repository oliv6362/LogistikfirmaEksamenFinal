package Entity;

public class Registration {

    private int regID;
    private int userID;
    private String checkInTime;
    private String checkOutTime;

    public Registration() {
    }

    public Registration(int regID, int userID, String checkInTime, String checkOutTime) {
        this.regID = regID;
        this.userID = userID;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
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

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
}
