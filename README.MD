## Functional-style if/else and switch/case tools for java

### Examples:

#### Plain java:
```java
String result = null;
if (condition) {
    result = "A";
} else {
    result = "B";
}
```
#### Using Condition Tools:
```java
String result = ConditionTools.when(condition)
        .then(() -> "A")
        .otherwise(() -> "B")
        .get();
```
#### Plain java:
```java
String result = null;
switch (code) {
case 200:
    result = "Ok";
    break;
case 404:
    result = "Not found";
    break;
default:
    result = "Error";
}
```

#### Using Condition Tools:
```java
var result = ConditionTools.<Integer, String>inCase(code)
                           .when(n -> n == 200).then(n -> "Ok")
                           .when(n -> n == 404).then(n -> "Not found")
                           .otherwise(n -> "Error")
                           .get();
```