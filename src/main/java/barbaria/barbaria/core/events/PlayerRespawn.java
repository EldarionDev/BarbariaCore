package barbaria.barbaria.core.events;

import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerRespawn {
    @SubscribeEvent
    public void onPlayerRespawn(final PlayerEvent.PlayerRespawnEvent event) {
        event.getPlayer().sendMessage(new StringTextComponent("You have been respawned."));
    }
}
