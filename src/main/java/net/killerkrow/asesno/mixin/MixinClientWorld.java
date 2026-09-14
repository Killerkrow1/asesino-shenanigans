package net.killerkrow.asesno.mixin;

import net.killerkrow.asesno.AsesinoShenanigansClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientWorld.class)
public class MixinClientWorld {

    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void overrideSkyColor(Vec3d cameraPos, float tickDelta, CallbackInfoReturnable<Vec3d> cir) {
        if (AsesinoShenanigansClient.clientIsFoodWeatherActive) {
            // Vec3d color
            cir.setReturnValue(new Vec3d(0.361D, 0.039D, 0.039D));
        }
    }
}