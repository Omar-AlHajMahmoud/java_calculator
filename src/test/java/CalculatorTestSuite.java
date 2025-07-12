import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

/**
 * Test suite for the entire Calculator application.
 * Runs all test classes to ensure comprehensive coverage.
 */
@Suite
@SuiteDisplayName("Calculator Test Suite")
@SelectClasses({
    operations.AdditionTest.class,
    operations.SubtractionTest.class,
    operations.MultiplicationTest.class,
    operations.DivisionTest.class,
    operations.OperationsFactoryTest.class,
    engine.CalculatorEngineTest.class,
    gui.CalculatorManagerTest.class,
    cli.CLIHomeTest.class
})
public class CalculatorTestSuite {
    // This class serves as a test suite container
    // All tests are automatically discovered and run
} 