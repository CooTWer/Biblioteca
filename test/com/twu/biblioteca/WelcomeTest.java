package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class WelcomeTest {
    @Test
    public void sayWelcome() throws Exception {
        assertEquals("Welcome to Bangalore Public Library",new Welcome().SayWelcome());
    }
}