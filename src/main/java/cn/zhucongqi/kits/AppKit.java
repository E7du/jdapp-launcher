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

	private static String daemon = "dapp-daemon";
	private static String format = "conf/%s%d.pid";
	private static String application = "conf/application.dapp";
	private static Log log = Log.getLog(AppKit.class);
	
	private static boolean saveApplicationName(String applicationName) {
		String fileName = String.format(AppKit.application, applicationName);
		File file = new File(fileName);
		if (file.exists()) {
			AppKit.log.info(fileName+" is exist.");
			return true;
		}
		try {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(applicationName.getBytes("utf-8"));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			AppKit.log.error(ex.getMessage());
			return false;
		}
		
		return true;
	}

	private static boolean savePid(IServer server) {
		String pid = AppKit.currentAppPid();  

		String fileName = String.format(AppKit.format, AppKit.daemon, server.serverId());
		File file = new File(fileName);
		if (file.exists()) {
			AppKit.log.info(fileName+" is exist.");
			return true;
		}
			
		try {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(pid.getBytes("utf-8"));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			AppKit.log.error(ex.getMessage());
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
