package com.yahoo.elide.extension.test;

import com.yahoo.elide.Elide;
import com.yahoo.elide.core.dictionary.EntityDictionary;
import com.yahoo.elide.extension.test.models.Book;
import com.yahoo.elide.jsonapi.resources.JsonApiEndpoint;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.test.QuarkusUnitTest;
import io.restassured.RestAssured;

import javax.inject.Inject;

public class ElideExtensionTest {

    // Start unit test with your extension loaded
    @RegisterExtension
    static final QuarkusUnitTest unitTest = new QuarkusUnitTest()
        .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                .addAsResource("application.properties")
                .addClass(JsonApiEndpoint.class)
                .addClass(Book.class));

    @Inject
    EntityDictionary dictionary;

    @Inject
    Elide elide;

    @Test
    public void writeYourOwnUnitTest() {
        // Write your unit tests here - see the testing extension guide https://quarkus.io/guides/writing-extensions#testing-extensions for more information
        Assertions.assertTrue(true, "Add some assertions to " + getClass().getName());
    }

    @Test
    public void testBookEndpoint() {
        RestAssured.when().get("/book").then().log().all().statusCode(200);
    }
}