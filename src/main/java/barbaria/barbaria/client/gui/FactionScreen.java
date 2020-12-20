package barbaria.barbaria.client.gui;

import barbaria.barbaria.Barbaria;
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
    private static final ResourceLocation BACKGROUND = new ResourceLocation(Barbaria.MOD_ID, "textures/gui/faction_screen.png");

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
            this.minecraft.displayGuiScreen(null);
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
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
            switch (getButtonName((int) mouseX, (int) mouseY)) {
                case "":
                    return true;
                case "create_faction":
                    return true;
                case "join_faction":
                    return true;
                case "list_factions":
                    return true;
                case "done":
                    minecraft.displayGuiScreen(null);
                    return true;
            }
        }
        return false;
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

    private String getButtonName(int x, int y) {
        if (x < (this.width / 4) || x > ((this.width / 4) * 3)) {
            return "";
        }
        /* Check Done button */
        if ((y >= (this.height - 40) && y <= (this.height - 20))) {
            return "done";
        }
        /* Check List button*/
        if ((y >=  (this.height - 100) && y <= (this.height - 80))) {
            return "list_factions";
        }
        /* Check Create button*/
        if ((y >= (this.height - 140) && y <= (this.height - 120))) {
            return "create_faction";
        }

        /* Check Join button*/
        if ((y >= (this.height - 180) && y <= (this.height - 160))) {
            return "join_faction";
        }
        return "";
    }
}
