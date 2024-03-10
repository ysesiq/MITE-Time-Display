package net.xylose.mitemod.timedisplay.mixins;

import net.minecraft.ChatMessage;
import net.minecraft.DedicatedServer;
import net.minecraft.EnumChatFormat;
import net.minecraft.ServerPlayer;
import net.xylose.mitemod.timedisplay.config.TimeDisplayConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DedicatedServer.class)
public class TimeDisplayDedicatedServerMixin {
    @Inject(method = "playerLoggedIn",at = @At("RETURN"))
    public void playerLoggedIn(ServerPlayer player, CallbackInfo callbackInfo) {
        if (((Boolean) TimeDisplayConfig.Debug_Display_Time.get()).booleanValue()) {
            player.sendChatToPlayer(ChatMessage.createFromText("[Server]:").appendComponent(ChatMessage.createFromText("时间显示MOD已加载,请按F3显示时间").setColor(EnumChatFormat.valueOf("GOLD"))));
        } else {
            player.sendChatToPlayer(ChatMessage.createFromText("[Server]:").appendComponent(ChatMessage.createFromText("时间显示MOD已加载").setColor(EnumChatFormat.valueOf("GOLD"))));
        }
    }

}
