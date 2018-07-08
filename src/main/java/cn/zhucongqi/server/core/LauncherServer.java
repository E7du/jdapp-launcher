/**
 * 
 */
package cn.zhucongqi.server.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jfinal.ext.config.JFinalConfigExt;
import com.jfinal.ext.config.StandaloneAppConfig;

import cn.zhucongqi.kits.AppKit;

/**
 * LauncherServer.java
 * @author Jobsz
 *
 */
public final class LauncherServer implements IServer {

	public static LauncherServer Server = new LauncherServer();
	
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
		
		System.out.println(String.format("\nThe server `%s@%d` started!", this.serverName, this.serverId));
		System.setProperty("java.net.preferIPv4Stack", "true");
		classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{String.format("conf/%s-provider.xml", this.serverName)});
		classPathXmlApplicationContext.start();
		return ret;
	}
}
