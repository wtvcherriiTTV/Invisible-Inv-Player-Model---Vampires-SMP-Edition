package de.chloedev.noinvcharacter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NoInvCharacterConfig {
    public static boolean showPaperdoll = false;

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("noinvcharacter.json");

    public static void load() {
        if (Files.exists(CONFIG_FILE)) {
            try (var reader = Files.newBufferedReader(CONFIG_FILE)) {
                ConfigData data = GSON.fromJson(reader, ConfigData.class);
                if (data != null) {
                    showPaperdoll = data.showPaperdoll;
                }
            } catch (IOException e) {
                System.err.println("Failed to load NoInvCharacter config!");
            }
        } else {
            save(); 
        }
    }

    public static void save() {
        try (var writer = Files.newBufferedWriter(CONFIG_FILE)) {
            ConfigData data = new ConfigData();
            data.showPaperdoll = showPaperdoll;
            GSON.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Failed to save NoInvCharacter config!");
        }
    }

    private static class ConfigData {
        public boolean showPaperdoll = NoInvCharacterConfig.showPaperdoll;
    }
}