package su.nepom.spring1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import su.nepom.spring1.model.User;
import su.nepom.spring1.model.UserDAO;

@Controller
public class UserController {
    @Autowired
    private UserDAO users;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        var mv = new ModelAndView();
        mv.setViewName("users");
        mv.addObject("users", users.allUsers());
        return mv;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable int id) {
        var user = users.getById(id);
        var mv = new ModelAndView();
        mv.setViewName("editPage");
        mv.addObject("user", user);
        return mv;
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@ModelAttribute("user") User user) {
        var mv = new ModelAndView();
        mv.setViewName("redirect:/");
        users.update(user);
        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        var mv = new ModelAndView();
        mv.setViewName("editPage");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping(value = "/add")
    public ModelAndView add(@ModelAttribute("user") User user) {
        var mv = new ModelAndView();
        mv.setViewName("redirect:/");
        users.add(user);
        return mv;
    }
}
