package me.Omega01.LagRemover;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + getDescription().getName() + " v" + getDescription().getVersion() + " has been enabled.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Made by Omega01");
        Logger log = Bukkit.getLogger();
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.runTaskTimerAsynchronously(this, () -> {
            for (World world : Bukkit.getWorlds()) {
                for (Entity entity : world.getEntities()) {
                    switch (entity.getType()) {
                        case WITHER_SKULL:
                        case SHULKER_BULLET:
                        case LLAMA_SPIT:
                            entity.remove();
                    }
                }
            }
            log.info("§aEntites Removed (Wither_Skull | Shulker_Bullet | Llama_Spit)");
        },0, 400);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + getDescription().getName() + " v" + getDescription().getVersion() + " has been disabled.");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Made by Omega01");
    }
}
