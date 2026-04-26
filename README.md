## Lab 3

Work №3 for java course in HSE

Variant 15

## UML Class Diagrams

The diagrams below describe the main class hierarchies in the project.

### Confectionery model

```mermaid
flowchart TD
    ConfectioneryProduct --> Cake
    ConfectioneryProduct --> Cookie
    Cookie --> ChocolateCookie
```

```plantuml
@startuml
package "ru.hse.lab3.confectionery" {
    enum Shape {
        ROUND
        SQUARE
        STAR
        HEART
    }

    enum ChocolateType {
        DARK
        MILK
        WHITE
        BITTER
    }

    class ConfectioneryProduct {
        - String name
        - BigDecimal price
        + String getName()
        + BigDecimal getPrice()
        + String toString()
    }

    class Cake {
        - int layers
        + int getLayers()
    }

    class Cookie {
        - Shape shape
        + Shape getShape()
    }

    class ChocolateCookie {
        - ChocolateType chocolateType
        + ChocolateType getChocolateType()
    }

    ConfectioneryProduct <|-- Cake
    ConfectioneryProduct <|-- Cookie
    Cookie <|-- ChocolateCookie
}
@enduml
```

### Card/document model

```mermaid
flowchart TD
    IExportable --> Card
    Card --> Document
    Document --> Contract
```

```plantuml
@startuml
package "ru.hse.lab3.cards" {
    interface IExportable {
        + String getId()
        + LocalDateTime getCreationDate()
        + String getDigest()
        + String getContents()
    }

    enum DocumentStatus {
        DRAFT
        ACTIVE
        ARCHIVED
    }

    class Card {
        - UUID id
        - String title
        - String description
        - DocumentStatus status
        - LocalDateTime creationDate
        + String getId()
        + String getTitle()
        + void setTitle(String)
        + String getDescription()
        + void setDescription(String)
        + DocumentStatus getStatus()
        + void setStatus(DocumentStatus)
        + LocalDateTime getCreationDate()
        + String getFormattedCreationDate()
        + String getDigest()
        + String getContents()
    }

    IExportable <|.. Card
}

package "ru.hse.lab3.cards.documents" {
    class Document {
        - String registrationNumber
        - LocalDate registrationDate
        - String content
        + String getRegistrationNumber()
        + void setRegistrationNumber(String)
        + LocalDate getRegistrationDate()
        + void setRegistrationDate(LocalDate)
        + String getContent()
        + void setContent(String)
        + String getDigest()
        + String getContents()
    }

    class Contract {
        - LocalDate startDate
        - LocalDate endDate
        - String counterparty
        - BigDecimal amount
        + BigDecimal getAmount()
        + void setAmount(BigDecimal)
        + void setAmount(double)
        + LocalDate getStartDate()
        + void setStartDate(LocalDate)
        + LocalDate getEndDate()
        + void setEndDate(LocalDate)
        + String getCounterparty()
        + void setCounterparty(String)
        + boolean isActive()
        + long getDurationDays()
    }

    Card <|-- Document
    Document <|-- Contract
}
@enduml
```
