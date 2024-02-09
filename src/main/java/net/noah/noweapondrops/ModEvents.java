package net.noah.noweapondrops;

import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.*;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = NoWeaponDrops.MOD_ID)
    public static class EventHandler {
        @SubscribeEvent
        public static void onLivingDrops(LivingDropsEvent event) {
            if (event.getEntity() instanceof Piglin) {
                //golden sword, crossbow, golden armor
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof SwordItem i
                        && i.getTier().equals(Tiers.GOLD));
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof ArmorItem i
                        && i.getMaterial().equals(ArmorMaterials.GOLD));
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof CrossbowItem);
            }
            if (event.getEntity() instanceof ZombifiedPiglin) {
                //golden sword
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof SwordItem i
                        && i.getTier().equals(Tiers.GOLD));
            }
            if (event.getEntity() instanceof Drowned) {
                //fishing rod
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof FishingRodItem);
            }
            if (event.getEntity() instanceof Pillager) {
                //crossbow
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof CrossbowItem);
            }
            if (event.getEntity() instanceof Skeleton || event.getEntity() instanceof Stray) {
                //armor, bow
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof BowItem);
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof ArmorItem i
                        && !i.getMaterial().equals(ArmorMaterials.CHAIN));
            }
            if (event.getEntity() instanceof Vindicator) {
                //axe
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof AxeItem i
                        && i.getTier().equals(Tiers.IRON));
            }
            if (event.getEntity() instanceof WitherSkeleton) {
                //stone sword
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof SwordItem
                        && ((SwordItem) drop.getItem().getItem()).getTier().equals(Tiers.STONE));
            }
            if (event.getEntity() instanceof Zombie
                    || event.getEntity() instanceof Husk
                    || event.getEntity() instanceof ZombieVillager) {
                //iron shovel, iron sword, armor
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof SwordItem
                        && ((SwordItem) drop.getItem().getItem()).getTier().equals(Tiers.IRON));
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof ShovelItem
                        && ((SwordItem) drop.getItem().getItem()).getTier().equals(Tiers.IRON));
                event.getDrops().removeIf(drop -> drop.getItem().getItem() instanceof ArmorItem i
                        && !i.getMaterial().equals(ArmorMaterials.CHAIN));
            }
        }
    }
}