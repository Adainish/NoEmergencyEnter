package gg.oddysian.adenydd.noemergencyenter.events;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.BattleStartedEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;
import com.pixelmonmod.pixelmon.entities.pixelmon.abilities.EmergencyExit;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BattleListener {
    public BattleListener() {
        Pixelmon.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBattleStartEvent(BattleStartedEvent event) {

        BattleParticipant p1 = event.participant1[0];
        BattleParticipant p2 = event.participant2[0];

        for (PixelmonWrapper p:p1.allPokemon) {

            if (p == null)
                continue;

            if (p.pokemon.getAbility().isAbility(EmergencyExit.class)) {
                event.bc.endBattleWithoutXP();
                if (p.getPlayerOwner() != null)
                p.getPlayerOwner().sendMessage(new TextComponentString("Due to a bug with the Ability Emergency-Exit the battle was force ended to prevent a server crash"));
                p2.getEntity().sendMessage(new TextComponentString("Your opponent had a Pokemon with the bugged Ability Emergency Exit, the battle was forcefully ended"));
                break;
            }
        }

        for (PixelmonWrapper p:p2.allPokemon) {

            if (p == null)
                continue;

            if (p.pokemon.getAbility().isAbility(EmergencyExit.class)) {
                event.bc.endBattleWithoutXP();
                if (p.getPlayerOwner() != null)
                    p.getPlayerOwner().sendMessage(new TextComponentString("Due to a bug with the Ability Emergency-Exit the battle was force ended to prevent a server crash"));
                p1.getEntity().sendMessage(new TextComponentString("Your opponent had a Pokemon with the bugged Ability Emergency Exit, the battle was forcefully ended"));
                break;
            }
        }
    }
}
