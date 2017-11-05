package com.bikepool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by rampal.rao on 17/5/17.
 */
@Controller
public class HomePageController {

    private static final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(HttpServletRequest request, ModelMap modelMap) {
        return "homepage";
    }

    @RequestMapping(value = "/bikepool/join", method = RequestMethod.GET)
    public String joinBikePool() {
        logger.info("Welcome user!");
        return "bikeShareList";
    }

    @RequestMapping(value = "/bikepool/share", method = RequestMethod.GET)
    public String shareBikePool() {
        logger.info("Welcome user!");
        return "bikePoolList";
    }

    @RequestMapping(value="/login")
    public String login(HttpServletRequest request, Model model){
        return "login";
    }

    @RequestMapping(value="/logout")
    public String logout(){
        return "logout";
    }

    @RequestMapping(value="/denied")
    public String denied(){
        return "denied";
    }
}
