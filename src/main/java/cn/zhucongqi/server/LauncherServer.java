/**
 * 
 */
package cn.zhucongqi.server;

import com.jfinal.ext.config.JFinalConfigExt;
import com.jfinal.ext.config.StandaloneAppConfig;

import cn.zhucongqi.kits.PidKit;

/**
 * LauncherServer.java
 * @author Jobsz
 *
 */
public final class LauncherServer implements IServer {

	public static LauncherServer Server = new LauncherServer();
	
	private String serverName = "";
	private Integer serverId = 0;
	
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
			PidKit.save(this);
		}
		
		System.out.println(String.format("The server `%s%d` launched...", this.serverName, this.serverId));
		return ret;
	}
}
