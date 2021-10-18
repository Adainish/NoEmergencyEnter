package gg.oddysian.adenydd.noemergencyenter;

import gg.oddysian.adenydd.noemergencyenter.events.BattleListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = NoEmergencyEnter.MOD_ID,
        name = NoEmergencyEnter.MOD_NAME,
        version = NoEmergencyEnter.VERSION,
        acceptableRemoteVersions = "*"
)
public class NoEmergencyEnter {

    public static final String MOD_ID = "noemergencyenter";
    public static final String MOD_NAME = "NoEmergencyEnter";
    public static final String VERSION = "1.0-SNAPSHOT";

    public static BattleListener listener;
    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static NoEmergencyEnter INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

        listener = new BattleListener();
    }

}
