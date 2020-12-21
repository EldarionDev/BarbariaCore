package barbaria.barbaria.world;

import barbaria.barbaria.factions.Faction;
import barbaria.barbaria.factions.FactionsContainer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;

public class FactionWorldData extends WorldSavedData {
    private static final String DATA_NAME = "barbaria-faction-data";
    private static MinecraftServer server;


    public FactionWorldData(MinecraftServer server) {
        super(DATA_NAME);
        this.server = server;
        Faction f = new Faction();
        String fString = f.toString();
    }

    public static FactionWorldData getData(ServerWorld world) {
        return world.getSavedData().getOrCreate(() -> new FactionWorldData(world.getServer()), DATA_NAME);
    }

    @Override
    public void read(CompoundNBT nbt) {

    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        ListNBT completeData = new ListNBT();
        for (String s : FactionsContainer.getFactionNames()) {
            CompoundNBT tag = new CompoundNBT();
            tag.putString(s, FactionsContainer.getFactionAsJsonString(s));
            completeData.add(tag);
        }
        compound.put("factions", completeData);
        return compound;
    }
}
