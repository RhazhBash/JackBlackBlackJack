package com.revature.services;

import com.revature.daos.userDAO;
//import com.revature.models.ChipDTO;
import com.revature.models.User;
import com.revature.utils.JWTUtil;

public class LoginService {
	
	userDAO udao = new userDAO();
	
	public boolean login(String username, String password) {
		
		boolean state;																		
		User user = udao.getUserByCredentials(username);									//get user
		if(user.getUsername().equals(username)  && user.getPassword().equals(password)) {	//compare credentials
			state = true; //success			
			} else { 
			state = false;//failed
			}
		System.out.println("Succesful Log in!!");
		return state;
		//If user is banned 
	}
	
	public boolean register(User user) {
		if (udao.getUserByCredentials(user.getUsername())==null) {
			udao.addUser(user);
			return true;
		}
		else 
			return false;
	}
	
	public boolean addFriend(String adder, String reciever) {
		
		User user = udao.getUserByCredentials(adder);
		
		if (udao.getUserByCredentials(reciever)!=null) {
			user.getFriends().add(reciever);
			System.out.println(user.getFriends());
			udao.addUser(user);
			return true;
		}
		else
			return false;
	}
	
	public User getUser(String username) {
		User user = udao.getUserByCredentials(username);
		User userReturn = new User(user.getID(),user.getName(),user.getUsername(),user.getChipCount());
		return userReturn;
	}
	
	public void updateUser(User user) {
		udao.updateUserInfo(user);
	}
	
	//public void sendChips(ChipDTO CDTO) {
		
		//User sender = udao.getUserByCredentials(JWTUtil.decode(CDTO.getJwt()));
		
		//if (sender.getChipCount()>=CDTO.getChips()) {
			
		//	User recipient = udao.getUserByCredentials(CDTO.getReciepient());
			
		//	int senderChips = sender.getChipCount()-CDTO.getChips();
		//	int recipientChips = recipient.getChipCount()+CDTO.getChips();
			
		//	sender.setChipCount(senderChips);
		//	udao.updateUserInfo(sender);
		//	recipient.setChipCount(recipientChips);
		//	udao.updateUserInfo(recipient);
		//}
		
	//}
}
