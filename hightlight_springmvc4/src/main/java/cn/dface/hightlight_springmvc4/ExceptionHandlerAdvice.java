package cn.dface.hightlight_springmvc4;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler
	public ModelAndView exception(Exception exception,WebRequest request){
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage",exception.getMessage());
		return model;
	}
	@ModelAttribute
	public void addAttibutes(Model model){
		model.addAttribute("user","rachel");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields("id");
	}
}
