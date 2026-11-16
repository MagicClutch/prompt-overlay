package net.dungeonhub.promptoverlay.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(targets = "com.teamresourceful.resourcefulconfig.client.components.options.types.DropdownWidget$DropdownItem")
public class ResourcefulConfigDropdownItemPatch {
    @ModifyArg(
            method = "extractWidgetRenderState",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/ActiveTextCollector;acceptScrollingWithDefaultCenter(Lnet/minecraft/network/chat/Component;IIII)V"),
            index = 2
    )
    private int fixTextArea(int maxX) {
        return maxX + 12;
    }
}
