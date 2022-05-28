package enzinium;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

class GenSig {

    static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);
            KeyPair kPair = keyGen.generateKeyPair();
            return kPair;
        } catch (Exception e) {
            return null;
        }
    }
}
