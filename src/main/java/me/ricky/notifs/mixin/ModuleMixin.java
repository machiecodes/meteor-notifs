package me.ricky.notifs.mixin;

import me.ricky.notifs.systems.NotifsConfig;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Module;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Module.class, remap = false)
public class ModuleMixin {
    @Final
    @Shadow public MeteorAddon addon;

    @Inject(method = "sendToggledMsg", at = @At("HEAD"), cancellable = true)
    private void redirectChatNotif(CallbackInfo ci) {
        if (NotifsConfig.get().infoMode.get().hud()) {

        }

        if (!NotifsConfig.get().infoMode.get().chat()) ci.cancel();
    }

    @Inject(method = "info(Lnet/minecraft/text/Text;)V", at = @At("HEAD"), cancellable = true)
    private void redirectTextInfo(Text message, CallbackInfo ci) {
        if (NotifsConfig.get().infoMode.get().hud()) {

        }

        if (!NotifsConfig.get().infoMode.get().chat()) ci.cancel();
    }

    @Inject(method = "info(Ljava/lang/String;[Ljava/lang/Object;)V", at = @At("HEAD"), cancellable = true)
    private void redirectStringInfo(String message, Object[] args, CallbackInfo ci) {
        if (NotifsConfig.get().infoMode.get().hud()) {

        }

        if (!NotifsConfig.get().infoMode.get().chat()) ci.cancel();
    }

    @Inject(method = "warning", at = @At("HEAD"), cancellable = true)
    private void redirectWarning(String message, Object[] args, CallbackInfo ci) {
        if (NotifsConfig.get().warningMode.get().hud()) {

        }

        if (!NotifsConfig.get().warningMode.get().chat()) ci.cancel();
    }

    @Inject(method = "error", at = @At("HEAD"), cancellable = true)
    private void redirectError(String message, Object[] args, CallbackInfo ci) {
        if (NotifsConfig.get().errorMode.get().hud()) {

        }

        if (!NotifsConfig.get().errorMode.get().chat()) ci.cancel();
    }
}
