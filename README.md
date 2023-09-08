# Condo management

This is a sample project for condo management. The product provides the following features:

- condo registration
- condo manager registration that will be in charge of condos
- condo manager associations with condos
- buildings registration in a condo that will be allowed only for it manager

## Tech stack

- Kotlin 1.9
- Gradle 8 (Kotlin DSL)
- SpringBoot 3.1
- JUnit
- MockK

# Design

The code was created over DDD, Clean Architecture concepts along with Port/Adapters
to achieve the domain decoupling from the rest of the application.

The packages structure is

```
data
  - condo
  - condomanager
domain
  - common
  - condo
    - dto
    - port
      - input
      - output    
  - condomanager
    - dto
    - port
      - input
      - output
```

The domain package contains the aggregate roots, entities, value objects,
business exceptions, domain services, application services and input/output ports.

There was added two ways for _application services_ definition. Condo aggregation define 
just as an input adapter using a service class. 
CondoManager, in turns, splits the usecases that are called by a service class.

## Pending
- rest api definition
- database integration
- docker compose
- new features

