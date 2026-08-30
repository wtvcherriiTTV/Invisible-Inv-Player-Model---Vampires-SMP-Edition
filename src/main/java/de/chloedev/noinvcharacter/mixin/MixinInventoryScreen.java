package de.chloedev.noinvcharacter.mixin;

import de.chloedev.noinvcharacter.NoInvCharacterConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class MixinInventoryScreen {

    private static boolean wasInvisible = false;

    @Inject(method = "drawEntity", at = @At("HEAD"))
    private static void onDrawEntityHead(CallbackInfo ci) {
        if (!NoInvCharacterConfig.showPaperdoll) {
            PlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null) {
                wasInvisible = player.isInvisible();
                player.setInvisible(true);
            }
        }
    }

    @Inject(method = "drawEntity", at = @At("RETURN"))
    private static void onDrawEntityReturn(CallbackInfo ci) {
        if (!NoInvCharacterConfig.showPaperdoll) {
            PlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null) {
                player.setInvisible(wasInvisible);
            }
        }
    }
}
