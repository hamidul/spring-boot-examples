# Graphql Demo Using Spring Boot
This demo project demonstrates the capability of graphql and how to integrate it with spring boot. 

After starting the application access the bellow 
- To post query : localhost:8080/graphql 
- To access graphiql : http://localhost:8080/graphiql
To access the browser based H2 console 
http://localhost:8080/h2-console 
# Note 1:
When the application starts it inserts sample data in the Book table. 
```java
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book(null, "Book Title 1", "Author 1"));
            repository.save(new Book(null, "Book Title 2", "Author 2"));
        };
    }
}
```
# Note 2:
**schema.graphqls** This file is used to define the structure of your GraphQL API. This is known as GraphQL schema definition file. The content looks like below 
```json
type Query {
    hello: String
    books: [Book]
}
type Book {
    id: ID!
    title: String!
    author: String!
}
```


# Sample Queries 
## Query 1
```json
{
  hello
  books {
    id
    title
    author
  }
}
```
## Query 2
```json
fragment BookFields on Book {
  id
  title
  author
}
{
  hello
  books {
    ...BookFields
  }
}
```
