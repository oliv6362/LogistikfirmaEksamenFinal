package UI;


import Entity.User;
import Usecase.UseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.web.server.Cookie;
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

    @GetMapping("/") //Forside
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @PostMapping("/")
    public String checkInAndOut(@RequestParam String fName, @RequestParam String lName, @RequestParam String password){
        System.out.println("hello checkin");

        if (uc.checkInAndOutConfirm(fName, lName, password)) {

        System.out.println("du er nu checked ind/ud");

        return "index";
        } else {
        System.out.println("du er ikke checked ind");
        return "redirect:/";
        }
    }
}
