package com.mka.mvclogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mka.db.VerifyUserwithOTP;

@Controller
public class VerifyUser {
	
	
	@RequestMapping("/verifyUser")
	public ModelAndView verifyUserwithOTP(@RequestParam("OTP") String otp) throws ClassNotFoundException {
		if(sendotp(otp)) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("verifyUser");
			return mv;
		}else {
			
			return new ModelAndView("Error");
		}
		

	}

	private boolean sendotp(String otp) throws ClassNotFoundException {
		
		if(otp.length() == 6 && VerifyUserwithOTP.verifyUser(otp)) {
			
			return true;
			
		}
		return false;
		
	}

}
