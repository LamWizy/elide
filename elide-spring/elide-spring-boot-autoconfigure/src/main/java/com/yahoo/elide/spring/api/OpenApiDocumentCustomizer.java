/*
 * Copyright 2023, the original author or authors.
 * Licensed under the Apache License, Version 2.0
 * See LICENSE file in project root for terms.
 */
package com.yahoo.elide.spring.api;

import io.swagger.v3.oas.models.OpenAPI;

/**
 * Customizes the OpenAPI document to be generated by the Elide ApiDocs endpoint.
 */
@FunctionalInterface
public interface OpenApiDocumentCustomizer {
    void customize(OpenAPI openApi);
}
