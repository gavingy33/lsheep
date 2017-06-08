package com.lsheep.test;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lsheep.logger.Logger;
import com.lsheep.logger.factory.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/testContext.xml")
public class BaseTest {

	protected Logger logger;

	@PostConstruct
	public void logger() {
		this.logger = LoggerFactory.getLogger(getClass());
	}

}
