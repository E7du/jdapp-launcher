package org.apache.dubbo.demo.provider;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.Test;

import cn.zhucongqi.server.core.Launcher;

class DemoProvider {

	@Test
	void test() throws InterruptedException {
		//-D${LOG4J_CFG} 
		PropertyConfigurator.configure("src/test/resources/conf/log4j.properties");
		
		Launcher.laucher(new String[] {}) ;
	}

}
