package im.xz.cn.xiaplayerboss;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class tpThing implements Listener {
    @EventHandler
    public void qwq(PlayerInteractEvent event) {
        Player user = event.getPlayer();
        if (!user.getUniqueId().toString().equals("1c45b6f1-d539-402f-b2f5-9bf31590d159")) {
            return;
        }
        if (user.getInventory().getItemInMainHand().getType().equals(Material.STICK)) {
            if (event.getClickedBlock() != null) {
                Location location = event.getClickedBlock().getLocation();
                Location location1 = new Location(user.getWorld(),location.getX(),location.getY()+1,location.getZ());
                user.teleport(location1);
            }
        }
    }
}
