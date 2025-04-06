package me.ricky.notifs.notifications;

import meteordevelopment.meteorclient.utils.render.color.Color;
import net.minecraft.util.Identifier;

public class Notification {
    private final String title;
    private final String message;
    private final Identifier icon;
    private final Color color;

    private final float creationTime;

    protected Notification(String title, String message, Identifier icon, Color color) {
        this.title = title;
        this.message = message;
        this.icon = icon;
        this.color = color;

        creationTime = System.currentTimeMillis();
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Identifier getIcon() {
        return icon;
    }

    public Color getColor() {
        return color;
    }

    public float getCreationTime() {
        return creationTime;
    }
}
