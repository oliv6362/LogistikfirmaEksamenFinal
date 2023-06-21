package Usecase;

import Entity.Location;
import Entity.Registration;
import Entity.User;
import Entity.Company;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UseCase {
    //DBController db = new DBController();
    // I stedet for at benytte DBController så laver vi en instans af vores interface og kalder den

    private DBservice dbService;
    User user = new User();
    Company company = new Company();
    Location location = new Location();
    public boolean tryAgain = false;

    public UseCase(DBservice dbService) { //denne constructor sørger for "dependency injection" som bestemmer hvilken interface bruger
        this.dbService = dbService;
    }

    public boolean checkInConfirm(String fName, String lName, String licenceNr, String companyName, String locationName) {
        user = dbService.getUser(licenceNr);
        
        if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && licenceNr.equals(user.getLicenceNr())){
            company = dbService.getCompany(companyName);
            location = dbService.getLocation(locationName);

            dbService.registerCheckIn((new Registration(user.getUserID(), company.getCompanyID(), location.getLocationID(), getTime())));

            return true;
        } else if (licenceNr.equals(user.getLicenceNr()) && (!fName.equals(user.getfName()) || !lName.equals(user.getlName()))) {
            tryAgain = true;
            return false;
        } else {
            return false;
        }
    }

    public void buildUser(String fName, String lName, String licenceNr, String companyName, String locationName){
        dbService.addUser(new User(fName, lName, licenceNr));

        company = dbService.getCompany(companyName);
        user = dbService.getUser(licenceNr);
        location = dbService.getLocation(locationName);

        dbService.registerCheckIn((new Registration(user.getUserID(), company.getCompanyID(), location.getLocationID(), getTime())));
    }

    public String getTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}

