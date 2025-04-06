package me.ricky.notifs.notifications;

import it.unimi.dsi.fastutil.Pair;
import me.ricky.notifs.systems.NotifsConfig;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.systems.Systems;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.PostInit;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.orbit.EventHandler;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifsManager {
    private static final List<Notification> notifications = new ArrayList<>();
    private static boolean playedSoundThisTick;
    private static NotifsConfig config;

    private static final Map<String, Identifier> icons = new HashMap<>();
    private static final Map<String, Color> colors = new HashMap<>();

    @PostInit
    public static void init() {
        MeteorClient.EVENT_BUS.subscribe(NotifsManager.class);
        config = Systems.get(NotifsConfig.class);
    }

    /* Getting Mod Icons/Colors */

    private static Pair<Color, Identifier> getModResources(Class<? extends Module> clazz) {
        return null;
    }

    /* Creating/Updating Notifications */

    public static boolean createNotif(String title, String message, Setting<NotifsConfig.NotifMode> setting, Class<?> clazz) {
        return false;
    }

    /* Playing Sounds */

    public static void tryPlaySound(Setting<NotifsConfig.NotifMode> setting) {
        if (playedSoundThisTick || !config.playSound.get() || setting.get() == NotifsConfig.NotifMode.None) return;

        MeteorClient.mc.player.playSound(
            config.sound.get().sound,
            config.soundVolume.get() * 0.01f,
            config.soundPitch.get().floatValue()
        );

        playedSoundThisTick = true;
    }

    @EventHandler
    private static void onTick(TickEvent.Pre event) {
        playedSoundThisTick = false;
    }
}
