package armor.profiles.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class ArmorProfileScreen extends Screen {
    public ArmorProfileScreen() {
        super(Text.literal("fortnite battle pass"));
    }

    public ButtonWidget button1;
    public ButtonWidget button2;

    @Override
    protected void init() {
        button1 = ButtonWidget.builder(Text.literal("Button 1"), button -> {
            System.out.println("button 1");
        })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("Tooltip of button1")))
                .build();
        button2 = ButtonWidget.builder(Text.literal("Button 2"), button -> {
            System.out.println("button 2");
        })
                .dimensions(width / 2 + 5, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("Tooltip of button2")))
                .build();

        addDrawableChild(button1);
        addDrawableChild(button2);
    }

    // close screen
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        // Check if the key matches your keybind (GLFW.GLFW_KEY_O)
        if (keyCode == GLFW.GLFW_KEY_O) {
            this.close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    // tell screen not to pause game
    @Override
    public boolean shouldPause() {
        return false;
    }
}
