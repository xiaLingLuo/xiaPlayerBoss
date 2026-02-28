package im.xz.cn.xiaplayerboss;

import org.bukkit.attribute.Attribute;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


import java.util.Objects;

public class mofaKangxing implements Listener {
    @EventHandler

    public void qwq(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (!event.getEntity().getUniqueId().toString().equals("1c45b6f1-d539-402f-b2f5-9bf31590d159")) {
            return;
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.MAGIC)) {
            Player player = (Player) event.getEntity();
            if (Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue() < 20) {
                event.setCancelled(true);
                return;
            }else{
                event.setCancelled(true);
                double qwq = event.getDamage();
                double new_qwq = qwq * 0.2;
                double awa = player.getHealth() - new_qwq;
                player.setHealth(awa);
            }
        }

        if (event.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            Player player = (Player) event.getEntity();
            double half = Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue() / 2 ;
            if (player.getHealth() < half) {
                event.setCancelled(true);
            }
        }


    }

}
