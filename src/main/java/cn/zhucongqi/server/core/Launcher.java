/**
 * Copyright (c) 2018, Jobsz (zcq@zhucongqi.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
