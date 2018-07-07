/**
 * 
 */
package cn.zhucongqi.kits;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import com.jfinal.log.Log;

import cn.zhucongqi.server.core.IServer;

/**
 * @author Jobsz
 */
public final class AppKit {
	
	private static String format = "conf/%s%d.pid";
	private static String application = "conf/application.app";
	
	private static boolean saveApplicationName(String applicationName) {
		File file = new File(String.format(AppKit.application, applicationName));
		if (file.exists()) {
			Log.getLog(AppKit.class).info("application.app file is exist.");
			return true;
		}
		try {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(applicationName.getBytes("utf-8"));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			Log.getLog(AppKit.class).error(ex.getMessage());
			return false;
		}
		
		return true;
	}

	private static boolean savePid(IServer server) {
		String pid = AppKit.currentAppPid();  

		File file = new File(String.format(AppKit.format, server.serverName(), server.serverId()));
		if (file.exists()) {
			Log.getLog(AppKit.class).info("pid file is exist.");
			return true;
		}
			
		try {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(pid.getBytes("utf-8"));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			Log.getLog(AppKit.class).error(ex.getMessage());
			return false;
		}
		return true;
	}
	
	public static String currentAppPid() {
		return ManagementFactory.getRuntimeMXBean().getName().split("@")[0]; 
	}
	
	public static boolean save(IServer server) {
		return AppKit.saveApplicationName(server.serverName()) && AppKit.savePid(server);
	}
}
