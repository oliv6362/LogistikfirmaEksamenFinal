package Usecase;
import DB.DBController;
import Entity.User;

public class UseCase {

    DBController db = new DBController();

    public User user = new User();


    public boolean checkInConfirm(String fName, String lName, String password) {

        user = db.getUser(fName,lName,password);

        if (fName.equals(user.getfName()) && lName.equals(user.getlName()) && password.equals(user.getPassword() )) {
            user.setStatus(true);

            if(user.isStatus() == false ){
              //  db.registerCheckIn(user.getId());
            }
            //db.registerTime(hentetUser);

            return true;
        } else {
            return false;
        }
    }

        public void checkOutConfirm() {
            user.setStatus(false);
            //noget andet skal ske her
        }


    }

