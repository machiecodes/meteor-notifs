package me.ricky.notifs.hud;

import me.ricky.notifs.MeteorNotifs;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;

public class NotifsHud extends HudElement {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public static final HudElementInfo<NotifsHud> INFO = new HudElementInfo<>(
        MeteorNotifs.HUD_GROUP, "notifs-hud", "Displays notifications in the HUD.", NotifsHud::new
    );

    public NotifsHud() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        setSize(renderer.textWidth("Example element", true), renderer.textHeight(true));

        // Render background
        renderer.quad(x, y, getWidth(), getHeight(), Color.LIGHT_GRAY);

        // Render text
        renderer.text("Example element", x, y, Color.WHITE, true);
    }
}
