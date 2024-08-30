package brainy.test.suite;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import brainy.test.activation.ReluTest;
import brainy.test.model.LayerTest;

@Suite
@SelectClasses({LayerTest.class, ReluTest.class})
public class TestSuite1 {

}
