package me.capit.RadioChat;

import org.bukkit.plugin.java.JavaPlugin;

public class RadioChat extends JavaPlugin {
	
	public ChatEventHandler handler = null;
	
	@Override
	public void onEnable(){
		CommandHandler cmdh = new CommandHandler(this);
		this.getCommand("announce").setExecutor(cmdh);
		
		handler = new ChatEventHandler(this);
		this.getServer().getPluginManager().registerEvents(handler, this);
		this.getLogger().info("RadioChat ready.");
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable(){
		this.getLogger().info("RadioChat shut down.");
	}
}
