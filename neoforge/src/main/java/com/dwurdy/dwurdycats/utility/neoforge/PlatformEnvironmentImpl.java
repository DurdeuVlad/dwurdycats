package com.dwurdy.dwurdycats.utility.neoforge;

import com.dwurdy.dwurdycats.utility.Platform;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

public class PlatformEnvironmentImpl {

    public static Platform.Environment getCurrent() {
        return FMLEnvironment.dist == Dist.CLIENT ? Platform.Environment.CLIENT : Platform.Environment.SERVER;
    }
}
