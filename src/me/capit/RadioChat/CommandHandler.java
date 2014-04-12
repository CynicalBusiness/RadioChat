package me.capit.RadioChat;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CommandHandler implements CommandExecutor{
	public enum CommandOutput{
		SUCCESS, NULL, BAD_SENDER, BAD_ARG_COUNT, BAD_ARG,
		NO_PERMISSION, ALREADY_EXISTS, MUST_LEAVE, NO_ORG_PERMISSION,
		BAD_ORG, NOT_IN_ORG, TODO
	}
	
	Plugin plugin = null;
	List<String> helpList = Arrays.asList(
			"&e/org create [name] &r- &7Founds a new organization.");
	
	public CommandHandler(Plugin p){
		plugin=p;
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("announce")){
			if (s.hasPermission("radiochat.announce")){
				if (args.length!=0){
					Player[] players = plugin.getServer().getOnlinePlayers();
					String msg = "";
					for (String arg : args){
						msg += " "+arg;
					}
					for (Player pl : players){
						pl.sendMessage(ChatColor.YELLOW+"[Announcement]: "+msg);
					}
					return true;
				} else {
					s.sendMessage("[RandomSpawn]"+ChatColor.RED+" Too few arguments!");
					return true;
				}
			} else {
				s.sendMessage("[RandomSpawn]"+ChatColor.RED+" You don't have permission for that!");
				return true;
			}
		}
		return false;
	}
	
}
