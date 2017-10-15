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
import net.minecraft.server.v1_12_R1.Biomes;
import net.minecraft.server.v1_12_R1.BiomeBase;

/**
 *
 * @author junebug
 */
public class BiomesMapping {
    public static final String OCEAN = "a";
    public static final String PLAINS = "c";
    public static final String DESERT = "d";
    public static final String EXTREME_HILLS = "e";
    public static final String FOREST = "f";
    public static final String TAIGA = "g";
    public static final String SWAMPLAND = "h";
    public static final String RIVER = "i";
    public static final String HELL = "j";
    public static final String SKY = "k";
    public static final String FROZEN_OCEAN = "l";
    public static final String FROZEN_RIVER = "m";
    public static final String ICE_FLATS = "n";
    public static final String ICE_MOUNTAINS = "o";
    public static final String MUSHROOM_ISLAND = "p";
    public static final String MUSHROOM_ISLAND_SHORE = "q";
    public static final String BEACHES = "r";
    public static final String DESERT_HILLS = "s";
    public static final String FOREST_HILLS = "t";
    public static final String TAIGA_HILLS = "u";
    public static final String SMALLER_EXTREME_HILLS = "v";
    public static final String JUNGLE = "w";
    public static final String JUNGLE_HILLS = "x";
    public static final String JUNGLE_EDGE = "y";
    public static final String DEEP_OCEAN = "z";
    public static final String STONE_BEACH = "A";
    public static final String COLD_BEACH = "B";
    public static final String BIRCH_FOREST = "C";
    public static final String BIRCH_FOREST_HILLS = "D";
    public static final String ROOFED_FOREST = "E";
    public static final String TAIGA_COLD = "F";
    public static final String TAIGA_COLD_HILLS = "G";
    public static final String REDWOOD_TAIGA = "H";
    public static final String REDWOOD_TAIGA_HILLS = "I";
    public static final String EXTREME_HILLS_WITH_TREES = "J";
    public static final String SAVANNA = "K";
    public static final String SAVANNA_ROCK = "L";
    public static final String MESA = "M";
    public static final String MESA_ROCK = "N";
    public static final String MESA_CLEAR_ROCK = "O";
    public static final String VOID = "P";
    public static final String MUTATED_PLAINS = "Q";
    public static final String MUTATED_DESERT = "R";
    public static final String MUTATED_EXTREME_HILLS = "S";
    public static final String MUTATED_FOREST = "T";
    public static final String MUTATED_TAIGA = "U";
    public static final String MUTATED_SWAMPLAND = "V";
    public static final String MUTATED_ICE_FLATS = "W";
    public static final String MUTATED_JUNGLE = "X";
    public static final String MUTATED_JUNGLE_EDGE = "Y";
    public static final String MUTATED_BIRCH_FOREST = "Z";
    public static final String MUTATED_BIRCH_FOREST_HILLS = "aa";
    public static final String MUTATED_ROOFED_FOREST = "ab";
    public static final String MUTATED_TAIGA_COLD = "ac";
    public static final String MUTATED_REDWOOD_TAIGA = "ad";
    public static final String MUTATED_REDWOOD_TAIGA_HILLS = "ae";
    public static final String MUTATED_EXTREME_HILLS_WITH_TREES = "af";
    public static final String MUTATED_SAVANNA = "ag";
    public static final String MUTATED_SAVANNA_ROCK = "ah";
    public static final String MUTATED_MESA = "ai";
    public static final String MUTATED_MESA_ROCK = "aj";
    public static final String MUTATED_MESA_CLEAR_ROCK = "ak";
    
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
