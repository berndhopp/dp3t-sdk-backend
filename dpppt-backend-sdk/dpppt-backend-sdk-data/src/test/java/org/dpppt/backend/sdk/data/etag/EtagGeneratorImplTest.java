package org.dpppt.backend.sdk.data.etag;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = EtagConfiguration.class)
@SpringJUnitConfig()
class EtagGeneratorImplTest {

    private static final int ITERATIONS = 1000;

    @Autowired
    private EtagGeneratorInterface etagGenerator;

    @Test
    void getEtag() throws IOException {

        int i = 0;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/expected_etags_first_thousand_with_default_salt")))){
            final String etag = etagGenerator.getEtag(i++);
            Assert.assertEquals(reader.readLine(), etag);
        }
    }
}