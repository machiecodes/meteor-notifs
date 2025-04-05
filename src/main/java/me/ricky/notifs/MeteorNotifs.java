package me.ricky.notifs;

import me.ricky.notifs.hud.HudExample;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import org.slf4j.Logger;

public class MeteorNotifs extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final HudGroup HUD_GROUP = new HudGroup("Meteor Notifs");

    @Override
    public void onInitialize() {
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
