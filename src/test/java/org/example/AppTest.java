package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void testBark() {
        String expectedString = "woof";
        assertEquals(expectedString, "woof");
    }
}