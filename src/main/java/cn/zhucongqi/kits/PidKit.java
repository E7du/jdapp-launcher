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
public final class PidKit {
	
	private static String format = "%s%d.pid";

	public static String currentAppPid() {
		return ManagementFactory.getRuntimeMXBean().getName().split("@")[0]; 
	}
	
	public static boolean save(IServer server) {
		String pid = PidKit.currentAppPid();  
		try {
			File file = new File(String.format(format, server.serverName(), server.serverId()));
			if (!file.exists())
				file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(pid.getBytes("utf-8"));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			Log.getLog(PidKit.class).error(ex.getMessage());
			return false;
		}
		return true;
	}
}
