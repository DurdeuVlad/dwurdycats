package com.dwurdy.dwurdycats.content.copycat.flat_pane;

import com.dwurdy.dwurdycats.foundation.copycat.model.CopycatModelCore;
import com.dwurdy.dwurdycats.foundation.copycat.model.assembly.AssemblyTransform;
import com.dwurdy.dwurdycats.foundation.copycat.model.assembly.CopycatRenderContext;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.state.BlockState;

import static com.dwurdy.dwurdycats.content.copycat.flat_pane.CopycatFlatPaneBlock.AXIS;
import static com.dwurdy.dwurdycats.foundation.copycat.model.assembly.CopycatRenderContext.*;
import static com.dwurdy.dwurdycats.foundation.copycat.model.assembly.MutableCullFace.DOWN;
import static com.dwurdy.dwurdycats.foundation.copycat.model.assembly.MutableCullFace.UP;

public class CopycatFlatPaneModelCore extends CopycatModelCore {

    @Override
    public void emitCopycatQuads(String key, BlockState state, CopycatRenderContext context, BlockState material) {
        Axis axis = state.getValue(AXIS);
        int xRot = axis == Axis.Z ? 90 : 0;
        int zRot = axis == Axis.X ? 90 : 0;
        AssemblyTransform transform = t -> t.rotateX(xRot).rotateZ(zRot);
        context.assemblePiece(transform,
                vec3(0, 7, 0),
                aabb(16, 1, 16),
                cull(UP));
        context.assemblePiece(transform,
                vec3(0, 8, 0),
                aabb(16, 1, 16),
                cull(DOWN));
    }
}
