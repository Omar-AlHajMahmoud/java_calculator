# Calculator App Testing Guide

## Overview
This document explains how to run tests for the Calculator application and what each test covers.

## Test Structure
```
src/test/java/
├── operations/           # Tests for mathematical operations
│   ├── AdditionTest.java
│   ├── SubtractionTest.java
│   ├── MultiplicationTest.java
│   ├── DivisionTest.java
│   └── OperationsFactoryTest.java
├── engine/              # Tests for calculation engine
│   └── CalculatorEngineTest.java
├── gui/                 # Tests for GUI logic
│   └── CalculatorManagerTest.java
├── cli/                 # Tests for command-line interface
│   └── CLIHomeTest.java
└── CalculatorTestSuite.java  # Test suite runner
```

## How to Run Tests

### 1. Run All Tests
```bash
mvn test
```

### 2. Run Specific Test Class
```bash
# Run only addition tests
mvn test -Dtest=AdditionTest

# Run only calculator engine tests
mvn test -Dtest=CalculatorEngineTest
```

### 3. Run Test Suite
```bash
mvn test -Dtest=CalculatorTestSuite
```

### 4. Run Tests with Detailed Output
```bash
mvn test -Dtest=*Test -Dsurefire.useFile=false
```

## What Each Test Covers

### Operations Tests
- **AdditionTest**: Tests addition with positive, negative, decimal, and edge case numbers
- **SubtractionTest**: Tests subtraction with various number combinations
- **MultiplicationTest**: Tests multiplication including zero and one scenarios
- **DivisionTest**: Tests division including division by zero error handling
- **OperationsFactoryTest**: Tests factory pattern and unsupported operations

### Engine Tests
- **CalculatorEngineTest**: Tests the core calculation engine integration with operations

### GUI Tests
- **CalculatorManagerTest**: Tests GUI logic, state management, and user interactions
  - Button clicks (numbers, operators, clear, equals)
  - Keyboard input handling
  - Error handling (division by zero)
  - Consecutive operations

### CLI Tests
- **CLIHomeTest**: Tests command-line interface functionality
  - Input validation
  - Calculation logic
  - Error handling

## Test Coverage Areas

### ✅ Positive Test Cases
- Basic arithmetic operations
- Decimal number handling
- Large number calculations
- Negative number operations
- Zero and one edge cases

### ✅ Error Handling
- Division by zero
- Invalid operations
- Null input handling
- Unsupported operations

### ✅ User Interface
- Button click responses
- Keyboard input processing
- Display updates
- State management

### ✅ Integration
- Factory pattern functionality
- Engine-operation integration
- GUI-business logic interaction

## Test Best Practices Used

1. **Descriptive Test Names**: Each test method clearly describes what it tests
2. **@DisplayName**: Human-readable test descriptions
3. **@BeforeEach**: Proper test setup for each test method
4. **Edge Case Testing**: Tests boundary conditions and error scenarios
5. **Comprehensive Coverage**: Tests all public methods and scenarios
6. **Isolation**: Each test is independent and doesn't rely on other tests

## Expected Test Results

When all tests pass, you should see output like:
```
[INFO] Tests run: 45, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 45, Failures: 0, Errors: 0, Skipped: 0
```

## Troubleshooting

### Common Issues

1. **JavaFX Testing Issues**: Make sure `javafx-swing` dependency is included
2. **Test Discovery**: Ensure test classes end with `Test.java`
3. **Package Structure**: Verify test packages match main package structure

### Debugging Failed Tests
```bash
# Run with debug output
mvn test -X

# Run specific failing test
mvn test -Dtest=SpecificTest#specificMethod
```

## Adding New Tests

When adding new features, follow these guidelines:

1. Create test class in appropriate package
2. Use descriptive test method names
3. Test both success and failure scenarios
4. Include edge cases and boundary conditions
5. Update this documentation

## Continuous Integration

These tests are designed to run in CI/CD pipelines:
- Fast execution (< 30 seconds)
- No external dependencies
- Deterministic results
- Comprehensive coverage 