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

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Arrays;

public class ModifyBiomes extends JavaPlugin {
    
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        FileConfiguration config = getConfig();
        for (String BiomeToReplace : config.getKeys(false))
        {
            BiomeToReplace = BiomeToReplace.toUpperCase();
            if (Arrays.stream(BiomesMapping.AllowedBiomes).anyMatch(BiomeToReplace::equals))
            {
                String ReplaceBiome = config.getString(BiomeToReplace).toUpperCase();
                if (Arrays.stream(BiomesMapping.AllowedBiomes).anyMatch(ReplaceBiome::equals))
                {
                    try
                    {
                        BiomesMapping.ReplaceBiome(BiomeToReplace, ReplaceBiome);
                    }
                    catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex)
                    {
                        getLogger().info("Failed to replace " + BiomeToReplace + " with " + ReplaceBiome );
                    }
                }
                else{
                    getLogger().info("Biome " + ReplaceBiome + " you wanted to replace with is not part of the biomes list" );
                }
            }
            else{
                getLogger().info("Biome " + BiomeToReplace + " you wanted to replace is not part of the biomes list" );
            }
        }
    }
    
    @Override
    public void onDisable()
    {
        //Do nothing
    }
}
