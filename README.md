# Android-IFx

This library for Android provides `if-expression` like Scala.  
`IFx` enabled Java if-statement to return value.  
Strongly inspired by [jshosomichi/ifx](https://github.com/jshosomichi/ifx).  

# How to Use

```java
/** returns primitive value pattern **/
// if ~ else if ~ else
String result = IFx.<String>of(false).apply("hoge")
        .ElseIf(false).apply("foo")
        .Else("bar");
assert result == "bar";

// if ~ else if ~
String result2 = IFx.<String>of(true).apply("hoge")
                .ElseIf(false).apply("foo").get();
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
        return "bar";
    }
});

assert result4 == "foo";
```

# Lisence

This code is licensed under the Apache Software License 2.0.
