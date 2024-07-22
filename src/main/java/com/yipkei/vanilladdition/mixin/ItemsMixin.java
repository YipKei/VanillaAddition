package com.yipkei.vanilladdition.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Deprecated
@Mixin(Items.class)
public class ItemsMixin {

    @ModifyExpressionValue(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Items;register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;"))
    private static Item changeRegister(Item original){
        String path = Registries.ITEM.getId(original).getPath();
        boolean isDisc = path.contains("disc");
        return isDisc ? Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.ofVanilla(path)),new Item(new Item.Settings().maxDamage(2).rarity(Rarity.RARE).jukeboxPlayable(JukeboxSongs.THIRTEEN))) : original;
    }
}
