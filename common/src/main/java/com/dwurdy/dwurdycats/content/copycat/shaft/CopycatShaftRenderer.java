package com.dwurdy.dwurdycats.content.copycat.shaft;

import com.dwurdy.dwurdycats.CCCopycatPartialModels;
import com.dwurdy.dwurdycats.foundation.copycat.ICopycatBlockEntity;
import com.dwurdy.dwurdycats.foundation.copycat.model.kinetic.IKineticCopycatBlockRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;

public class CopycatShaftRenderer extends BracketedKineticBlockEntityRenderer implements IKineticCopycatBlockRenderer {
    public CopycatShaftRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(BracketedKineticBlockEntity be, BlockState state) {
        return IKineticCopycatBlockRenderer.super.getRotatedModel(CCCopycatPartialModels.SHAFT, (ICopycatBlockEntity) be);
    }
}
