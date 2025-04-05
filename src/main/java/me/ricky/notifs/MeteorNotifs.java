package me.ricky.notifs;

import com.mojang.logging.LogUtils;
import me.ricky.notifs.hud.HudExample;
import me.ricky.notifs.systems.NotifsConfig;
import me.ricky.notifs.systems.NotifsTab;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.gui.tabs.Tabs;
import meteordevelopment.meteorclient.systems.Systems;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import org.slf4j.Logger;

public class MeteorNotifs extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final HudGroup HUD_GROUP = new HudGroup("Meteor Notifs");

    @Override
    public void onInitialize() {
        // Init config
        Systems.add(new NotifsConfig());
        Tabs.add(new NotifsTab());

        // HUD
        Hud.get().register(HudExample.INFO);
    }

    @Override
    public String getPackage() {
        return "me.ricky.notifs";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("machiecodes", "meteor-notifs", "main", null);
    }
}
