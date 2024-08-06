package com.yipkei.vanilladdition.mixin;

import com.yipkei.vanilladdition.handler.SmithingRemainderHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.SmithingScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(SmithingScreenHandler.class)
public class SmithingScreenHandlerMixin {

    /**
     * 该方法为对合成原料槽执行物品消耗的方法
     * <p>在判断前，先捕获传入物品槽的物品栈，计算返还物并临时储存
     * @param slot：物品插槽标记，用不到
     * @param ci：返回值，用不到
     * @param itemStack：捕获对象
     */
    @Inject(method = "decrementStack", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isEmpty()Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureStack(int slot, CallbackInfo ci, ItemStack itemStack){
        SmithingRemainderHandler.REMAINDER_STACK.set(itemStack.getRecipeRemainder());
    }

    /**
     * 在最后执行物品槽修改时，如果设置目标为空物品槽，则设置为先前储存的返还物，否则不变
     * */
    @ModifyArg(method = "decrementStack", at = @At(value = "INVOKE", target = "Lnet/minecraft/inventory/Inventory;setStack(ILnet/minecraft/item/ItemStack;)V"), index = 1)
    private ItemStack replaceRemainder(ItemStack stack){
        ItemStack remainder = SmithingRemainderHandler.REMAINDER_STACK.get();
        SmithingRemainderHandler.REMAINDER_STACK.remove();
        return stack.isOf(Items.AIR) ? remainder : stack;
    }
}
