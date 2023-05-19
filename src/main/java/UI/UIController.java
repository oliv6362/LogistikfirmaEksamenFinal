package UI;


import Usecase.UseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UIController {

    UseCase uc = new UseCase();
    String fNameBuild;
    String lNameBuild;
    int licenceNrBuild;
    String companyBuild;

    @GetMapping("/") //Forside
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @PostMapping("/")
    public String checkIn(@RequestParam String fName, @RequestParam String lName, @RequestParam int licenceNr, @RequestParam String company) throws Exception {
        System.out.println("hello checkin");
       // System.out.println(location);
        System.out.println(lName);


        if (uc.checkInConfirm(fName, lName, licenceNr, company)) {

            System.out.println("du er nu checked ind/ud");

            return "checkInSuccess";
        } else {
            System.out.println("du er ikke checked ind");

            fNameBuild = fName;
            lNameBuild = lName;
            licenceNrBuild = licenceNr;
            companyBuild = company;
            return "newUserCheck";
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

    @RequestMapping( value="/newUserCheck", method=POST, params={"newUserCheckSubmit"} )
    public String newUserCheckSubmit() {

        System.out.println("før build");
        System.out.println("efter build");
        System.out.println("fornavn er:" + fNameBuild);
        System.out.println("efternavn er:" + lNameBuild);
        System.out.println("licenceNr er:" + licenceNrBuild);
        System.out.println("company er:" + companyBuild);

        uc.buildUser(fNameBuild, lNameBuild, licenceNrBuild, companyBuild);
        return "checkInSuccess";
    }

    @RequestMapping( value="/newUserCheck", method=POST, params={"newUserCheckCancel"} )
    public String newUserCheckCancel() {
        return "redirect:/";
    }


}
