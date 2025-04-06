package me.ricky.notifs.systems;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.System;
import meteordevelopment.meteorclient.systems.Systems;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class NotifsConfig extends System<NotifsConfig> {
    public final Settings settings = new Settings();

    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final SettingGroup sgColors = settings.createGroup("Colors");
    private final SettingGroup sgSound = settings.createGroup("Sound");


    public final Setting<Integer> maxNotifs = sgGeneral.add(new IntSetting.Builder()
        .name("max-notifs")
        .description("How many notifications can be displayed at one time.")
        .defaultValue(4)
        .range(1,6)
        .build()
    );

    public final Setting<Integer> displayTime = sgGeneral.add(new IntSetting.Builder()
        .name("display-time")
        .description("How long (in ticks) a notification should be displayed before disappearing.")
        .defaultValue(6)
        .range(1, 100)
        .build()
    );

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



    // Colors

    public final Setting<SettingColor> toggleOnColor = sgColors.add(new ColorSetting.Builder()
        .name("toggle-on-color")
        .description("What color to use for toggle on notifications.")
        .defaultValue(Color.GREEN)
        .build()
    );

    public final Setting<SettingColor> toggleOffColor = sgColors.add(new ColorSetting.Builder()
        .name("toggle-off-color")
        .description("What color to use for toggle off notifications.")
        .defaultValue(Color.BLUE)
        .build()
    );

    public final Setting<SettingColor> infoColor = sgColors.add(new ColorSetting.Builder()
        .name("info-color")
        .description("What color to use for toggle on notifications.")
        .defaultValue(Color.LIGHT_GRAY)
        .build()
    );

    public final Setting<SettingColor> warningColor = sgColors.add(new ColorSetting.Builder()
        .name("warning-color")
        .description("What color to use for toggle on notifications.")
        .defaultValue(Color.ORANGE)
        .build()
    );

    public final Setting<SettingColor> errorColor = sgColors.add(new ColorSetting.Builder()
        .name("error-color")
        .description("What color to use for toggle on notifications.")
        .defaultValue(Color.RED)
        .build()
    );

    // Sound

    public final Setting<Boolean> playSound = sgSound.add(new BoolSetting.Builder()
        .name("play-sound")
        .description("Play a ding noise when displaying a notification.")
        .defaultValue(true)
        .build()
    );

    public final Setting<Sound> sound = sgSound.add(new EnumSetting.Builder<Sound>()
        .name("sound")
        .description("The sound to play for notifications.")
        .defaultValue(Sound.Experience)
        .visible(playSound::get)
        .build()
    );

    public final Setting<Integer> soundVolume = sgSound.add(new IntSetting.Builder()
        .name("volume")
        .description("How loud the sound should be.")
        .defaultValue(50)
        .range(0,100)
        .sliderRange(0,100)
        .visible(playSound::get)
        .build()
    );

    public final Setting<Double> soundPitch = sgSound.add(new DoubleSetting.Builder()
        .name("pitch")
        .description("The pitch of the sound.")
        .defaultValue(1.0)
        .range(0.1, 2.0)
        .sliderRange(0.1, 2.0)
        .visible(playSound::get)
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

    public enum Sound {
        Experience(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP),
        EnderEye(SoundEvents.ENTITY_ENDER_EYE_DEATH),
        Chicken(SoundEvents.ENTITY_CHICKEN_EGG);

        public final SoundEvent sound;

        Sound(SoundEvent sound) {
            this.sound = sound;
        }
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
