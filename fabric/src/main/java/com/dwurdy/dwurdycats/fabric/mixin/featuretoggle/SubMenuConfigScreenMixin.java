package com.dwurdy.dwurdycats.fabric.mixin.featuretoggle;

import com.dwurdy.dwurdycats.Copycats;
import com.dwurdy.dwurdycats.config.CCConfigs;
import com.dwurdy.dwurdycats.utility.LogicalSidedProvider;
import com.dwurdy.dwurdycats.utility.Platform;
import com.dwurdy.dwurdycats.network.CCPackets;
import com.dwurdy.dwurdycats.network.ConfigSyncPacket;
import com.simibubi.create.foundation.config.ui.ConfigScreen;
import com.simibubi.create.foundation.config.ui.SubMenuConfigScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.config.ModConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Sync the config when the user saves changes in Create's GUI config screen.
 */
@Mixin(value = SubMenuConfigScreen.class, remap = false)
public class SubMenuConfigScreenMixin {
    @Inject(
            method = "saveChanges()V",
            at = @At("TAIL")
    )
    private void saveChangesAndRefresh(CallbackInfo ci) {
        if (ConfigScreen.modID.equals(Copycats.MODID)) {
            if (FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER || FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT && Minecraft.getInstance().hasSingleplayerServer())
                LogicalSidedProvider.WORKQUEUE.get(Platform.Environment.SERVER).submit(() -> CCPackets.PACKETS.sendTo(PlayerSelection.all(), new ConfigSyncPacket(CCConfigs.common().getSyncConfig(), ModConfig.Type.COMMON)));
        }
    }
}
