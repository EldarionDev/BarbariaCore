package barbaria.barbaria;

import barbaria.barbaria.client.core.ModKeys;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.server.FMLServerStoppingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Barbaria.MOD_ID)
public class Barbaria {
    public static final String MOD_ID = "barbaria";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Barbaria() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doDedicatedServerStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStart);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerAboutToStart);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStarted);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStopping);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Starting the Barbaria Mod.");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    /* Physical client */

    private void doClientStuff(final FMLClientSetupEvent event) {
        ModKeys.register();
    }

    /* Physical server */
    private void doDedicatedServerStuff(final FMLDedicatedServerSetupEvent event) {

    }

    /* Logical server */

    private void onServerStart(final FMLServerStartingEvent event) {
        /* Obtain reference to logical server */
    }

    private void onServerAboutToStart(final FMLServerAboutToStartEvent event) {
        /* Register structures */
    }

    private void onServerStarted(final FMLServerStartedEvent event) {
        /* Inject loottables and everything needed when ready to play */
    }

    private void onServerStopping(final FMLServerStoppingEvent event) {
        /* Call save tasks */
    }
}
