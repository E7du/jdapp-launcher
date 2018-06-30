/**
 * 
 */
package cn.zhucongqi.server;

/**
 * IServer.java
 * @author Jobsz
 *
 */
public interface IServer {

	public String serverName();
	
	public Integer serverId();
	
	public boolean launchServer(Integer serverId);
	
}
