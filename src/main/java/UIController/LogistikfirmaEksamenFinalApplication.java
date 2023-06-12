package UIController;

import dbcontroller.DBController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogistikfirmaEksamenFinalApplication {
	static DBController db = new DBController();
	public static void main(String[] args) {
		SpringApplication.run(LogistikfirmaEksamenFinalApplication.class, args);
		db.deleteRegistrationBasedOnAge();
	}

}
