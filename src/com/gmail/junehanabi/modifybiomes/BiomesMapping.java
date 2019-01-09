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
    public static final String[] AllowedBiomes = {"OCEAN","PLAINS","DESERT","MOUNTAINS","FOREST","TAIGA","SWAMP","RIVER","NETHER","THE_END", "FROZEN_OCEAN", "FROZEN_RIVER", "SNOWY_TUNDRA", "SNOWY_MOUNTAINS", "MUSHROOM_FIELDS", "MUSHROOM_FIELD_SHORE", "BEACH", "DESERT_HILLS",
                                                "WOODED_HILLS", "TAIGA_HILLS", "MOUNTAIN_EDGE", "JUNGLE", "JUNGLE_HILLS", "JUNGLE_EDGE", "DEEP_OCEAN", "STONE_SHORE", "SNOWY_BEACH", "BIRCH_FOREST", "BIRCH_FOREST_HILLS", "DARK_FOREST", "SNOWY_TAIGA", "SNOWY_TAIGA_HILLS",
                                                "GIANT_TREE_TAIGA", "GIANT_TREE_TAIGA_HILLS", "WOODED_MOUNTAINS", "SAVANNA", "SAVANNA_PLATEAU", "BADLANDS", "WOODED_BADLANDS_PLATEAU", "BADLANDS_PLATEAU", "SMALL_END_ISLANDS", "END_MIDLANDS", "END_HIGHLANDS", "END_BARRENS",
                                                "WARM_OCEAN", "LUKEWARM_OCEAN", "COLD_OCEAN", "DEEP_WARM_OCEAN", "DEEP_LUKEWARM_OCEAN", "DEEP_COLD_OCEAN", "DEEP_FROZEN_OCEAN", "THE_VOID", "SUNFLOWER_PLAINS", "DESERT_LAKES", "GRAVELLY_MOUNTAINS", "FLOWER_FOREST", "TAIGA_MOUNTAINS",
                                                "SWAMP_HILLS", "ICE_SPIKES", "MODIFIED_JUNGLE", "MODIFIED_JUNGLE_EDGE", "TALL_BIRCH_FOREST", "TALL_BIRCH_HILLS", "DARK_FOREST_HILLS", "SNOWY_TAIGA_MOUNTAINS", "GIANT_SPRUCE_TAIGA", "GIANT_SPRUCE_TAIGA_HILLS", "MODIFIED_GRAVELLY_MOUNTAINS",
                                                "SHATTERED_SAVANNA", "SHATTERED_SAVANNA_PLATEAU", "ERODED_BADLANDS", "MODIFIED_WOODED_BADLANDS_PLATEAU", "MODIFIED_BADLANDS_PLATEAU"};
    
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
