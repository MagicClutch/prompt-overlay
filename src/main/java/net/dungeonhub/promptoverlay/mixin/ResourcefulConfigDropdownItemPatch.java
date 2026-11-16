package net.dungeonhub.promptoverlay.mixin;

import net.minecraft.client.gui.components.AbstractWidget;
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
        AbstractWidget self = (AbstractWidget) (Object) this;
        return self.getX() + self.getWidth() - 4;
    }
}
