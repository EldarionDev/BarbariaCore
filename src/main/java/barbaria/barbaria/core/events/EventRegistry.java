package barbaria.barbaria.core.events;

import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {
    public EventRegistry() {
        playerLoggedInEvent = new PlayerLoggedIn();
        playerLoggedOutEvent = new PlayerLoggedOut();
        playerRespawnEvent = new PlayerRespawn();
        serverTickEvent = new ServerTick();
        worldUnloadEvent = new WorldUnload();
        MinecraftForge.EVENT_BUS.register(playerLoggedInEvent);
        MinecraftForge.EVENT_BUS.register(playerLoggedOutEvent);
        MinecraftForge.EVENT_BUS.register(playerRespawnEvent);
        MinecraftForge.EVENT_BUS.register(serverTickEvent);
        MinecraftForge.EVENT_BUS.register(worldUnloadEvent);
    }

    private static PlayerLoggedIn   playerLoggedInEvent;
    private static PlayerLoggedOut   playerLoggedOutEvent;
    private static PlayerRespawn    playerRespawnEvent;
    private static ServerTick   serverTickEvent;
    private static WorldUnload  worldUnloadEvent;
}
