package Usecase;

import DB.DBController;
import Entity.Registration;
import Entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UseCase {

    DBController db = new DBController();
    User user = new User();

    Registration reg = new Registration();

    public boolean checkInConfirm(String fName, String lName, String password) {

        user = db.getUser(fName, lName, password);

        if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && password.equals(user.getPassword())) {

            if (user.getStatus() == 0) {
                user.setStatus(1);

                db.registerCheckIn((new Registration(user.getUserID(), getTime())), new User(user.getStatus()));
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOutConfirm(String fName, String lName, String password) {

        user = db.getUser(fName, lName, password);

        if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && password.equals(user.getPassword())) {

            if (user.getStatus() == 1) {
                user.setStatus(0);

                db.registerCheckOut((new Registration(user.getUserID(), getTime())), new User(user.getStatus()));
            }
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

