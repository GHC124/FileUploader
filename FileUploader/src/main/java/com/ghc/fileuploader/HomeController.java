package com.ghc.fileuploader;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ghc.fileuploader.aspect.logging.Loggable;

/**
 * Handles requests for the application home page.
 */
@Controller
@Loggable
public class HomeController {
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "kent-style/index.html";
	}
	
}
