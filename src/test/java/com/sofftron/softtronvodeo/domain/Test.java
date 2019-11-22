package com.sofftron.softtronvodeo.domain;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.softtron.softtronvodeo.config.Init;
import com.softtron.softtronvodeo.service.VideoService;
@SpringBootTest(classes = {Init.class})
@RunWith(SpringRunner.class)
public class Test {
	@Autowired
	VideoService video;
	@org.junit.Test
	public void test() {
		
		video.insert();
	}

}
