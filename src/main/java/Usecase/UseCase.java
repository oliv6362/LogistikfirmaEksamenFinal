package Usecase;

import DB.DBController;
import Entity.Location;
import Entity.Registration;
import Entity.User;
import Entity.Company;
import Entity.Location;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UseCase {

    DBController db = new DBController();

    User user = new User();
    Registration reg = new Registration();
    Company company = new Company();
    Location location = new Location();

    public boolean checkInAndOutConfirm(String fName, String lName, String password) {

        user = db.getUser(fName, lName, password);

        if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && password.equals(user.getPassword())) {

            if (user.getStatus() == 0) {
                user.setStatus(1);

                db.registerCheckIn((new Registration(user.getUserID(), getTime())), new User(user.getStatus()));
            }
            else if (user.getStatus() == 1) {
                user.setStatus(0);

                db.registerCheckOut((new Registration(user.getUserID(), getTime())), new User(user.getStatus()));
            }
            return true;
        } else {
            return false;
        }
    }

    public void buildUser(String fName, String lName, String companyName, String password, String locationName){
        company = db.getCompany(companyName);
        location = db.getlocation(locationName);
        db.addUser(new User(fName, lName, company.getCompanyID(), password, location.getLocationID(), 0));

    }

    public String getTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    } // TODO: fix registerCheckIn/Out
}

