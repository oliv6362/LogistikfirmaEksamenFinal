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


    Registration reg = new Registration();

    User user = new User();

    Company company = new Company();

    Location location = new Location();

    public boolean checkInConfirm(String fName, String lName, int licenceNr, String companyName) {
        user = db.getUser(fName, lName, licenceNr);
        company = db.getCompany(companyName);


        if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && licenceNr == user.getLicenceNr()) {

            db.registerCheckIn((new Registration(user.getUserID(), company.getCompanyID(), 1, getTime())));

            return true;
        } else {

            return false;
        }

    }

    public void buildUser(String fName, String lName, int licenceNr, String companyName){
        System.out.printf("vi er i usecase dbuild user");
        /*db.addUser(new User(fName, lName, licenceNr));

        company = db.getCompany(companyName);
        user = db.getUser(fName, lName, licenceNr);
        db.registerCheckIn((new Registration(user.getUserID(), company.getCompanyID(), location.getLocationID(), getTime())));*/
    }

    public String getTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    } // TODO: fix registerCheckIn/Out
}

