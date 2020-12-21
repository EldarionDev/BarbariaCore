package barbaria.barbaria.factions;

public class Faction {
    public void setTrustworthy(int value) {
        this.trustworthy = value;
    }

    public int getTrustworthy() {
        return trustworthy;
    }

    public void setAggression(int value) {
        this.aggression = value;
    }

    public int getAggression() {
        return aggression;
    }

    public void setLoyalty(int value) {
        this.loyalty = value;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setTreasury(int value) {
        this.treasury = value;
    }

    public int getTreasury() {
        return this.treasury;
    }

    private int trustworthy;
    private int aggression;
    private int loyalty;
    private int treasury;
}
