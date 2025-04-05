package me.ricky.notifs.systems;

import meteordevelopment.meteorclient.gui.GuiTheme;
import meteordevelopment.meteorclient.gui.tabs.Tab;
import meteordevelopment.meteorclient.gui.tabs.TabScreen;
import meteordevelopment.meteorclient.gui.tabs.WindowTabScreen;
import meteordevelopment.meteorclient.settings.Settings;
import meteordevelopment.meteorclient.utils.misc.NbtUtils;
import net.minecraft.client.gui.screen.Screen;

public class NotifsTab extends Tab {
    public NotifsTab() {
        super("Notifs");
    }

    @Override
    public TabScreen createScreen(GuiTheme theme) {
        return new NotifsScreen(theme, this);
    }

    @Override
    public boolean isScreen(Screen screen) {
        return screen instanceof NotifsScreen;
    }

    private static class NotifsScreen extends WindowTabScreen {
        private final Settings settings;

        public NotifsScreen(GuiTheme theme, Tab tab) {
            super(theme, tab);
            settings = NotifsConfig.get().settings;
            settings.onActivated();
        }

        @Override
        public void initWidgets() {
            add(theme.settings(settings)).expandX();
        }

        @Override
        public void tick() {
            super.tick();
            settings.tick(window, theme);
        }

        @Override
        public boolean toClipboard() {
            return NbtUtils.toClipboard(NotifsConfig.get());
        }

        @Override
        public boolean fromClipboard() {
            return NbtUtils.fromClipboard(NotifsConfig.get());
        }
    }
}
