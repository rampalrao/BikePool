package com.bikepool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rampal.rao on 17/5/17.
 */
@Controller
public class HomePageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(HttpServletRequest request, ModelMap modelMap) {
        return "homepage";
    }
}
