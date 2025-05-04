@startuml
abstract class Vehicle {
  - noPolice : String
  - vehicleType : String
  - year : int
  - price : double
  - taxPerYear : double
  - seat : int

  + getTotalTax(): double
  + calculateDepreciation(): double
}

class SUV {
}

class Taxi {
}

class PrivateJet {
}

class Boat {
}

class Income {
  - transactionDate : Date
  - rent : double
  - orderPerHours : double
  - driver : double
  - order : double
  - orderPerKM : double
  - total : double

  + calculateTotal(): double
}

Vehicle <|-- SUV
Vehicle <|-- Taxi
Vehicle <|-- PrivateJet
Vehicle <|-- Boat
Vehicle "1" o-- "1" Income

@enduml
