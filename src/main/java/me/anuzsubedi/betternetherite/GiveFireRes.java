package me.anuzsubedi.betternetherite;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;


public class GiveFireRes implements Listener {

    Material wornHelmet;
    Material wornChestPlate;
    Material wornLeggings;
    Material wornBoots;
    Player player;
    static Main plugin;
    public GiveFireRes(Main main) {
        plugin=main;
    }

    @EventHandler
    public void OnDamage(EntityDamageEvent e){
        try{
            boolean allowElytra = plugin.getConfig().getBoolean("allow-elytra");
            if(e.getEntity() instanceof Player){
                player = (Player) e.getEntity();
                this.wornHelmet = Objects.requireNonNull(player.getInventory().getHelmet()).getType();
                this.wornChestPlate = Objects.requireNonNull(player.getInventory().getChestplate()).getType();
                this.wornLeggings = Objects.requireNonNull(player.getInventory().getLeggings()).getType();
                this.wornBoots = Objects.requireNonNull(player.getInventory().getBoots()).getType();

                if(e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || e.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR){
                    if (allowElytra){
                        if (wornHelmet == Material.NETHERITE_HELMET && (wornChestPlate == Material.NETHERITE_CHESTPLATE || wornChestPlate == Material.ELYTRA) && wornLeggings == Material.NETHERITE_LEGGINGS && wornBoots == Material.NETHERITE_BOOTS) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1, 0, false, true));
                            e.setCancelled(true);
                        }
                    }
                    else if (wornHelmet == Material.NETHERITE_HELMET && wornChestPlate == Material.NETHERITE_CHESTPLATE && wornLeggings == Material.NETHERITE_LEGGINGS && wornBoots == Material.NETHERITE_BOOTS) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1, 0, false, true));
                        e.setCancelled(true);
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
