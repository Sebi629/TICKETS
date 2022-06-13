package pl.coderslab.tickets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.tickets.service.LoadDbService;

@Controller
public class LoadDbController {

    private final LoadDbService loadDbService;

    public LoadDbController(LoadDbService loadDbService) {
        this.loadDbService = loadDbService;
    }
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String data(){
        loadDbService.loadDb();
        return "redirect:/ticket";
    }
}
