# Database
The database will be start up with the compose.yaml file

## Get into db shell to execute sql
docker exec -it <container_name> bash

## Get all tables in db
psql -U postgres -d modulith -c "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';"

## Get user_details stuff
psql -U postgres -d modulith -c "SELECT * FROM user_details"

## Get directly into monolith db shell (the shell has autocomplete with tab)
psql -U postgres -d modulith
\d then shows all tables
select * from event_publication;
q closes the sql result to go back.

select event_type, publication_date, completion_date from event_publication;

delete from event_publication; clears the table without dropping the table.

# See which tables are generated
psql -U postgres -d modulith -c "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';"
The modulith event system should create the event_publication table

Contains event id, publication date, event_type, dates etc, payload. When it has no completion date it will do a retry.
In a modulith, the event_publication table is usually stored in a shared database

# Event Process
The Event process is using the Observer pattern with basically an event bus, but with event persistence and retry mechanism.

1. Event Publication: When an event is published, it is stored in the event_publication table.
The event is dispatched to all registered @EventListener methods.

2. Event Handling: All @EventListener methods that listen to the event are invoked. 
The event handler processes the event and updates the event_publication table with the completion date.
    
3. Spring checks that all listeners have completed processing the event.

4. Retry Mechanism: On application restart, Spring Modulith checks the event_publication table for events without a completion date and republishes them.

# Benefits

## Event Sourcing: 
The event_publication table can be used to replay events to get the state of an entity at a certain point in time.
This means if you would have the chain of events and play them after eachother, you would get the same state back.
This makes it possible to replay events to get the state of an entity at a certain point in time and makes retries easier if someething fails.

## Decoupling
You can make all services independent from each-other and make them private, services don't need to depend on eachother anymore, since the message broker handles the communication.
### CQRS: Command Query Responsibility Segregation
Having a separate read and write model, the write model is the event store and the read model is the database.

# Transactional Event Handling
@TransactionalEventListener is used to ensure that the event handling is transactional.

```java
@TransactionalEventListener
@Transactional(propagation = Propagation.REQUIRES_NEW)  // needed to do DB work in a new transaction
// action
public void myMethod(String customerId) {
final Customer customer = customerJpaRepository.findById(customerId).get();
customer.setFoo("bar");
    customerJpaRepository.save(customer);
}
```



# Event Externalization: for example use RabbitMQ or Kafka instead of the Spring Application Event Bus.
spring.modulith.events.externalization.enabled=true 


# Event Handling
## Async Event Listeners run in a different thread.
