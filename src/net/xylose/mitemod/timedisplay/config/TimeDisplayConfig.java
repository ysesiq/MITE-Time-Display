package net.xylose.mitemod.timedisplay.config;

import net.xiaoyu233.fml.config.ConfigCategory;
import net.xiaoyu233.fml.config.ConfigEntry;
import net.xiaoyu233.fml.util.FieldReference;

public class TimeDisplayConfig {
    public static final FieldReference<Boolean> Debug_Display_Time = new FieldReference(true);
    public static final FieldReference<Boolean> Time_Coordinate = new FieldReference(false);

    public static final ConfigCategory ROOT = ConfigCategory.of("MITETimeDisplay")
            .addEntry(ConfigEntry.of("debug_display_time", Debug_Display_Time).withComment("[如果同时开启,此项优先]按下F3显示时间,关闭则始终显示"))
            .addEntry(ConfigEntry.of("time_coordinate", Time_Coordinate).withComment("时间显示坐标器,关闭上一项替换时间显示(始终显示)"));

}
