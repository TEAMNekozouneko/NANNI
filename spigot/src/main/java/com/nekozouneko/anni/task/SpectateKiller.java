package com.nekozouneko.anni.task;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SpectateKiller extends BukkitRunnable {

    private int ft;
    private int timer;
    private Player player;

    public SpectateKiller(int i, Player p) {
        this.ft = i;
        this.timer = i;
        this.player = p;
    }

    @Override
    public void run() {
        if (timer <= 0) {
            player.addPotionEffect(
                    new PotionEffect(
                            PotionEffectType.BLINDNESS,
                            2, 1,
                            false, false, true
                    )
            );
            player.addPotionEffect(
                    new PotionEffect(
                            PotionEffectType.SLOW,
                            2, 255,
                            false, false, true
                    )
            );
            player.sendTitle("§aリスポーン中...", "", 0, 60, 10);
            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(player.getWorld().getSpawnLocation());
            cancel();
        } else {
            player.sendTitle("§c死んでしまった！", "リスポーンまであと" + timer + "秒", 0, 25, 0);
            this.timer--;
        }
    }

}
