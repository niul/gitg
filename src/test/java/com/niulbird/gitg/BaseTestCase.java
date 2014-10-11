package com.niulbird.gitg;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/applicationContext-test.xml")
public class BaseTestCase extends TestCase {

	@Autowired
	protected MessageSource messageSource;
	
	@Before
	public void setup() {
		System.out.println("Test");
	}
}