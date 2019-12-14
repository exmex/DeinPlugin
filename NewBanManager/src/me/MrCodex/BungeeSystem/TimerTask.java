package me.MrCodex.BungeeSystem;

import me.MrCodex.BungeeSystem.Commands.JoinMe;

public class TimerTask extends java.util.TimerTask {

	@Override
	public void run() {
		JoinMe.used.clear();
	}

}
