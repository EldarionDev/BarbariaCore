package barbaria.barbaria.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FactionScreen extends Screen {
    private static final ResourceLocation BACKGROUND = new ResourceLocation("barbaria", "textures/gui/faction_screen.png");

    public FactionScreen() {
        super(new StringTextComponent("Faction Screen"));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        RenderSystem.disableLighting();
        RenderSystem.disableDepthTest();
        this.renderBackground();
        RenderSystem.enableLighting();
        RenderSystem.enableDepthTest();
    }
}
