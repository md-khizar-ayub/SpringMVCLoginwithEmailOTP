package com.mka.mvclogin;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mka.db.NewUserAdding;
import com.mka.sendmail.SendMail;

@Controller
public class Login {
	Map<String, String> map;
	
	@RequestMapping("/login")
	public ModelAndView addUser(@RequestParam("user-name") String userName, @RequestParam("user-credentials") String credential,@RequestParam("user-email") String email) throws ClassNotFoundException {
		
		boolean emailverify= false;
		int otp=new Random().nextInt(99999,999999);
		if(email.contains("@") && sendmail(email,otp))
		{
			emailverify=true;
		}
		if(emailverify) {
			map=new HashMap<String, String>();
			map.put("user-email", email);
			map.put("user-name", userName);
			map.put("user-credentials", credential);
			map.put("otp", String.valueOf(otp));
			ModelAndView mv = new ModelAndView();
			mv.setViewName("emailverificatioin");
			mv.addAllObjects(map);
			newUser();
			return mv;
		}
		return null;

		
	}

	private void newUser() throws ClassNotFoundException {
		NewUserAdding newUser = new NewUserAdding();
		newUser.userDetails(new HashMap<String, String>(map));
	}

	private boolean sendmail(String email,int otp) {
		
		SendMail mail = new SendMail(email,otp);
		if(mail.send())
		{
			return true;
		}
		return false;
		
	}
	
}
