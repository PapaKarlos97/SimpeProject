package io.vladimir.easyApp.workingArea.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
@RequestMapping("/")
    public String firstPage(){
    return "index";
}
@PostMapping("/")
public String getData(@RequestParam(value = "name",required = false) String name,
                      @RequestParam(value = "email",required = false) String mail,
                      Model model){
    model.addAttribute("resMsg",name+", you mail is "+mail);
    return "result";
}

}
