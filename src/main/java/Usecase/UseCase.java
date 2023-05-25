package Usecase;

import DB.DBController;
import Entity.Location;
import Entity.Registration;
import Entity.User;
import Entity.Company;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UseCase {
    DBController db = new DBController();
    User user = new User();
    Company company = new Company();
    Location location = new Location();

    public boolean checkInConfirm(String fName, String lName, String licenceNr, String companyName, String locationName) {
        user = db.getUser(fName, lName, licenceNr);
        
        if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && licenceNr.equals(user.getLicenceNr())){
            company = db.getCompany(companyName);
            location = db.getLocation(locationName);

            db.registerCheckIn((new Registration(user.getUserID(), company.getCompanyID(), location.getLocationID(), getTime())));

            return true;
        } else {
            return false;
        }
    }

    public void buildUser(String fName, String lName, String licenceNr, String companyName, String locationName){
        db.addUser(new User(fName, lName, licenceNr));

        company = db.getCompany(companyName);
        user = db.getUser(fName, lName, licenceNr);
        location = db.getLocation(locationName);

        db.registerCheckIn((new Registration(user.getUserID(), company.getCompanyID(), location.getLocationID(), getTime())));
    }

    public String getTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}

