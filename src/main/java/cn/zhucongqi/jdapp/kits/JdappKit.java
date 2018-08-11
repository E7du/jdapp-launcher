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
package cn.zhucongqi.jdapp.kits;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import com.jfinal.log.Log;

import cn.zhucongqi.jdapp.server.core.IJdappServer;

/**
 * @author Jobsz
 */
public final class JdappKit {

	private static String daemon = "jdapp-daemon";
	private static String format = "conf/%s%d.pid";
	private static String application = "conf/application.jdapp";
	private static Log log = Log.getLog(JdappKit.class);
	
	private static boolean saveApplicationName(String applicationName) {
		String fileName = String.format(JdappKit.application, applicationName);
		File file = new File(fileName);
		try {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(applicationName.getBytes("UTF-8"));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			JdappKit.log.error(ex.getMessage());
			return false;
		}
		
		return true;
	}

	private static boolean saveJdappPid(IJdappServer jdappServer) {
		String pid = JdappKit.currentAppPid();  

		String fileName = String.format(JdappKit.format, JdappKit.daemon, jdappServer.serverId());
		File file = new File(fileName);
		try {
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
			out.write(pid.getBytes("UTF-8"));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			JdappKit.log.error(ex.getMessage());
			return false;
		}
		return true;
	}
	
	public static String currentAppPid() {
		return ManagementFactory.getRuntimeMXBean().getName().split("@")[0]; 
	}
	
	public static boolean save(IJdappServer jdappServer) {
		return JdappKit.saveApplicationName(jdappServer.serverName()) && JdappKit.saveJdappPid(jdappServer);
	}
}
