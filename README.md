
# Gift Basket Ordering System

## Introduction
This repository contains a Java program for creating and managing orders for gift baskets, specifically fruit baskets and sweets baskets. The program utilizes inheritance and encapsulation principles, with a parent class `Gift` and two child classes `FruitBasket` and `SweetsBasket`. Users can create, modify, and display orders through a menu-driven interface.

## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Dependencies](#dependencies)
- [Configuration](#configuration)
- [Examples](#examples)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

## Installation
To run this application, ensure you have Java installed on your machine. You can download Java from the [official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Steps to Install:
1. Clone the repository:
    ```sh
    git clone https://github.com/Khakipapi/Inheritance-and-Encapsulation.git
    ```
2. Navigate to the project directory:
    ```sh
    cd gift-basket-ordering-system
    ```
3. Compile the Java program:
    ```sh
    javac CMIS242ASG2ReyesJ.java
    ```

## Usage
To run the program, use the following command:
```sh
java CMIS242ASG2ReyesJ
```

### Menu Options
1. **Order A Gift Basket**: Create a new order for a fruit basket or a sweets basket.
2. **Change Gift Basket**: Modify an existing order.
3. **Display Gift Basket**: Display details of a specific order.
4. **Display all Gift Baskets**: Display details of all orders.
5. **Exit Program**: Terminate the program.

## Features
- **Inheritance and Encapsulation**: Utilizes a parent class `Gift` and child classes `FruitBasket` and `SweetsBasket`.
- **User Interaction**: Menu-driven interface for ordering, changing, and displaying gift baskets.
- **Validation**: Ensures valid input for order number, size, and additional options.

## Dependencies
- Java Development Kit (JDK) 11 or later

## Configuration
No specific configuration is needed for this application. Ensure you have the required dependencies installed.

## Examples

### Running the Application
```sh
java CMIS242ASG2ReyesJ
```
Example interaction:
```
    Menu
1: Order A Gift Basket
2: Change Gift Basket
3: Display Gift Basket
4: Display all Gift Baskets
9: Exit program
Enter your selection: 1
Do you want a Fruit Basket(1) or Sweets Basket(2): 1
Create order number [FB or SB for type of gift and three integers]: FB123
What Size do you want: S, M, L: M
Do you want citrus included? 1 for yes 2 for no: 1
Your order has been added
```

## Troubleshooting
- Ensure Java is installed and the `javac` and `java` commands are available in your system's PATH.
- Verify the correct format for order numbers and other inputs as prompted by the program.

## Contributors
- **Jose Reyes** - Initial work

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
