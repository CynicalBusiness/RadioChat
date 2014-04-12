package me.capit.RadioChat;

import org.bukkit.plugin.java.JavaPlugin;

public class RadioChat extends JavaPlugin {
	
	public ChatEventHandler handler = null;
	
	@Override
	public void onEnable(){
		handler = new ChatEventHandler(this);
		this.getServer().getPluginManager().registerEvents(handler, this);
		this.getLogger().info("RadioChat ready.");
	}
	
	@Override
	public void onDisable(){
		this.getLogger().info("RadioChat shut down.");
	}
}
