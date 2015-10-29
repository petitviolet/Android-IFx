# Android-IFx

![jitpack](https://img.shields.io/github/tag/petitviolet/Android-IFx.svg?label=JitPack)

This library for Android provides `if-expression` like Scala.  
`IFx` enabled Java if-statement to return value.  
Strongly inspired by [jshosomichi/ifx](https://github.com/jshosomichi/ifx).  

# How to Use

## Set up

```groovy
repositories {
    // ...
    maven { url "https://jitpack.io" }
}

// ...

dependencies {
    compile 'com.github.petitviolet:Android-IFx:0.0.1'
}
```

## Interface

```java
/** returns primitive value pattern **/
// if ~ else if ~ else
String result = IFx.<String>of(false).apply("hoge")
        .ElseIf(false).apply("foo")
        .Else("bar");
assert result == "bar";

// if ~ else if ~
String result2 = IFx.<String>of(true).apply("hoge")
        .ElseIf(false).apply("foo")
        .get();
assert result2 == "hoge";

// not matched 
String result3 = IFx.<String>of(false).apply("hoge").get()
assert result3 == null;


/** returns value the result of given method invoked **/
String result4 = IFx.<String>of(false).apply(new Action<String>() {
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
        Log.d(TAG, "in else condition!");
        return "bar";
    }
});

assert result4 == "foo";

// with lambda expression
String result5 = IFx.<String>of(false).apply(() -> "hoge")
    .ElseIf(true).apply(() -> "foo")
    .Else(() -> {
        Log.d(TAG, "in else condition!");
        return "bar";
    });

assert result5 == "foo";
```

# Lisence

This code is licensed under the Apache Software License 2.0.
