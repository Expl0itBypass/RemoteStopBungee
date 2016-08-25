package com.gmail.lynx7478.remotestop.bungee;

import java.util.Map.Entry;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;

public class RemoteStopCommand extends Command {

	public RemoteStopCommand() {
		super("remotestop");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) 
	{
		if(sender.hasPermission("stopall.command"))
		{
			sender.sendMessage(ChatColor.RED+"Stopping servers...");
			for(Entry<String, ServerInfo> e : RemoteStop.getInstance().getProxy().getServers().entrySet())
			{
				this.sendShutdownMessage(e.getKey());
			}
			RemoteStop.getInstance().getProxy().stop();
		}
	}
	
	private void sendShutdownMessage(String name)
	{
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Stop");
		
		BungeeCord.getInstance().getServerInfo(name).sendData("BungeeCord", out.toByteArray());
	}
}
