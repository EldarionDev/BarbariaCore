package barbaria.barbaria.factions;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactionsContainer {
    public void loadFaction(String name, String data) {
        Gson gsonInstance = new Gson();
        worldFactions.put(name, gsonInstance.fromJson(data, Faction.class));
    }

    public void unloadFaction(String name) {
        worldFactions.remove(name);
    }

    public Faction getFaction(String name) {
        return worldFactions.get(name);
    }

    public String getFactionAsJsonString(String name) {
        Faction f = worldFactions.get(name);
        Gson gsonInstance = new Gson();
        return gsonInstance.toJson(f);
    }

    public List<Faction> getFactions() {
        List<Faction> returnList = new ArrayList<>();
        for (Map.Entry<String, Faction> entry : worldFactions.entrySet()) {
            returnList.add(entry.getValue());
        }
        return returnList;
    }

    public List<String> getFactionNames() {
        List<String> returnList = new ArrayList<>();
        for (Map.Entry<String, Faction> entry : worldFactions.entrySet()) {
            returnList.add(entry.getKey());
        }
        return returnList;
    }

    public static HashMap<String, Faction> worldFactions = new HashMap<>();
}
