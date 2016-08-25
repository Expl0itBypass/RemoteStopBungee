package com.gmail.lynx7478.remotestop.bungee;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

public class RemoteStop extends Plugin {
	
	private static RemoteStop instance;
	
	public static RemoteStop getInstance()
	{
		return instance;
	}
	
	@Override
	public void onEnable()
	{
		instance = this;
		BungeeCord.getInstance().registerChannel("BungeeCord");
		
		this.getProxy().getPluginManager().registerCommand(this, new RemoteStopCommand());
	}

}
