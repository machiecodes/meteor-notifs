package me.ricky.notifs.mixin;

import meteordevelopment.meteorclient.systems.modules.Module;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Module.class, remap = false)
public abstract class ModuleMixin {
    @Inject(method = "sendToggledMsg", at = @At("HEAD"), cancellable = true)
    private void redirectToggledMsg(CallbackInfo ci) {

    }

    @Inject(method = "info(Lnet/minecraft/text/Text;)V", at = @At("HEAD"), cancellable = true)
    private void redirectTextInfo(Text message, CallbackInfo ci) {

    }

    @Inject(method = "info(Ljava/lang/String;[Ljava/lang/Object;)V", at = @At("HEAD"), cancellable = true)
    private void redirectStringInfo(String message, Object[] args, CallbackInfo ci) {

    }

    @Inject(method = "warning", at = @At("HEAD"), cancellable = true)
    private void redirectWarning(String message, Object[] args, CallbackInfo ci) {

    }

    @Inject(method = "error", at = @At("HEAD"), cancellable = true)
    private void redirectError(String message, Object[] args, CallbackInfo ci) {

    }
}
