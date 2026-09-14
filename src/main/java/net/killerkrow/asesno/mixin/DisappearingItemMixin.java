package net.killerkrow.asesno.mixin;

import net.killerkrow.asesno.init.AsesinoItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class DisappearingItemMixin extends Entity {

    @Shadow public abstract ItemStack getStack();

    public DisappearingItemMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    private void injectCustomDespawn(CallbackInfo ci) {
        if (!this.getWorld().isClient()) {

            if (this.getStack().isOf(AsesinoItems.GARLIC_BREAD)) {
                if (this.age >= 300) {
                    this.discard();
                }
            }
            if (this.getStack().isOf(AsesinoItems.ROASTED_CHICKEN)) {
                if (this.age >= 300) {
                    this.discard();
                }
            }
            if (this.getStack().isOf(AsesinoItems.SHRIMP)) {
                if (this.age >= 300) {
                    this.discard();
                }
            }
            if (this.getStack().isOf(AsesinoItems.TORTILLA_CHIP)) {
                if (this.age >= 300) {
                    this.discard();
                }
            }
            if (this.getStack().isOf(AsesinoItems.SPAGHETTI_NOODLE)) {
                if (this.age >= 300) {
                    this.discard();
                }
            }
            if (this.getStack().isOf(AsesinoItems.MEATBALL)) {
                if (this.age >= 300) {
                    this.discard();
                }
            }
        }
    }
}