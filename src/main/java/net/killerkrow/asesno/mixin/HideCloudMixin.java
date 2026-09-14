package net.killerkrow.asesno.mixin;

import net.killerkrow.asesno.AsesinoShenanigansClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class HideCloudMixin {
    @Inject(
            method = "renderClouds(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;FDDD)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onRenderClouds(MatrixStack matrices, Matrix4f projectionMatrix,
                                float tickDelta, double cameraX, double cameraY, double cameraZ, CallbackInfo info) {
        if (AsesinoShenanigansClient.clientIsFoodWeatherActive) {
            info.cancel();
        }
    }
}
