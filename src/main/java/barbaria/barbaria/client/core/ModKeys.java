package barbaria.barbaria.client.core;

import barbaria.barbaria.client.gui.FactionScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;


@OnlyIn(Dist.CLIENT)
public class ModKeys {
    private static final String CATEGORY = "keys.barbaria.category";
    private static final String OPEN_FACTION_MENU = "keys.barbaria.open_faction_menu";

    private static final KeyBinding FACTION_MENU_KEY = new KeyBinding(OPEN_FACTION_MENU, KeyConflictContext.IN_GAME,
            InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_V, CATEGORY);

    public static void register() {
        MinecraftForge.EVENT_BUS.register(new ModKeys());
        ClientRegistry.registerKeyBinding(FACTION_MENU_KEY);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent event) {
        if (FACTION_MENU_KEY.isKeyDown()) {
            Minecraft.getInstance().displayGuiScreen(new FactionScreen());
        }
    }
}
