package tw.com.artlong.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("homePageController")
public class HomePageController {

	private Logger logger = Logger.getLogger(HomePageController.class);

  @RequestMapping("/")
  public String homepage(ModelMap model, HttpServletRequest request, HttpServletResponse response){
	  logger.info("Come now[" + new Date() + "] AAA");
	  return "index";
  }
}