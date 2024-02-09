package TestCases;

import java.util.Base64;

public class EncodingsDecoding {
    public static void main(String[] args) {
        String password = "admin123";

        byte[] encoded_pas = Base64.getEncoder().encode(password.getBytes());
        String encoded_pass = new String(encoded_pas);
        //String encoded_pas = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println("Encoded Password: "+encoded_pass);

        byte[] decoded_pass = Base64.getDecoder().decode(encoded_pas);
        System.out.println("Decoded Password: "+new String(decoded_pass));


    }
}
