/*
 * Created by Ubique Innovation AG
 * https://www.ubique.ch
 * Copyright (c) 2020. All rights reserved.
 */

package org.dpppt.backend.sdk.data.etag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Base64;

@Component
public class EtagGenerator implements EtagGeneratorInterface {

    @Value("${crypto.etag-salt}")
    private byte[] salt;

    @Autowired
    @Qualifier("sha-256-digest")
    private MessageDigest sha256Digest;

    @Override
    public String getEtag(int primaryKey) {

        final ByteBuffer buffer = ByteBuffer.allocate(salt.length + Integer.BYTES);

        buffer.put(salt);
        buffer.putInt(primaryKey);

        final byte[] saltedPayload = buffer.array();

        final byte[] sha256Hash = sha256Digest.digest(saltedPayload);

        return Base64.getEncoder().encodeToString(sha256Hash);
    }
}