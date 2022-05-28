package enzinium;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

    private PublicKey pbKey = null;
    private PrivateKey pvKey = null;
    private double balance = 0d;
    private String symbol = "EZI";

    public Address() {};

    public PublicKey getPK() {
        return pbKey;
    }

    public void setPK(PublicKey pbKey) {
        this.pbKey = pbKey;
    }

    public PrivateKey getSK() {
        return pvKey;
    }

    public void setSK(PrivateKey pvKey) {
        this.pvKey = pvKey;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void generateKeyPair() {
        KeyPair kPair = GenSig.generateKeyPair();
        this.setPK(kPair.getPublic());
        this.setSK(kPair.getPrivate());
    }

    @Override
    public String toString() {
        return "PK = " + getPK().hashCode() + "\n" +
                "Balance = " + getBalance() +
                " " + this.symbol + "\n";
    }
}
