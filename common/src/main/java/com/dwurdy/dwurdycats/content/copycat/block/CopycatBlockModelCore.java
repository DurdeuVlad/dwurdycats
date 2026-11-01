package com.dwurdy.dwurdycats.content.copycat.block;

import com.dwurdy.dwurdycats.foundation.copycat.model.CopycatModelCore;
import com.dwurdy.dwurdycats.foundation.copycat.model.assembly.CopycatRenderContext;
import net.minecraft.world.level.block.state.BlockState;

public class CopycatBlockModelCore extends CopycatModelCore {

    @Override
    public void emitCopycatQuads(String key, BlockState state, CopycatRenderContext context, BlockState material) {
        context.assembleAll(); // assemble without any modifications
    }
}
