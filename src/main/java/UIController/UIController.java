package UIController;

import Usecase.UseCase;
import Usecase.DBservice;
import dbcontroller.DBController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UIController {
    private DBservice dbService = new DBController();
    private UseCase uc = new UseCase(dbService);
    private String fNameBuild;
    private String lNameBuild;
    private String licenceNrBuild;
    private String companyBuild;
    private String locationBuild;

    @GetMapping("/") //Forside
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String checkIn(@RequestParam String fName, @RequestParam String lName, @RequestParam String licenceNr, @RequestParam String company,  @RequestParam String location) {

        if (uc.checkInConfirm(fName, lName, licenceNr, company, location)) {

            return "checkInSuccess";
        } else {
            if(uc.tryAgain == true){
                uc.tryAgain = false;
                return "redirect:/tryAgain";
            }
            System.out.println("lets go!");
            fNameBuild = fName;
            lNameBuild = lName;
            licenceNrBuild = licenceNr;
            companyBuild = company;
            locationBuild = location;
            return "redirect:/newUserCheck";
        }
    }

    @GetMapping("/checkInSuccess")
    public String checkedIn() {
        return "checkInSuccess";
    }

    @PostMapping("checkInSuccess")
    public String checkInFeedback() { //HttpSession er et springboot objekt
        return "redirect:/";
    }

    @GetMapping("/newUserCheck")
    public String newUserCheck(){
        return "newUserCheck";
    }

    @GetMapping("/tryAgain")
    public String tryAgain(){
        return "tryAgain";
    }


    @RequestMapping( value="/newUserCheck", method=POST, params={"newUserCheckSubmit"} )
    public String newUserCheckSubmit() {

        uc.buildUser(fNameBuild, lNameBuild, licenceNrBuild, companyBuild, locationBuild);
        return "checkInSuccess";
    }

    @RequestMapping( value="/newUserCheck", method=POST, params={"newUserCheckCancel"} )
    public String newUserCheckCancel() {
        return "redirect:/";
    }
}
