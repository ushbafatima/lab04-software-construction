/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {

    /**
     * Basic tests already provided.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * External code, available, cited, not coursework, not required → allowed.
     */
    @Test
    public void testExternalCodeWithCitationAllowed() {
        assertTrue("Expected true: cited external library use",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    /**
     * External code but from past 6.005 coursework → not allowed.
     */
    @Test
    public void testCourseWorkNotAllowed() {
        assertFalse("Expected false: past coursework cannot be reused",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * External, cited, but assignment requires own implementation → not allowed.
     */
    @Test
    public void testImplementationRequiredBlocksExternal() {
        assertFalse("Expected false: assignment requires own implementation",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }

    /**
     * External, not available to all students → not allowed.
     */
    @Test
    public void testExternalCodeNotAvailableToAll() {
        assertFalse("Expected false: external code not available to all students",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }
}
