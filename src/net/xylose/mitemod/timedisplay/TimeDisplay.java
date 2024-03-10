package net.xylose.mitemod.timedisplay;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.xiaoyu233.fml.AbstractMod;
import net.xiaoyu233.fml.classloading.Mod;
import net.xiaoyu233.fml.config.ConfigRegistry;
import net.xiaoyu233.fml.config.InjectionConfig;
import net.xiaoyu233.fml.reload.event.MITEEvents;
import net.xylose.mitemod.timedisplay.config.TimeDisplayConfig;
import net.xylose.mitemod.timedisplay.event.TimeDisplayEventListener;
import net.xylose.mitemod.timedisplay.mixins.TimeDisplayMixinMarker;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.io.File;

@Mod({MixinEnvironment.Side.CLIENT})
public class TimeDisplay extends AbstractMod {

    private static final ConfigRegistry CONFIG_REGISTRY = new ConfigRegistry(TimeDisplayConfig.ROOT, new File("mite-time-display.json"));

    public void preInit() {
    }

    @Nonnull
    public InjectionConfig getInjectionConfig() {
        return InjectionConfig.Builder.of("MITETimeDisplay", TimeDisplayMixinMarker.class.getPackage(), MixinEnvironment.Phase.INIT).setRequired().build();
    }

    public void postInit() {
        MITEEvents.MITE_EVENT_BUS.register(new TimeDisplayEventListener());
    }

    @Nullable
    public ConfigRegistry getConfigRegistry() {
        return CONFIG_REGISTRY;
    }

    public String modId() {
        return "TimeDisplay";
    }

    public int modVerNum() {
        return 120;
    }

    public String modVerStr() {
        return "v1.2.0";
    }
}
