package com.seu.xyd.logic;

import javax.servlet.ServletException;

import org.junit.Test;

import com.seu.xyd.data.User;
import com.tn17.mysql.DBProcessException;

public class UserLogicTest {
	@Test
	public void testUpdateUser() throws DBProcessException, ServletException{
		final UserLogic uL = UserLogic.getInstance();
		User user = uL.getUserByAccount("admin");
		System.out.println(user.toString());
		user.setBalance(120.00);
		uL.updateUser(user);
		user = uL.getUserByAccount("admin");
		System.out.println(user.toString());
	}
	
}
