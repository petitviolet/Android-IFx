package net.petitviolet.ifx;

import net.petitviolet.ifx.IFx;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class IFxTest {
    @Test
    public void ifxTest1() throws Exception {
        String result = (String) IFx.of(true).apply("hoge")
                .ElseIf(false).apply("foo")
                .Else("bar");

        assert result == "hoge";
    }

    @Test
    public void ifxTest2() throws Exception {
        String result = (String) IFx.of(false).apply("hoge")
                .ElseIf(true).apply("foo")
                .Else("bar");

        assert result == "foo";
    }

    @Test
    public void ifxTest3() throws Exception {
        String result = (String) IFx.of(false).apply("hoge")
                .ElseIf(false).apply("foo")
                .Else("bar");

        assert result == "bar";
    }
}