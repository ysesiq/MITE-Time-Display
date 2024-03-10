package net.xylose.mitemod.timedisplay.event;

import com.google.common.eventbus.Subscribe;
import net.minecraft.ChatMessage;
import net.minecraft.EnumChatFormat;
import net.xiaoyu233.fml.reload.event.PlayerLoggedInEvent;
import net.xylose.mitemod.timedisplay.config.TimeDisplayConfig;

public class TimeDisplayEventListener {
    @Subscribe
    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
        if (((Boolean) TimeDisplayConfig.Debug_Display_Time.get()).booleanValue()) {
            event.getPlayer().sendChatToPlayer(ChatMessage.createFromText("[Client]:").appendComponent(ChatMessage.createFromText("时间显示MOD已加载,请按F3显示时间").setColor(EnumChatFormat.valueOf("GOLD"))));
        } else {
            event.getPlayer().sendChatToPlayer(ChatMessage.createFromText("[Client]:").appendComponent(ChatMessage.createFromText("时间显示MOD已加载").setColor(EnumChatFormat.valueOf("GOLD"))));
        }
    }
}