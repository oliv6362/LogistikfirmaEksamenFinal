package Usecase;

import Entity.Company;
import Entity.Location;
import Entity.Registration;
import Entity.User;

public interface DBservice {

    void registerCheckIn(Registration registration);
    User getUser(String fName, String lName, String licenceNr);
    void addUser(User u);
    Location getLocation(String locationName);
    Company getCompany(String companyName);

}
