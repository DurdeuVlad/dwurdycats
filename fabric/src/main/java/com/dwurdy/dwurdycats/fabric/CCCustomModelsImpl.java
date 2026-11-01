package com.dwurdy.dwurdycats.fabric;

import com.dwurdy.dwurdycats.content.copycat.fluid_pipe.fabric.CopycatFluidPipeModelFabric;
import com.dwurdy.dwurdycats.foundation.copycat.model.CopycatModelCore;
import net.minecraft.client.resources.model.BakedModel;

public class CCCustomModelsImpl {

    public static BakedModel getFluidPipeModel(BakedModel original, CopycatModelCore copycat, boolean disableAO) {
        return new CopycatFluidPipeModelFabric(original, copycat, disableAO);
    }
}
