package im.xz.cn.xiaplayerboss;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class XiaPlayerBoss extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new qwq(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new tpThing(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new mofaKangxing(),this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
