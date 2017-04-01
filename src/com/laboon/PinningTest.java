package com.laboon;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by joshdemusz on 3/23/17.
 */
public class PinningTest {
    /*
        TESTS FOR toString()
     */

    // Test toString() method for when stack is empty.
    //      Tests to make sure that the stack sizes are consistent.
    @Test
    public void testEmptyStack() {
        ProgramStack ps = new ProgramStack();

        Assert.assertEquals("[]", ps.toString());
    }

    // Test toString() method for when stack is not empty.
    @Test
    public void testNonemptyStack() {
        ProgramStack ps = new ProgramStack();

        ps.push(1);
        ps.push(2);
        ps.push(3);

        Assert.assertEquals("[1, 2, 3]", ps.toString());
    }

    // Test toString() method for when stack only has one item in it.
    @Test
    public void testSingleStack() {
        ProgramStack ps = new ProgramStack();

        ps.push(1);

        Assert.assertEquals("[1]", ps.toString());
    }

    /*
        TESTS FOR getOpCode()
     */

    // Test getOpcode() method to make sure that inputting coordinates inside the grid returns
    //      the correct character.
    @Test
    public void testGetOpcodeInBounds() {
        ProgramArea pa = new ProgramArea();

        pa.setOpCode(10, 10, 'a');

        Assert.assertEquals('a', pa.getOpCode(10, 10));
    }

    // Test getOpcode() method to make sure that inputting coordinates outside the grid returns
    //      the '0' character.
    @Test
    public void testGetOpcodeOutOfBounds() {
        ProgramArea pa = new ProgramArea();

        Assert.assertEquals((char) 0, pa.getOpCode(10000, 10000));
    }

    // Test getOpcode() method to make sure that inputting coordinates on the lower boundary of the grid
    //      returns the correct character.
    @Test
    public void testGetOpcodeOnLowerBoundary() {
        ProgramArea pa = new ProgramArea();

        pa.setOpCode(0, 0, 'a');

        Assert.assertEquals('a', pa.getOpCode(0, 0));

        Assert.assertEquals((char) 0, pa.getOpCode(-1, -1));
    }

    // Test getOpcode() method to make sure that inputting coordinates on the upper boundary of the grid
    //      returns the correct character.
    @Test
    public void testGetOpcodeOnUpperBoundary() {
        ProgramArea pa = new ProgramArea();

        pa.setOpCode(99, 99, 'a');

        Assert.assertEquals('a', pa.getOpCode(99, 99));

        Assert.assertEquals((char) 0, pa.getOpCode(100, 100));
    }

    /*
        TESTS FOR modulo()
     */

    // Test modulo() method to make sure that it calculates the correct mod to an expected case.
    @Test
    public void testModuloExpectedUse() {
        MainPanel mp = new MainPanel();
        ProgramArea pa = new ProgramArea();
        ProgramStack ps = new ProgramStack();

        ps.push(10);
        ps.push(3);

        ProgramExecutor pe = new ProgramExecutor(mp, ps, pa);

        pe.modulo();

        Assert.assertEquals(1, ps.pop());
    }

    // Test modulo() method to make sure that it calculates the correct mod to a negative case.
    @Test
    public void testModuloNegative() {
        MainPanel mp = new MainPanel();
        ProgramArea pa = new ProgramArea();
        ProgramStack ps = new ProgramStack();

        ps.push(-10);
        ps.push(3);

        ProgramExecutor pe = new ProgramExecutor(mp, ps, pa);

        pe.modulo();

        Assert.assertEquals(-1, ps.pop());
    }

    // Test modulo() method to make sure that it calculates the correct mod when the mod is 0.
    @Test
    public void testModulo0() {
        MainPanel mp = new MainPanel();
        ProgramArea pa = new ProgramArea();
        ProgramStack ps = new ProgramStack();

        ps.push(10);
        ps.push(5);

        ProgramExecutor pe = new ProgramExecutor(mp, ps, pa);

        pe.modulo();

        Assert.assertEquals(0, ps.pop());
    }

    // Test modulo() method to make sure that the stack size is consistent before and after refactoring
    @Test
    public void testModuloStackSize() {
        MainPanel mp = new MainPanel();
        ProgramArea pa = new ProgramArea();
        ProgramStack ps = new ProgramStack();

        ps.push(10);
        ps.push(3);

        ProgramExecutor pe = new ProgramExecutor(mp, ps, pa);

        pe.modulo();
        ps.pop();

        Assert.assertEquals("[]", ps.toString());
    }
}
