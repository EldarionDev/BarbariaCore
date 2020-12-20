package barbaria.barbaria.client.gui;

import barbaria.barbaria.Barbaria;
import barbaria.barbaria.client.gui.faction.factionless.CreateFactionScreen;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftGame;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class FactionScreen extends Screen {

    public FactionScreen() {
        super(new TranslationTextComponent("screen.barbaria.faction"));
        this.width = Minecraft.getInstance().getFramebuffer().framebufferWidth;
        this.height =  Minecraft.getInstance().getFramebuffer().framebufferHeight;
    }

    @Override
    public void init() {
        /* Join a faction button */
        this.addButton(new Button(this.width / 4, this.height - 180, this.width / 2, 20, new TranslationTextComponent("gui.barbaria.join_faction_button").getUnformattedComponentText(), (context) -> {
            this.minecraft.displayGuiScreen(null);
        }));

        /* Create a faction button */
        this.addButton(new Button(this.width / 4, this.height - 140, this.width / 2, 20, new TranslationTextComponent("gui.barbaria.create_faction_button").getUnformattedComponentText(), (context) -> {
            minecraft.displayGuiScreen(null);
            minecraft.displayGuiScreen(new CreateFactionScreen());
        }));

        /* List all factions button */
        this.addButton(new Button(this.width / 4, this.height - 100, this.width / 2, 20, new TranslationTextComponent("gui.barbaria.list_factions_button").getUnformattedComponentText(), (context) -> {
            this.minecraft.displayGuiScreen(null);
        }));

        /* Done button */
        this.addButton(new Button(this.width / 4, this.height - 40, this.width / 2, 20, new TranslationTextComponent("gui.barbaria.done_button").getUnformattedComponentText(), (context) -> {
            this.minecraft.displayGuiScreen(null);
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void tick() {
        if (!this.minecraft.player.isAlive()) {
            this.minecraft.player.closeScreen();
        }
    }
}
