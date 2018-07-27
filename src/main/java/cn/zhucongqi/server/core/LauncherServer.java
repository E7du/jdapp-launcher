/*
 * Copyright 2018 Jobsz (zcq@zhucongqi.cn)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
*/
package cn.zhucongqi.server.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfinal.ext.config.JFinalConfigExt;
import com.jfinal.ext.config.StandaloneAppConfig;
import com.jfinal.log.Log;

import cn.zhucongqi.kits.AppKit;

/**
 * LauncherServer.java
 * @author Jobsz
 *
 */
public final class LauncherServer implements IServer {

	public static LauncherServer Server = new LauncherServer();
	
	private Log LOG = Log.getLog(LauncherServer.class);
	
	private String serverName = "";
	private Integer serverId = 0;

	private ClassPathXmlApplicationContext classPathXmlApplicationContext = null;

	private LauncherServer() {}
	
	@Override
	public String serverName() {
		return this.serverName;
	}
	
	@Override
	public Integer serverId() {
		return this.serverId;
	}
	
	@Override
	public boolean launchServer(Integer serverId) {
		boolean ret = true;
		
		StandaloneAppConfig.start();
		
		this.serverName = JFinalConfigExt.APP_NAME;
		this.serverId = serverId;
		
		if (ret) {
			AppKit.save(this);
		}
		
		LOG.info(String.format("\nThe server `%s@%d` started!", this.serverName, this.serverId));
		System.setProperty("java.net.preferIPv4Stack", "true");
		classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{String.format("conf/%s-provider.xml", this.serverName)});
		classPathXmlApplicationContext.start();
		return ret;
	}
}
