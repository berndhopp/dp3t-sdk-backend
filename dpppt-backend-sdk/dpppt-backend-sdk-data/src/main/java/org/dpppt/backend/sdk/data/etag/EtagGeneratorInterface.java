/*
 * Created by Ubique Innovation AG
 * https://www.ubique.ch
 * Copyright (c) 2020. All rights reserved.
 */

package org.dpppt.backend.sdk.data.etag;

public interface EtagGeneratorInterface {
    String getEtag(int primaryKey);
}