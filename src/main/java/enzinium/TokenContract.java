package enzinium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class TokenContract {

    private Address owner = null;
    private PublicKey ownerPK = null;
    private String name = null;
    private String symbol = null;
    private double totalSupply = 0d;
    private Double tokenPrice = 0d;

    private final Map<PublicKey, Double> balances = new HashMap<>();

    public TokenContract(Address owner) {
        this.owner = owner;
        this.ownerPK = owner.getPK();
    };

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String symbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double totalSupply() {
        return this.totalSupply;
    }

    public void setTotalSupply(double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Double getTokenPrice() {
        return tokenPrice;
    }

    public void setTokenPrice(Double tokenPrice) {
        this.tokenPrice = tokenPrice;
    }

    public Map<PublicKey, Double> getBalances() {
        return this.balances;
    }

    public void addOwner(PublicKey PK, Double units) {
        getBalances().putIfAbsent(PK, units);
    }

    public int numOwners() {
        return this.getBalances().size();
    }

    public Double balanceOf(PublicKey owner) {
        return this.getBalances().getOrDefault(owner, 0d);
    }

    @Override
    public String toString() {
        return "\n" + "name = " + name() + "\n" +
                "symbol = " + symbol() + "\n" +
                "totalSupply = " + totalSupply() + "\n" +
                "owner PK = " + this.ownerPK.hashCode() + "\n";
    }
}
