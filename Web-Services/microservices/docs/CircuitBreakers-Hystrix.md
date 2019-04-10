# Circuit Breakers - Hystrix
* Are used to detect failures and prevent them from constantly recurring.

* Circuit Breakers utilize Defensive Programming practices to defend application and network resources

## How they work
* Circuit breaker object monitors for failures and trips when they occur. 

* This will prevent cascade errors across multiple systems which can drain critical resources.

## Hystrix
* A circuit breaker module developed by *Netflix* in 2011.

* The Netflix API processes 10+ billion Hystrix Command executions per day using thread isolation.


## Hystrix and Defensive Programming:
* **Timeout** - Hystrix does not wait longer than the configured timeout for a response.

* **Limited Thread Pool** – a thread pool prevents threads from being exhausted. 

* **Circuit Breaker Pattern** 

    CircuitBreakerRequestVolumeThreshold # of fails before tripping

	CircuitBreakerSleepWindow 4,000ms by default – time after which the request to the remote service will be               
        resumed. Gives time for app to recover.

## Fallbacks
* Use fallbacks when failures occur to keep app running

* Provide fallback logic with HystrixCommand.getFallback() which returns a single fallback value.

## HystrixCommand in Java
     java.lang.Object
      com.netflix.hystrix.HystrixCommand<R>

Dependencies:
```xml
<dependency>   
   <groupId>com.netflix.hystrix</groupId>
   <artifactId>hystrix-core</artifactId>
   <version>1.5.4</version>
</dependency>

<dependency>
   <groupId>com.netflix.rxjava</groupId>
   <artifactId>rxjava-core</artifactId>
   <version>0.20.7</version>
</dependency>
```
## Hello World Example:

```java
public class CommandHelloWorld extends HystrixCommand<String> {

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        // a real example would do work like a network call here
        return "Hello " + name + "!";
    }
}
```


