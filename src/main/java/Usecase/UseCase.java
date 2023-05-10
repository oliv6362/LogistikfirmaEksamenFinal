package Usecase;
import DB.DBController;
import Entity.User;

public class UseCase {

    DBController db = new DBController();

    public User dbUser = new User();


    public boolean checkInConfirm(String fName, String lName, String password) {

        dbUser = db.getUser(fName,lName,password);

        if (email.equals(dbUser.getEmail()) && password.equals(dbUser.getPassword() )) {
            dbUser.setLogin(true);

            //db.registerTime(hentetUser);


            return true;

        } else {
            return false;
        }
    }
}
