package com.dwurdy.dwurdycats;

import com.dwurdy.dwurdycats.foundation.copycat.model.kinetic.KineticCopycatRenderer;
import com.dwurdy.dwurdycats.utility.LogicalSidedProvider;
import com.dwurdy.dwurdycats.network.CCPackets;
import net.createmod.catnip.render.SuperByteBufferCache;
import net.minecraft.client.Minecraft;

public class CopycatsClient {

    public static final SuperByteBufferCache BUFFER_CACHE = new SuperByteBufferCache();

    public static void init() {
        LogicalSidedProvider.setClient(Minecraft::getInstance);
        CCKeys.register();
        BUFFER_CACHE.registerCompartment(KineticCopycatRenderer.KINETIC_COPYCAT, 60);

    }

    public static void invalidateCaches() {
        BUFFER_CACHE.invalidate();
    }
}
