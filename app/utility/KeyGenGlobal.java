package utility;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenGlobal {
    public static void main(String[] args) {
        byte[] bytes = new byte[48];
        new SecureRandom().nextBytes(bytes);
        System.out.println(Base64.getEncoder().encodeToString(bytes));
    }
}
