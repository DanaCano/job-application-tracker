package com.example.apptracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootRedirectController {

  // GET /
  @GetMapping("/")
  public String root() {
    //endpoint JSON
    return "redirect:/api/applications";
  }
}