package UI;


import Entity.User;
import Usecase.UseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UIController {

    UseCase uc = new UseCase();
    String fNameBuild;
    String lNameBuild;
    int licenceNrBuild;
    String companyBuild;
    String locationBuild;

    boolean ipCheck = false;
    String ip;

    @GetMapping("/") //Forside
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getPublicIP", method = RequestMethod.GET)
    @ResponseBody
    public String getPublicIP() throws IOException {

        if (ipCheck == false) {
            ipCheck = true;

            URL url = new URL("https://api.ipify.org/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            ip = br.readLine();
            System.out.println(ip);
            return ip;
        }
        else {
            return ip;

        }

    }

    @PostMapping("/")
    public String checkIn(@RequestParam String fName, @RequestParam String lName, @RequestParam int licenceNr, @RequestParam String company,  @RequestParam String location) {
        System.out.println("hello checkin");
        System.out.println(location);


        if (uc.checkInConfirm(fName, lName, licenceNr, company, location)) {

            System.out.println("du er nu checked ind/ud");

            return "checkInSuccess";
        } else {
            System.out.println("du er ikke checked ind");

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

    @RequestMapping( value="/newUserCheck", method=POST, params={"newUserCheckSubmit"} )
    public String newUserCheckSubmit() {

        System.out.println("før build");
        System.out.println("efter build");
        System.out.println("fornavn er:" + fNameBuild);
        System.out.println("efternavn er:" + lNameBuild);
        System.out.println("licenceNr er:" + licenceNrBuild);
        System.out.println("company er:" + companyBuild);
        System.out.println("location er:" + locationBuild);

        uc.buildUser(fNameBuild, lNameBuild, licenceNrBuild, companyBuild, locationBuild);
        return "checkInSuccess";
    }

    @RequestMapping( value="/newUserCheck", method=POST, params={"newUserCheckCancel"} )
    public String newUserCheckCancel() {
        return "redirect:/";
    }


}
