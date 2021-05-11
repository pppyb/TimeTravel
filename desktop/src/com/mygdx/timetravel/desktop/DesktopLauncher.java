package com.mygdx.timetravel.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.timetravel.TimeTravelMain;

//我们的桌面启动类，毕竟也没其他启动方式了……
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Time Travel";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new TimeTravelMain(), config);
	}
}
