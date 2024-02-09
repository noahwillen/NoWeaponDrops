package net.noah.noweapondrops;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod(NoWeaponDrops.MOD_ID)
public class NoWeaponDrops {

    public static final String MOD_ID = "noweapondrops";
    public NoWeaponDrops () {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
