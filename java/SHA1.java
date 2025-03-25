import java.security.*;
import java.nio.charset.StandardCharsets;

class SHA1Hash {
    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            System.out.println("Message digest object info:\n-----------------");
            System.out.println("Algorithm=" + md.getAlgorithm());
            System.out.println("Provider=" + md.getProvider());
            System.out.println("ToString=" + md.toString());

            String[] inputs = { "", "abc", "abcdefghijklmnopqrstuvwxyz" };

            for (String input : inputs) {
                md.update(input.getBytes(StandardCharsets.UTF_8));
                byte[] output = md.digest();
                System.out.println("\nSHA1(\"" + input + "\") = " + bytesToHex(output));
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b)); // Ensures lowercase hex output
        }
        return hexString.toString();
    }
}
