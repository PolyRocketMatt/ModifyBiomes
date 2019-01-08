/*
    Copyright 2017 June Hanabi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.gmail.junehanabi.modifybiomes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.server.v1_13_R2.Biomes;
import net.minecraft.server.v1_13_R2.BiomeBase;

/**
 *
 * @author junebug
 */
public class BiomesMapping {
    public static final String OCEAN = "OCEAN";
    public static final String PLAINS = "PLAINS";
    public static final String DESERT = "DESERT";
    public static final String MOUNTAINS = "MOUNTAINS";
    public static final String FOREST = "FOREST";
    public static final String TAIGA = "TAIGA";
    public static final String SWAMP = "SWAMP";
    public static final String RIVER = "RIVER";
    public static final String NETHER = "NETHER";
    public static final String THE_END = "THE_END";
    public static final String FROZEN_OCEAN = "FROZEN_OCEAN";
    public static final String FROZEN_RIVER = "FROZEN_RIVER";
    public static final String SNOWY_TUNDRA = "SNOWY_TUNDRA";
    public static final String SNOWY_MOUNTAINS = "SNOWY_MOUNTAINS";
    public static final String MUSHROOM_FIELDS = "MUSHROOM_FIELDS";
    public static final String MUSHROOM_FIELD_SHORE = "MUSHROOM_FIELD_SHORE";
    public static final String BEACH = "BEACH";
    public static final String DESERT_HILLS = "DESERT_HILLS";
    public static final String WOODED_HILLS = "WOODED_HILLS";
    public static final String TAIGA_HILLS = "TAIGA_HILLS";
    public static final String MOUNTAIN_EDGE = "MOUNTAIN_EDGE";
    public static final String JUNGLE = "JUNGLE";
    public static final String JUNGLE_HILLS = "JUNGLE_HILLS";
    public static final String JUNGLE_EDGE = "JUNGLE_EDGE";
    public static final String DEEP_OCEAN = "DEEP_OCEAN";
    public static final String STONE_SHORE = "STONE_SHORE";
    public static final String SNOWY_BEACH = "SNOWY_BEACH";
    public static final String BIRCH_FOREST = "BIRCH_FOREST";
    public static final String BIRCH_FOREST_HILLS = "BIRCH_FOREST_HILLS";
    public static final String DARK_FOREST = "DARK_FOREST";
    public static final String SNOWY_TAIGA = "SNOWY_TAIGA";
    public static final String SNOWY_TAIGA_HILLS = "SNOWY_TAIGA_HILLS";
    public static final String GIANT_TREE_TAIGA = "GIANT_TREE_TAIGA";
    public static final String GIANT_TREE_TAIGA_HILLS = "GIANT_TREE_TAIGA_HILLS";
    public static final String WOODED_MOUNTAINS = "WOODED_MOUNTAINS";
    public static final String SAVANNA = "SAVANNA";
    public static final String SAVANNA_PLATEAU = "SAVANNA_PLATEAU";
    public static final String BADLANDS = "BADLANDS";
    public static final String WOODED_BADLANDS_PLATEAU = "WOODED_BADLANDS_PLATEAU";
    public static final String BADLANDS_PLATEAU = "BADLANDS_PLATEAU";
    public static final String SMALL_END_ISLANDS = "SMALL_END_ISLANDS";
    public static final String END_MIDLANDS = "END_MIDLANDS";
    public static final String END_HIGHLANDS = "END_HIGHLANDS";
    public static final String END_BARRENS = "END_BARRENS";
    public static final String WARM_OCEAN = "WARM_OCEAN";
    public static final String LUKEWARM_OCEAN = "LUKEWARM_OCEAN";
    public static final String COLD_OCEAN = "COLD_OCEAN";
    public static final String DEEP_WARM_OCEAN = "DEEP_WARM_OCEAN";
    public static final String DEEP_LUKEWARM_OCEAN = "DEEP_LUKEWARM_OCEAN";
    public static final String DEEP_COLD_OCEAN = "DEEP_COLD_OCEAN";
    public static final String DEEP_FROZEN_OCEAN = "DEEP_FROZEN_OCEAN";
    public static final String THE_VOID = "THE_VOID";
    public static final String SUNFLOWER_PLAINS = "SUNFLOWER_PLAINS";
    public static final String DESERT_LAKES = "DESERT_LAKES";
    public static final String GRAVELLY_MOUNTAINS = "GRAVELLY_MOUNTAINS";
    public static final String FLOWER_FOREST = "FLOWER_FOREST";
    public static final String TAIGA_MOUNTAINS = "TAIGA_MOUNTAINS";
    public static final String SWAMP_HILLS = "SWAMP_HILLS";
    public static final String ICE_SPIKES = "ICE_SPIKES";
    public static final String MODIFIED_JUNGLE = "MODIFIED_JUNGLE";
    public static final String MODIFIED_JUNGLE_EDGE = "MODIFIED_JUNGLE_EDGE";
    public static final String TALL_BIRCH_FOREST = "TALL_BIRCH_FOREST";
    public static final String TALL_BIRCH_HILLS = "TALL_BIRCH_HILLS";
    public static final String DARK_FOREST_HILLS = "DARK_FOREST_HILLS";
    public static final String SNOWY_TAIGA_MOUNTAINS = "SNOWY_TAIGA_MOUNTAINS";
    public static final String GIANT_SPRUCE_TAIGA = "GIANT_SPRUCE_TAIGA";
    public static final String GIANT_SPRUCE_TAIGA_HILLS = "GIANT_SPRUCE_TAIGA_HILLS";
    public static final String MODIFIED_GRAVELLY_MOUNTAINS = "MODIFIED_GRAVELLY_MOUNTAINS";
    public static final String SHATTERED_SAVANNA = "SHATTERED_SAVANNA";
    public static final String SHATTERED_SAVANNA_PLATEAU = "SHATTERED_SAVANNA_PLATEAU";
    public static final String ERODED_BADLANDS = "ERODED_BADLANDS";
    public static final String MODIFIED_WOODED_BADLANDS_PLATEAU = "MODIFIED_WOODED_BADLANDS_PLATEAU";
    public static final String MODIFIED_BADLANDS_PLATEAU = "MODIFIED_BADLANDS_PLATEAU";
    
    // Converts ID above to its associated BiomeBase
    public static BiomeBase GetBiome(String ID) 
            throws NoSuchFieldException, 
                    IllegalArgumentException, 
                    IllegalAccessException
    {
         // Get field contents
        Field field = Biomes.class.getDeclaredField(ID);
        field.setAccessible(true);
        return (BiomeBase)field.get(null);
    }
    
    // Replaces one biome for another
    public static void ReplaceBiome(String fromId, String toId) 
            throws NoSuchFieldException, 
                    IllegalArgumentException, 
                    IllegalAccessException {
        
        ReplaceBiome(fromId, GetBiome(toId));
    }
    
    public static void ReplaceBiome(String fromId, BiomeBase toId) 
            throws NoSuchFieldException, 
                    IllegalArgumentException, 
                    IllegalAccessException {
        
        // Get field and make editable
        Field field = Biomes.class.getDeclaredField(fromId);
        field.setAccessible(true);

        // Remove final
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        
        // Replace
        field.set(null, toId);
    }
}
