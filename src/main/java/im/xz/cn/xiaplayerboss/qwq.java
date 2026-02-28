package im.xz.cn.xiaplayerboss;

import io.papermc.paper.event.player.PrePlayerAttackEntityEvent;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Objects;

public class qwq implements Listener {

    private BossBar cachedBossBar = null;

    @EventHandler
    public void q(EntityDamageEvent event) {
        Entity target = event.getEntity();
        if (!(target instanceof Player)) {
            return;
        }

        if (!target.getUniqueId().toString().equals("1c45b6f1-d539-402f-b2f5-9bf31590d159")) {
            return;
        }

        double health = ((Player) target).getHealth();
        double maxHealth = Objects.requireNonNull(((Player) target).getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue();
        double progress = Math.max(0.0, Math.min(1.0, health / maxHealth));

        Player player = (Player) target;
        Component title = Component.text("占位符");
        if (Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue() < 20) {

            title = Component.text("酒喵 -")
                    .color(NamedTextColor.RED)
                    .append(Component.text(String.format(" ❤ %.1f/%.0f", health, maxHealth)));


        }else {
            title = Component.text("年兽 -")
                    .color(NamedTextColor.RED)
                    .append(Component.text(String.format(" ❤ %.1f/%.0f", health, maxHealth)));
        }


        if (cachedBossBar == null) {
            cachedBossBar = BossBar.bossBar(title, (float) progress, BossBar.Color.PINK, BossBar.Overlay.PROGRESS);
        } else {
            cachedBossBar.name(title);
            cachedBossBar.progress((float) progress);
        }

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.showBossBar(cachedBossBar);
        }
    }
}
