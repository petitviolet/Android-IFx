package net.petitviolet.ifx;

import net.petitviolet.ifx.func.Action;

import org.junit.Test;

import java.lang.Override;
import java.lang.String;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class IFxTest {
    @Test
    public void ifxTest1() throws Exception {
        String result = IFx.<String>of(true).apply("hoge")
                .ElseIf(false).apply("foo")
                .Else("bar");

        assert result == "hoge";
    }

    @Test
    public void ifxTest2() throws Exception {
        String result = IFx.<String>of(false).apply("hoge")
                .ElseIf(true).apply("foo")
                .Else("bar");

        assert result == "foo";
    }

    @Test
    public void ifxTest3() throws Exception {
        String result = IFx.<String>of(false).apply("hoge")
                .ElseIf(false).apply("foo")
                .Else("bar");

        assert result == "bar";
    }

    @Test
    public void ifxTest1x() throws Exception {
        String result = IFx.<String>of(true).apply(new Action<String>() {
            @Override
            public String run() {
                return "hoge";
            }
        }).ElseIf(false).apply(new Action<String>() {
            @Override
            public String run() {
                return "foo";
            }
        }).Else(new Action<String>() {
            @Override
            public String run() {
                return "bar";
            }
        });

        assert result == "hoge";
    }

    @Test
    public void ifxTest2x() throws Exception {
        String result = IFx.<String>of(false).apply(new Action<String>() {
            @Override
            public String run() {
                return "hoge";
            }
        }).ElseIf(true).apply(new Action<String>() {
            @Override
            public String run() {
                return "foo";
            }
        }).Else(new Action<String>() {
            @Override
            public String run() {
                return "bar";
            }
        });

        assert result == "foo";
    }

    @Test
    public void ifxTest3x() throws Exception {
        String result = IFx.<String>of(false).apply(new Action<String>() {
            @Override
            public String run() {
                return "hoge";
            }
        }).ElseIf(false).apply(new Action<String>() {
            @Override
            public String run() {
                return "foo";
            }
        }).Else(new Action<String>() {
            @Override
            public String run() {
                return "bar";
            }
        });
        assert result == "bar";
    }
}