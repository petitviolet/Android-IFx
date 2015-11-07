package net.petitviolet.ifx;

import net.petitviolet.ifx.func.Action;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class IFxTest {
    @Test
    public void ifxTestFail() throws Exception {
        String result = IFx.<String>of(false).then("hoge")
                .ElseIf(false).then("foo").get();

        assert result == null;
    }
    @Test
    public void ifxTestGet1() throws Exception {
        String result = IFx.<String>of(true).then("hoge")
                .ElseIf(false).then("foo").get();

        assert result == "hoge";
    }

    @Test
    public void ifxTestGet2() throws Exception {
        String result = IFx.<String>of(false).then("hoge")
                .ElseIf(true).then("foo").get();

        assert result == "foo";
    }
    @Test
    public void ifxTest1() throws Exception {
        String result = IFx.<String>of(true).then("hoge")
                .ElseIf(false).then("foo")
                .Else("bar");

        assert result == "hoge";
    }

    @Test
    public void ifxTest2() throws Exception {
        String result = IFx.<String>of(false).then("hoge")
                .ElseIf(true).then("foo")
                .Else("bar");

        assert result == "foo";
    }

    @Test
    public void ifxTest3() throws Exception {
        String result = IFx.<String>of(false).then("hoge")
                .ElseIf(false).then("foo")
                .Else("bar");

        assert result == "bar";
    }

    @Test
    public void ifxTest1x() throws Exception {
        String result = IFx.<String>of(true).then(new Action<String>() {
            @Override
            public String run() {
                return "hoge";
            }
        }).ElseIf(false).then(new Action<String>() {
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
        String result = IFx.<String>of(false).then(new Action<String>() {
            @Override
            public String run() {
                return "hoge";
            }
        }).ElseIf(true).then(new Action<String>() {
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
        String result = IFx.<String>of(false).then(new Action<String>() {
            @Override
            public String run() {
                return "hoge";
            }
        }).ElseIf(false).then(new Action<String>() {
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