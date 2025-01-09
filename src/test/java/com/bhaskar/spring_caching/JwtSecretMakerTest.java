package com.bhaskar.spring_caching;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import javax.xml.datatype.DatatypeFactory;

public class JwtSecretMakerTest {

    @Test
    public void generateSecretKey(){
        SecretKey key =  Jwts.SIG.HS512.key().build();
        String encodedKey=DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\nkey=[%s]\n", encodedKey);

    }
}
