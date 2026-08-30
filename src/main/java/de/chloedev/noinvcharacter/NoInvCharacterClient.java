package de.chloedev.noinvcharacter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class NoInvCharacterClient implements ClientModInitializer {
    public static KeyBinding togglePaperdollKey;

    @Override
    public void onInitializeClient() {
        NoInvCharacterConfig.load();

        togglePaperdollKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.noinvcharacter.toggle", 
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P, 
                KeyBinding.Category.create(Identifier.of("noinvcharacter", "keys"))
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (togglePaperdollKey.wasPressed()) {
                NoInvCharacterConfig.showPaperdoll = !NoInvCharacterConfig.showPaperdoll;
                NoInvCharacterConfig.save();
                
                if (client.player != null) {
                    String status = NoInvCharacterConfig.showPaperdoll ? "ON" : "OFF";
                    client.player.sendMessage(Text.literal("Inventory Paperdoll: " + status), true);
                }
            }
        });
    }
}