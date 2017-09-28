package com.hsp.test;

import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import com.hsp.admin.service.IUserService;
import com.hsp.admin.service.Impl.UserServiceImpl;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-*.xml"})
public class UserServiceTest {
	
	@Autowired
	IUserService userServiceImpl;
	
	@Test
	public void testBindRoles(){
		System.out.println(userServiceImpl);
		userServiceImpl.getUserByUsername("admin");
	}

}
