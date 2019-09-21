package su.nepom.spring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        var mv = new ModelAndView();
        mv.setViewName("users");
        return mv;
    }

    @GetMapping(value = "/edit")
    public ModelAndView editPage() {
        var mv = new ModelAndView();
        mv.setViewName("editPage");
        return mv;
    }
}
