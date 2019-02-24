package com.authentication.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * BasicAuthenticationTest.java - Basic Authentication Implementation
 *
 * @author PradheepKumarA
 * @date 2019-02-25
 */
class BasicAuthenticationTest {

    @Test
    void encodeBasicAuth() {
        String username = "username";
        String password = "password";
        String expectedBasicEncode = "dXNlcm5hbWU6cGFzc3dvcmQ=";

        String acutualBasicEncode = BasicAuthentication.encodeBasicAuth(new Credential(username, password));
        assertEquals(expectedBasicEncode, acutualBasicEncode, "should do proper basic auth encoding");
    }

    @Test
    void decodeBasicAuth() throws IOException {
        String username = "username";
        String password = "password";
        Credential expectedCredentails = new Credential(username, password);

        String basicAuthEncode = BasicAuthentication.encodeBasicAuth(expectedCredentails);
        Credential actualCredential = BasicAuthentication.decodeBasicAuth(basicAuthEncode);
        assertEquals(expectedCredentails, actualCredential, "should decode the basis auth encoding");
    }
}