/**
 * 
 */
package cn.zhucongqi.server.core;

import com.jfinal.log.Log;

import cn.zhucongqi.server.Main;

/**
 * Launcher.java
 * @author Jobsz
 *
 */
@SuppressWarnings("unused")
public final class Launcher {

	/**
	 * @param ids
	 * @throws InterruptedException 
	 */
	public static void laucher(String[] ids) throws InterruptedException {
		
		Integer id = 1;
		boolean debug = true;
		if (ids.length > 0) {
			try {
				id = Integer.valueOf(ids[0]);
			} catch (NumberFormatException e) {
				System.out.println("please use number set 'id'.");
				Log.getLog(Main.class).error("please use number set 'id'.");
				return;
			}
			debug = (ids.length > 1) && (ids[1].equalsIgnoreCase("debug"));
		}
		
		boolean ret = LauncherServer.Server.launchServer(id);
		
		if (!ret) {
			return;
		}
		
		Thread.currentThread().join();
	}
	
}
