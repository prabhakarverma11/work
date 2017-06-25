/**
 * 
 */
package com.dq.arq.sme.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dq.arq.sme.dao.ContactDao;
import com.dq.arq.sme.domain.ContactDo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author prabhakar
 *
 */
@RestController
@RequestMapping("/api")
public class ContactController {
	@Autowired
	ContactDao contactDao;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void getLoggedIn(HttpServletRequest request, HttpServletResponse response){
//		response.addHeader("Access-Control-Allow-Methods", "POST");
//		response.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
//		response.addHeader("Access-Control-Allow-Origin", "*");
		try {
			System.out.println(request.getParameterMap());
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			Map<String, String[]> map =  request.getParameterMap();
			Object object = null;
			for(Map.Entry<String, String[]> entry : map.entrySet()){
				object = entry.getKey();
				entry.getValue();
			}
			JsonParser parser = new JsonParser();
			JsonObject json = (JsonObject) parser.parse(object.toString());
			String username = json.get("username").getAsString();
			String password = json.get("password").getAsString();
			
			ContactDo contactDo = contactDao.getContactDoByUsernameAndPassword(username, password);
			Integer idToken =null;
			if(contactDo !=null){
				idToken = 12345;
				JsonObject obj = new JsonObject();
				JsonObject user = new JsonObject();
				user.addProperty("name", contactDo.getName());
				user.addProperty("id_token", idToken);
				
				obj.addProperty("user", user.toString());
				response.setStatus(200);
				out.print(obj);
			}
			else{
				response.sendError(403);
			}
			
		} catch (IOException e) {
			response.setStatus(401);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/signup")
	public void getSignedUp(HttpServletRequest request, HttpServletResponse response){
		response.addHeader("Access-Control-Allow-Methods", "POST");
		response.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
		response.setContentType("application/json");

		request.getHeaders("Access-Control-Allow-Origin");
		Map<String, String[]> map =  request.getParameterMap();
		Object object = null;
		for(Map.Entry<String, String[]> entry : map.entrySet()){
			object = entry.getKey();
			entry.getValue();
		}
		
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject) parser.parse(object.toString());
		String name = json.get("name").getAsString();
		String password = json.get("password").getAsString();
		String emailId = json.get("email").getAsString();
		String phoneNumber = json.get("phone").getAsString();
		ContactDo newContact = new ContactDo(name,password,emailId,phoneNumber);
		try {
			Integer id = contactDao.saveContact(newContact);
			PrintWriter out = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("id",id);
			response.setStatus(200);
			out.print(obj);
		} catch (IOException e) {
			response.setStatus(401);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/user")
	public ContactDo addUser(ContactDo contactDo) {
		System.out.println("creating user with name: "+contactDo.getName()+" and emailId: "+contactDo.getEmailId());
		return contactDao.addUser(contactDo);
	}
	
	@RequestMapping("/userlist")
	public void getAllUsers(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		JsonObject obj = new JsonObject();
		obj.addProperty("name", "prabhakar");
		obj.addProperty("password", "verma");
		response.setContentType("application/json");
		PrintWriter write = response.getWriter();
		write.println(obj.toString());
		write.flush();
	//	return obj.toString();
//		return contactDao.getAllUsers();
	}
	
	@RequestMapping("/savecontact")
	public void saveContact(ContactDo contactDo) {
		contactDao.saveContact(contactDo);
	}
	
	@RequestMapping("/updatecontact")
	public void updateContact(ContactDo userDo) {
		System.out.println(userDo.toString());
		contactDao.updateContact(userDo);
	}
	
	@RequestMapping("/deletecontact")
	public void deleteContact(ContactDo userDo) {
		System.out.println(userDo.toString());
		contactDao.deleteContact(userDo);
	}
	
//	@RequestMapping("/fileupload")
//	public void fileupload(@Request("file") InputStream in) {
//		OutputStream outputStream = null;
//		try {
//			outputStream = new FileOutputStream(new File("/Users/prabhakar/Documents/newworkspace/arq/ChatModule/src/main/webapp/file.png"));
//			int read = 0;
//			byte[] bytes = new byte[1024];
//
//			while ((read = in.read(bytes)) != -1) {
//				outputStream.write(bytes, 0, read);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//contactDao.savePhoto(uploadedInputStream);
//	}
//	
//	@RequestMapping("/filedownload")
//	public OutputStream filedownload(Integer id) throws IOException {
//		OutputStream outputStream = null;
//		InputStream in = null;
////		in = contactDao.fileDownload(id);
//		try {
//			in = new FileInputStream(new File("/Users/prabhakar/Documents/newworkspace/arq/ChatModule/src/main/webapp/file.pdf"));
//			int read = 0;
//			byte[] bytes = new byte[1024];
//
//			while ((read = in.read(bytes)) != -1) {
//				outputStream.write(bytes, 0, read);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return outputStream;
////		File file = new File("/Users/prabhakar/Documents/newworkspace/arq/ChatModule/src/main/webapp/file.png");
////
////		ResponseBuilder response = Response.ok((Object) file);
////		response.header("Content-Type",
////			"image/png");
////		return response.build();
//	}
//	
//	
//	@RequestMapping("/login")
//	public ContactDo login(ContactDo contactDo)
//	{
//		System.out.println("Got User with email id: "+contactDo.getEmailId());
//		ContactDo dbUserDo = contactDao.getContactDoByEmailIdAndPassword(contactDo);
//		return dbUserDo;
//	}
	
}
