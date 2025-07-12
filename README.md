# Java Calculator Application

A professional-grade calculator application built with Java, featuring both GUI and CLI interfaces, comprehensive testing, and modern software engineering practices.

## Features

### **Dual Interface Support**
- **Graphical User Interface (GUI)**: Modern JavaFX-based calculator with custom styling
- **Command Line Interface (CLI)**: Interactive terminal-based calculator
- **Keyboard Support**: Full keyboard input for enhanced user experience

### **Mathematical Operations**
- **Basic Arithmetic**: Addition, Subtraction, Multiplication, Division
- **Error Handling**: Division by zero protection with user-friendly error messages
- **Large Number Support**: Handles both very large and very small numbers

### **Architecture & Design**
- **Design Patterns**: Strategy Pattern for operations, Factory Pattern for object creation
- **Separation of Concerns**: Clean separation between UI, business logic, and data
- **Modular Design**: Easy to extend with new operations and features
- **Object-Oriented Principles**: Proper encapsulation, inheritance, and polymorphism

### **Testing & Quality**
- **Comprehensive Testing**: 69 unit tests with 100% coverage of core functionality
- **Test-Driven Development**: Professional testing practices with JUnit 5
- **Mocking**: JavaFX component testing with Mockito
- **Test Suites**: Organized test execution and reporting

## Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd CalculatorApp
   ```

2. **Run the GUI Application**
   ```bash
   mvn javafx:run
   ```

3. **Run the CLI Application**
   ```bash
   mvn exec:java -Dexec.mainClass="cli.CLIHome"
   ```

4. **Run All Tests**
   ```bash
   mvn test
   ```

## Project Structure

```
CalculatorApp/
├── src/
│   ├── main/java/
│   │   ├── cli/           # Command Line Interface
│   │   ├── engine/        # Core calculation engine
│   │   ├── gui/           # Graphical User Interface
│   │   └── operations/    # Mathematical operations
│   ├── main/resources/
│   │   └── gui/           # CSS styling and resources
│   └── test/java/         # Comprehensive test suite
├── pom.xml                # Maven configuration
├── TESTING.md             # Testing documentation
└── README.md              # This file
```

## Technology Stack

### **Core Technologies**
- **Java 17**: Primary programming language
- **JavaFX 17**: Modern GUI framework
- **Maven**: Build tool and dependency management

### **Testing Framework**
- **JUnit 5**: Unit testing framework
- **Mockito**: Mocking framework for testing
- **Maven Surefire**: Test execution and reporting

### **Design Patterns**
- **Strategy Pattern**: Polymorphic mathematical operations
- **Factory Pattern**: Dynamic operation creation
- **MVC Pattern**: Separation of UI, logic, and data

## Key Features Explained

### **Dual Interface Architecture**
The application supports both GUI and CLI interfaces, demonstrating:
- **Interface Abstraction**: Common business logic shared between interfaces
- **User Experience**: Different interaction models for different use cases
- **Code Reusability**: Core calculation engine used by both interfaces

### **Professional Testing**
```java
@Test
@DisplayName("Should handle division by zero")
void testDivideByZero() {
    ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
        division.calculate(5.0, 0.0);
    });
    assertEquals("Cannot divide by zero", exception.getMessage());
}
```

### **Design Pattern Implementation**
```java
// Strategy Pattern - Polymorphic operations
public interface Operation {
    double calculate(double firstNumber, double secondNumber);
}

// Factory Pattern - Dynamic operation creation
public class OperationsFactory {
    public static Operation getOperation(String operation) {
        // Returns appropriate operation based on symbol
    }
}
```

## Testing Coverage

The project includes comprehensive testing with 69 test cases covering:

- ✅ **Mathematical Operations**: All arithmetic operations with edge cases
- ✅ **Error Handling**: Division by zero, invalid inputs, null handling
- ✅ **User Interface**: Button clicks, keyboard input, state management
- ✅ **Integration**: Factory pattern, engine-operation integration
- ✅ **Edge Cases**: Large numbers, small numbers, decimal precision

### Running Tests
```bash
# Run all tests
mvn test

# Run specific test categories
mvn test -Dtest=AdditionTest
mvn test -Dtest=CalculatorEngineTest

# Run with detailed output
mvn test -Dsurefire.useFile=false
```

## Custom Styling

The GUI features custom CSS styling with:
- **Modern Design**: Gradient backgrounds, rounded corners, shadows
- **Interactive Elements**: Hover effects, button animations
- **Professional Appearance**: Consistent color scheme and typography
- **Responsive Feedback**: Visual feedback for user interactions

## 🔧 Build & Development

### **Maven Commands**
```bash
# Compile the project
mvn compile

# Run tests
mvn test

# Package the application
mvn package

# Clean and rebuild
mvn clean install
```

### **Development Workflow**
1. **Feature Development**: Add new operations or features
2. **Testing**: Write comprehensive tests for new functionality
3. **Code Review**: Ensure code quality and design pattern adherence
4. **Integration**: Test with both GUI and CLI interfaces

## Future Enhancements

### **Planned Features**
- [ ] Scientific calculator functions (trigonometry, logarithms)
- [ ] Unit conversion capabilities
- [ ] Calculation history and memory functions
- [ ] Web-based interface
- [ ] Database integration for calculation storage

### **Technical Improvements**
- [ ] Configuration management system
- [ ] Logging framework integration
- [ ] Performance optimization
- [ ] Internationalization support
- [ ] Plugin architecture for custom operations

## Contributing

This project demonstrates professional software development practices including:
- **Clean Code**: Readable, maintainable, and well-documented code
- **Design Patterns**: Industry-standard architectural patterns
- **Testing**: Comprehensive test coverage and quality assurance
- **Documentation**: Clear documentation and usage examples

## Learning Outcomes

This project showcases proficiency in:
- **Java Programming**: Advanced Java features and best practices
- **Object-Oriented Design**: SOLID principles and design patterns
- **GUI Development**: Modern JavaFX application development
- **Testing**: Professional testing methodologies and tools
- **Build Systems**: Maven dependency management and build automation
- **Software Architecture**: Modular, extensible application design

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

**Omar Mahmoud** - *Computer Scientist*

This calculator application represents my journey in learning professional software development practices, from basic programming concepts to advanced architectural patterns and comprehensive testing methodologies.

---

**Star this repository if you find it helpful!**