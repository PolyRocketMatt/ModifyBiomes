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

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class ModifyBiomes extends JavaPlugin {
    
    @Override
    public void onEnable() {
        
        try {
            /*
             * All the frozen biomes
             * 
             * 1) ColdBeach
             * 2) FrozenOcean
             * 3) FrozenRiver
             * 4) IceFlats
             * 5) IceMountains
             * 6) TaigaCold
             * 7) TaigaColdHills
             */
            
            // Here we relpace the non-frigid ones with closest frozen counterpart
            BiomesMapping.ReplaceBiome(BiomesMapping.BEACHES, BiomesMapping.COLD_BEACH);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUSHROOM_ISLAND_SHORE, BiomesMapping.COLD_BEACH);
            BiomesMapping.ReplaceBiome(BiomesMapping.STONE_BEACH, BiomesMapping.COLD_BEACH);
            
            BiomesMapping.ReplaceBiome(BiomesMapping.DEEP_OCEAN, BiomesMapping.FROZEN_OCEAN);
            BiomesMapping.ReplaceBiome(BiomesMapping.OCEAN, BiomesMapping.FROZEN_OCEAN);
            
            BiomesMapping.ReplaceBiome(BiomesMapping.RIVER, BiomesMapping.FROZEN_RIVER);
            
            BiomesMapping.ReplaceBiome(BiomesMapping.DESERT, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_DESERT, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MESA, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MESA_CLEAR_ROCK, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MESA_ROCK, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_MESA, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_MESA_CLEAR_ROCK, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_MESA_ROCK, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUSHROOM_ISLAND, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.PLAINS, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_PLAINS, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.SAVANNA, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.SAVANNA_ROCK, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_SAVANNA, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_SAVANNA_ROCK, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.SWAMPLAND, BiomesMapping.ICE_FLATS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_SWAMPLAND, BiomesMapping.ICE_FLATS);
            
            BiomesMapping.ReplaceBiome(BiomesMapping.EXTREME_HILLS, BiomesMapping.ICE_MOUNTAINS);
            BiomesMapping.ReplaceBiome(BiomesMapping.EXTREME_HILLS_WITH_TREES, BiomesMapping.ICE_MOUNTAINS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_EXTREME_HILLS, BiomesMapping.ICE_MOUNTAINS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_EXTREME_HILLS_WITH_TREES, BiomesMapping.ICE_MOUNTAINS);
            
            BiomesMapping.ReplaceBiome(BiomesMapping.BIRCH_FOREST, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_BIRCH_FOREST, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.FOREST, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_FOREST, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.JUNGLE, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.JUNGLE_EDGE, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_JUNGLE, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_JUNGLE_EDGE, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.REDWOOD_TAIGA, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_REDWOOD_TAIGA, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.ROOFED_FOREST, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_ROOFED_FOREST, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.TAIGA, BiomesMapping.TAIGA_COLD);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_TAIGA, BiomesMapping.TAIGA_COLD);
            
            BiomesMapping.ReplaceBiome(BiomesMapping.BIRCH_FOREST_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_BIRCH_FOREST_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.DESERT_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.FOREST_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.JUNGLE_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.REDWOOD_TAIGA_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.MUTATED_REDWOOD_TAIGA_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.SMALLER_EXTREME_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
            BiomesMapping.ReplaceBiome(BiomesMapping.TAIGA_HILLS, BiomesMapping.TAIGA_COLD_HILLS);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger
                    .getLogger(ModifyBiomes.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
