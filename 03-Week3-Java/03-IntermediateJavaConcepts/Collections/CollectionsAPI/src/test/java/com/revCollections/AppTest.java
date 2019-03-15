package com.revCollections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;//Testing Framework

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testAdd(){
        //1.
        TestCheck ch=new TestCheck();
        long outputExpected=500000000;
        int outputActual=ch.add(200000000,300000000);
        assertEquals(outputExpected, outputActual);
    }
    @Test
    public void testMultiply(){
        //1.
        TestCheck ch=new TestCheck();
        long outputExpected=9999800001l;
        long outputActual=ch.multiply(99999l,99999l);
        assertEquals(outputExpected, outputActual);
    }
}
