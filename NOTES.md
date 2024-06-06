# How @Qualifier is used? 
**Ans:**\
The **@Qualifier** annotation in Spring Boot is used to disambiguate between multiple beans of the same type when using dependency injection with **@Autowired**.\
**Scenario:**\
Imagine you have two implementations of an interface **Formatter**, let's say **JsonFormatter** and **XmlFormatter**. Both are managed by Spring as beans. Now, in another class **(DataProcessor)**, you want to inject one of these formatters but Spring can't decide which one to inject because both have the same type **(Formatter)**.\
**Qualifier on Bean Definitions:** 
```
//Annotate each formatter implementation class with @Component (or another bean definition annotation) and provide a unique qualifier value using @Qualifier:
@Component
@Qualifier("json")
public class JsonFormatter implements Formatter {
    // ... implementation
}

@Component
@Qualifier("xml")
public class XmlFormatter implements Formatter {
    // ... implementation
}
```
**Qualifier on Injection Point:**
```
//In the DataProcessor class, use @Autowired to inject the desired formatter and specify the qualifier value:
public class DataProcessor {

    @Autowired
    @Qualifier("json") // Inject JsonFormatter bean
    private Formatter formatter;

    public void processData(String data) {
        formatter.format(data);
    }
}
```
---
