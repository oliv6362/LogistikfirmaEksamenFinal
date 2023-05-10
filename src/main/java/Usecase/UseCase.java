package Usecase;
import DB.DBController;
import Entity.User;

public class UseCase {

    DBController db = new DBController();

    public User dbUser = new User();


    public boolean checkInConfirm(String fName, String lName, String password) {

        dbUser = db.getUser(fName,lName,password);

        if (fName.equals(dbUser.getfName()) && lName.equals(dbUser.getlName()) && password.equals(dbUser.getPassword() )) {
            dbUser.setStatus(true);

            //db.registerTime(hentetUser);

            return true;
        } else {
            return false;
        }
    }
}
