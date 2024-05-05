# Java The complete reference twelfth edition - Comprehensive coverage of the Java language

This book gives me a deep overview of Java language and it evolution

I will put some book code and highlights in this repository


# Java memory model

How is Java executed ?

Java > Javac > JVM > processor

Java memory model is what values can be observed upon reading from a specific field.

Example:

```java
class SingleThreaded {
    int foo = 0;

    void method() {
        // PROGRAM ORDER
        foo = 1; // WRITE ACTION
        assert foo == 1; // READ ACTION
    }
}
```

## Java memory model building-blocks

| field-scoped    | method-scoped                   |
|-----------------|---------------------------------|
| final           | synchronized (method / block)   |
| volatile        | java.util.concurrent.locks.Lock |

why do we need volatile ?

look this example:

```java
public class DataRace {
    boolean ready = false;
    int answer = 0;

    void thread1() {
        while (!ready);
        assert answer == 42;
    }

    void thread2() {
        answer = 42;
        ready = true;
    }
}
```

as we know, `assert answer == 42;` will not be executed, because `ready` can be on the cache, and will not affect the thread1.

but now, to avoid this problem:

```java
public class DataRace {
    volatile boolean ready = false;
    int answer = 0;

    void thread1() {
        while (!ready);
        assert answer == 42;
    }

    void thread2() {
        answer = 42;
        ready = true;
    }
}
```

volatile field semantics: reorder restrictions

will execute:

answer = 42;

ready = true;

then

while (!ready);

assert answer == 42;


When a thread writes to a volatile variable, all of its previous writes are guarantted to be visible to another thread when that thread is reading the same value.

see `DataRace.java` to see it's happening.

```bash
java-memory-model git:(master) ✗ cd java-memory-model 
java-memory-model git:(master) ✗ javac DataRace.java 
➜  java-memory-model git:(master) ✗ java DataRace
Thread 2: Set answer to 42 and ready to true
Thread 1: Answer read as 42
```

in the second example `DataRaceSincronized`

You can guarantee the data updated, but it's sequentially, and will create a deadlock. 

we can solve this problem with wait and notifyAll as you can see:

```bash
➜  java-memory-model git:(master) ✗ javac DataRaceSynchronizedSolved.java 
➜  java-memory-model git:(master) ✗ java DataRaceSynchronizedSolved 
Thread 2: Set answer to 42 and ready to true
Thread 1: Answer read as 42
```

# References

[Java: The Complete Reference: 12th Edition](https://www.fnac.pt/Java-the-complete-reference-twelf/a9591534)

[The Java memory model explained](https://www.youtube.com/watch?v=qADk_tj4wY8)
