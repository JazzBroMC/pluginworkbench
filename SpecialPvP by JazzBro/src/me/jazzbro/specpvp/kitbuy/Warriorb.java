package me.jazzbro.specpvp.kitbuy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jazzbro.specpvp.mainpack.Main;

public class Warriorb implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String labek, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		if (Main.econ.withdrawPlayer(player, 500).transactionSuccess()) {
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + player.getName() + " add sp.warrior");
			player.sendMessage(Main.PREFIX + ChatColor.GREEN + "You have bought Warrior kit!");
		} 
		else { 
			player.sendMessage(Main.PREFIX + ChatColor.RED + "You do not have enough money to purchase this kit.");
		}
		return false;
	}




}
