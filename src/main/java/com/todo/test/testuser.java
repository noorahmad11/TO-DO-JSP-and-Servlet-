package com.todo.test;

import com.todo.dao.Userdaoimp;
import com.todo.dto.User;

public class testuser {

	public static void main(String[] args) {
		User u = Userdaoimp.Read("abhi1","rai@123");
		System.out.println(u);
	}

}
