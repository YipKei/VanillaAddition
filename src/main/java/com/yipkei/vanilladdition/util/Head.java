package com.yipkei.vanilladdition.util;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.ProfileResult;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ProfileComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Identifier;
import net.minecraft.util.UserCache;


import java.util.Optional;
import java.util.UUID;

public abstract class Head {

    public static ItemStack getNewPlayerHead(GameProfile gameProfile, String noteBlockSound, int count){
        String playerName = gameProfile.getName();
        PropertyMap propertyMap = gameProfile.getProperties();
        String texturePropertyValue = "";
        for (Property textureProperty : propertyMap.get("textures")){
            if (textureProperty.name().equals("textures")){
                texturePropertyValue = textureProperty.value();
                break;
            }
        }
        if (!texturePropertyValue.contains("cHJvZmlsZUlk")){
            return null;
        }
        String textures = "ewogICJ0aW1lc3RhbXAiIDogMCwKICAicHJvZmlsZUlk" + texturePropertyValue.split("cHJvZmlsZUlk")[1];

        return getTexturedHead(playerName, textures, gameProfile.getId(), noteBlockSound, count);

    }

    public static ItemStack getPowerHead(BlockState blockState){
        int power = blockState.get(Properties.POWER);
        return getTexturedHead("Redstone_"+Integer.toHexString(power).toUpperCase(),Heads.getRedstoneHeadTexture(power),Heads.getRedstoneHeadUUID(power),"",1,MutableText.of(new TranslatableTextContent("RedstoneHead_",null,TranslatableTextContent.EMPTY_ARGUMENTS)).append(Integer.toHexString(power).toUpperCase()));
    }

    public static ItemStack getBlockHead(Block block){
        return (Heads.isInList(block)) ? getTexturedHead(Registries.BLOCK.getId(block).getPath(), Heads.getBlockTexture(block), Heads.getBlockUUID(block),"", 1, block.getName()) : null;
    }

    public static ItemStack getTexturedHead(String entityName, String texture, UUID uuid, String noteBlockSound, int count){
        return getTexturedHead(entityName, texture, uuid, noteBlockSound, count, Text.literal(entityName));
    }

    public static ItemStack getTexturedHead(String entityName, String texture, UUID uuid, String noteBlockSound, int count, MutableText displayName){
        if (entityName.length()>16){
            entityName = entityName.substring(0,16);
        }
        ItemStack textureHeadStack = new ItemStack(Items.PLAYER_HEAD, count);

        GameProfile gameProfile = new GameProfile(uuid, entityName.replace(" ","_"));
        gameProfile.getProperties().put("textures", new Property("textures", texture));

        textureHeadStack.set(DataComponentTypes.PROFILE, new ProfileComponent(gameProfile));

        if (!noteBlockSound.isEmpty()){
            textureHeadStack.set(DataComponentTypes.NOTE_BLOCK_SOUND, Identifier.of(noteBlockSound));
        }

        textureHeadStack.set(DataComponentTypes.CUSTOM_NAME, displayName);

        return textureHeadStack;

    }

    @Deprecated
    public static GameProfile getGameProfileFromPlayerName(ServerWorld serverWorld, String playerName){
        MinecraftSessionService minecraftSessionService = serverWorld.getServer().getSessionService();

        MinecraftServer minecraftServer = serverWorld.getServer();
        UserCache userCache = minecraftServer.getUserCache();

        UUID headUUID;

        Optional<GameProfile> playerNameGameProfileOptional = userCache.findByName(playerName);
        if (playerNameGameProfileOptional.isEmpty()){
            return null;
        }
        GameProfile playerNameGameProfile = playerNameGameProfileOptional.get();
        if (playerNameGameProfile == null){
            return null;
        }
        headUUID = playerNameGameProfile.getId();
        GameProfile gameProfile;
        ProfileResult profileResult = minecraftSessionService.fetchProfile(headUUID, false);
        if (profileResult == null){
            return null;
        }
        gameProfile = profileResult.profile();
        if (gameProfile == null){
            return null;
        }
        return gameProfile;
    }

}
