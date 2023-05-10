package Entity;

public class Registration {

    private int regId;
    private int userId;
    private String checkInTime;
    private String checkOutTime;

    public Registration(int regId) {
        this.regId = regId;
    }
    public Registration(int userId, String checkInTime, String checkOutTime) {
        this.userId = userId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;

    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
