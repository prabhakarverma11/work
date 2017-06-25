package com.dq.arq.sme.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dq.arq.sme.domain.AdDo;

@Controller
public class AdController {

	final static Logger logger = LoggerFactory.getLogger(AdController.class);
	
	
	/**
	 * @param model
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/savead")
	public String saveAd(ModelMap model,HttpServletRequest request,@ModelAttribute("adDo") AdDo adDo,
			@RequestParam(value="adgid") Integer adgroupId,
			@RequestParam(value="showall",required = false) Integer showAll,
			@RequestParam(value="rows",required =false) Integer rows,
			@RequestParam(value="adgdpage",required= false) Integer adgroupDetailsPage) throws IOException
	{
		logger.debug("\n\n\n*************** Entering saveAd method of AdController ***************\n\n\n");
		return "test";
	}
	
	@RequestMapping(value =  { "/", "/Welcome" })
	public String renderWelcomePage(Map<String, Object> map,
			@RequestParam(value = "msg", required = false) String msg,
			@RequestParam(value = "emailId", required = false) String emailId,
			HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		logger.debug("\n\n\n*************** Entering renderWelcomePage method of LoginController ***************\n\n\n");
		
		
		if((SecurityContextHolder.getContext().getAuthentication()!=null)&&(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User)
				  && !(msg!=null && msg.equals("usernotverified")))
			return "forward:/userHome";
		
		Integer error_code = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if(error_code != null)
		{
			if(error_code == 404){				
				map.put("error", "You tried to access a page that does not exist!!");
				session.invalidate();
			}
			else if(error_code == 403)
				map.put("error", "You tried to access a forbidden page!!");
			else if(error_code == 500)
				map.put("error", "Internal error caught on the page you accessed!!");
		}

		if(msg != null)
		{
			if (msg.equals("invalidup"))
				map.put("error", "Invalid username or password!");
			else if(msg.equals("loggedout"))
					{
						map.put("error", "You have logged out successfully!");
						logger.info("\n\n\n+++++++++++++++ SUCCESS:: You have logged out successfully +++++++++++++++\n\n\n");
					}
			else if( msg.equals("usernotverified"))
			{
				map.put("error", "Please verify your account to login!");
				map.put("emailId", emailId);
				map.put("password","");
			}
			else if(msg.equals("couldnotverify"))
				map.put("error", "Sorry !! Could not verify your account.");
			else if(msg.equals("ssession"))
				map.put("error", "You are already logged on from another browser");
		}
		logger.debug("\n\n\n############### Exiting renderWelcomePage method of LoginController: 'msg="+msg+",email="+emailId+"' ###############\n\n\n");
		return "login";
	}
	
}
