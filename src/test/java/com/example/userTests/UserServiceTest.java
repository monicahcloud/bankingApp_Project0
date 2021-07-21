package com.example.userTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.dao.UserDao;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.models.User;
import com.example.services.UserServices;

public class UserServiceTest {

		@InjectMocks
		public UserServices uServ;
		
		@Mock
		public UserDao uDao;
		
		@Before
		public void initMocks() {
			MockitoAnnotations.initMocks(this);
		}
		
		@Test
		public void testValidLogin() {
			User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
			User not = new User(0, "test", "user", "testuser", "test@mail.com", "testpass");
			
			when(uDao.getUserByUsername(toString())).thenReturn(u1);
			
			User loggedIn = uServ.login("testuser", "testpass");
			
			assertEquals(u1.getId(), loggedIn.getId());
		}
		
		@Test(expected = UserDoesNotExistException.class)
		public void testInvalidUsername() {
			User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
			User not = new User(0, "test", "user", "testuser", "test@mail.com", "testpass");
			
			when(uDao.getUserByUsername(toString())).thenReturn(not);
			
			User loggedIn = uServ.login("testuser", "testpass");
		}
		
		@Test(expected = InvalidCredentialsException.class)
		public void testInvalidPassword() {
			User u1 = new User(1, "test", "user", "testuser", "test@email.com", "testpass");
			User not = new User(1, "test", "user", "testuser", "test@mail.com", "wrongpass");
			
			when(uDao.getUserByUsername(toString())).thenReturn(not);
			
			uServ.login("testuser", "testpass");
		}
}
