package barbaria.barbaria.client.gui.faction.factionless;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;

public class CreateFactionScreen extends Screen {
    private TextFieldWidget nameField;

    public CreateFactionScreen(){
        super(new TranslationTextComponent("screen.barbaria.create_faction"));
        this.width = Minecraft.getInstance().getFramebuffer().framebufferWidth;
        this.height =  Minecraft.getInstance().getFramebuffer().framebufferHeight;
    }

    @Override
    public void init() {
        super.init();

        /* Text entry field for faction name */
        this.nameField = new TextFieldWidget(this.font, this.width / 4, this.height - (this.height - 50), this.width / 2, 20, "name_faction");
        this.nameField.setTextColor(200);
        this.nameField.setEnableBackgroundDrawing(true);
        this.nameField.setMaxStringLength(30);
        this.nameField.setText("Name your faction");
        this.children.add(nameField);
        this.setFocused(nameField);

        /* Confirmation button */
        this.addButton(new Button(this.width / 4, this.height - (this.height - 80), this.width / 4 - 5, 20, new TranslationTextComponent("gui.barbaria.done_button").getUnformattedComponentText(), (context) -> {
            this.minecraft.displayGuiScreen(null);
        }));

        /* Cancel button */
        this.addButton(new Button(this.width / 2 + 5, this.height - (this.height - 80), this.width / 4 - 5, 20, new TranslationTextComponent("gui.barbaria.cancel_button").getUnformattedComponentText(), (context) -> {
            this.minecraft.displayGuiScreen(null);
        }));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.nameField.render(mouseX, mouseY, partialTicks);
        super.render(mouseX, mouseY, partialTicks);
    }

    @Override
    public void tick() {
        nameField.tick();
    }
}
