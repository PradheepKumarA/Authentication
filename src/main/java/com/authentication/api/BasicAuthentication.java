package com.authentication.api;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Scanner;

/**
 * BasicAuthentication
 *
 * @author PradheepKumarA
 * @date 2019-02-25
 */
public class BasicAuthentication {
    public static void main(String[] ar) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Username : ");
        String username = in.nextLine();
        System.out.print("Enter the Password : ");
        String password = in.nextLine();

        String basicAuthEncode = encodeBasicAuth(new Credential(username, password));
        System.out.println("Basic Authentication Encode : " + basicAuthEncode);

        Credential credential = decodeBasicAuth(basicAuthEncode);
        System.out.println("Basic Authentication Decoded Username : " + credential.getUsername() + " and password : " + credential.getPassword());
    }

    public static String encodeBasicAuth(Credential credential) {
        String credentialString = credential.getUsername() + ":" + credential.getPassword();
        return encodeBase64(credentialString);
    }

    public static Credential decodeBasicAuth(String encodedCredentails) throws IOException {
        String credential[] = decodeBase64(encodedCredentails).split(":");
        return new Credential(credential[0], credential[1]);
    }

    private static String encodeBase64(String data) {
        return new BASE64Encoder().encode(data.getBytes());
    }

    private static String decodeBase64(String data) throws IOException {
        byte[] bytes = new BASE64Decoder().decodeBuffer(data);
        return new String(bytes);
    }
}

class Credential {
    private String username, password;

    Credential(String username, String passeord) {
        this.username = username;
        this.password = passeord;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object object) {
        Credential credential = (Credential) object;
        return username.equals(credential.getUsername()) && password.equals(credential.getPassword());
    }
}
