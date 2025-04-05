package me.ricky.notifs.systems;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.System;
import meteordevelopment.meteorclient.systems.Systems;
import net.minecraft.nbt.NbtCompound;

public class NotifsConfig extends System<NotifsConfig> {
    public final Settings settings = new Settings();

    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    public final Setting<NotifMode> infoMode = sgGeneral.add(new EnumSetting.Builder<NotifMode>()
        .name("infos")
        .description("How to display info notifications.")
        .defaultValue(NotifMode.Hud)
        .build()
    );

    public final Setting<NotifMode> warningMode = sgGeneral.add(new EnumSetting.Builder<NotifMode>()
        .name("warnings")
        .description("How to display warning notifications.")
        .defaultValue(NotifMode.Hud)
        .build()
    );

    public final Setting<NotifMode> errorMode = sgGeneral.add(new EnumSetting.Builder<NotifMode>()
        .name("errors")
        .description("How to display error notifications.")
        .defaultValue(NotifMode.Hud)
        .build()
    );

    public final Setting<Boolean> keepInChat = sgGeneral.add(new BoolSetting.Builder()
        .name("keep-in-chat")
        .description("Display notifications in the chat as well.")
        .defaultValue(true)
        .build()
    );

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

    public enum NotifMode {
        Both,
        Chat,
        Hud,
        None;

        public boolean hud() {
            return this == Hud || this == Both;
        }

        public boolean chat() {
            return this == Chat || this == Both;
        }
    }
}
