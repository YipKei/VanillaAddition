package com.yipkei.vanilladdition.util;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class Head {
    public final String name;
    public final UUID uuid;
    public final String value;
    @Nullable
    public final String tags;



    public Head(@Nullable String name, UUID uuid, String value, @Nullable String tags) {
        this.name = name;
        this.uuid = uuid;
        this.value = value;
        this.tags = tags;
    }

    public Head(UUID uuid, String value) {
        this.name = "";
        this.uuid = uuid;
        this.value = value;
        this.tags = null;
    }

    public String getTagsOrEmpty() {
        return tags == null ? "" : tags;
    }

    public ItemStack createStack(Text displayName) {
        ItemStack stack = new ItemStack(Items.PLAYER_HEAD);
        if (displayName != null) {
            stack.set(DataComponentTypes.CUSTOM_NAME, displayName);
        }

        if (tags != null) {
            stack.set(DataComponentTypes.LORE, new LoreComponent(List.of(Text.literal(tags))));
        }

        var profile = new GameProfile(uuid, "");
        profile.getProperties().put("textures", new Property("textures", value));
        stack.set(DataComponentTypes.PROFILE, new ProfileComponent(profile));

        return stack;
    }

    public ItemStack createStack() {
        return createStack(name != null ? Text.literal(name).setStyle(Style.EMPTY.withItalic(false)) : null);
    }


}
