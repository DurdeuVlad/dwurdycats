package com.dwurdy.dwurdycats.fabric.mixin.compat.moreculling;

import com.dwurdy.dwurdycats.Copycats;
import com.dwurdy.dwurdycats.compat.Mods;
import com.dwurdy.dwurdycats.foundation.annotation.ModMixin;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Disable MoreCulling for copycat blocks to avoid overzealous culling.
 */
@ModMixin(requiredMods = Mods.MORE_CULLING)
@Mixin(targets = {"ca.fxco.moreculling.config.MoreCullingConfig"})
@Pseudo
public class MoreCullingConfigMixin {

    @Shadow
    public Object2BooleanOpenHashMap<String> modCompatibility;

    @Inject(
            method = "<init>",
            at = @At("RETURN"),
            require = 0
    )
    private void onInit(CallbackInfo ci) {
        modCompatibility.put(Copycats.MODID, false);
    }
}
