package me.ricky.notifs.systems;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.settings.Settings;
import meteordevelopment.meteorclient.systems.System;
import meteordevelopment.meteorclient.systems.Systems;
import net.minecraft.nbt.NbtCompound;

public class NotifsConfig extends System<NotifsConfig> {
    public final Settings settings = new Settings();

    public NotifsConfig() {
        super("Notifs");
    }

    public static NotifsConfig get() {
        return Systems.get(NotifsConfig.class);
    }

    @Override
    public NbtCompound toTag() {
        NbtCompound tag = new NbtCompound();

        tag.putString("version", MeteorClient.VERSION.toString());
        tag.put("settings", settings.toTag());

        return tag;
    }

    @Override
    public NotifsConfig fromTag(NbtCompound tag) {
        if (tag.contains("settings")) settings.fromTag(tag.getCompound("settings"));

        return this;
    }
}
