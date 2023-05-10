package Usecase;

import DB.DBController;
import Entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UseCase {

    DBController db = new DBController();

    public User user = new User();


    public boolean checkInConfirm(String fName, String lName, String password) {

        user = db.getUser(fName, lName, password);

            if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && password.equals(user.getPassword())) {
                if (user.isStatus() == false) {
                db.registerCheckIn(user.getId(), getTime());
                user.setStatus(true);
            } else {
                db.registerCheckOut(user.getId(), getTime());
                user.setStatus(false); }
            return true;
        } else {
                return false;
            }
    }


    public String getTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }


}

