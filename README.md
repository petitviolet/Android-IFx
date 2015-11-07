# Android-IFx

[![Download](https://api.bintray.com/packages/petitviolet/maven/android-ifx/images/download.svg) ](https://bintray.com/petitviolet/maven/android-ifx/\_latestVersion) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android--IFx-green.svg?style=flat)](https://android-arsenal.com/details/1/2703)


This library for Android provides `if-expression` like Scala.  
`IFx` enabled Java if-statement to return value.  
Strongly inspired by [jshosomichi/ifx](https://github.com/jshosomichi/ifx).  

# How to Use

## Set up

```groovy
dependencies {
    compile 'net.petitviolet.android:ifx:0.2.0'
}
```

## Interface

```java
/** returns primitive value pattern **/
// if ~ else if ~ else
String result = IFx.<String>of(false).then("hoge")
        .ElseIf(false).then("foo")
        .Else("bar");
assert result == "bar";

// if ~ else if ~
String result2 = IFx.<String>of(true).then("hoge")
        .ElseIf(false).then("foo")
        .get();
assert result2 == "hoge";

// not matched 
String result3 = IFx.<String>of(false).then("hoge").get()
assert result3 == null;


/** returns value the result of given method invoked **/
String result4 = IFx.<String>of(false).then(new Action<String>() {
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
        Log.d(TAG, "in else condition!");
        return "bar";
    }
});

assert result4 == "foo";

// with lambda expression
String result5 = IFx.<String>of(false).then(() -> "hoge")
    .ElseIf(true).then(() -> "foo")
    .Else(() -> {
        Log.d(TAG, "in else condition!");
        return "bar";
    });

assert result5 == "foo";
```

# Lisence

This code is licensed under the Apache Software License 2.0.
