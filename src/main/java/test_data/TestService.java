package test_data;

import java.util.ArrayList;
import java.util.List;

public class TestService {

    public List<TestData> filterSmokeTests(List<TestData> allTests) {
        List<TestData> result = new ArrayList<>();
        for (TestData t : allTests) {
            if (t.isSmoke) result.add(t);
        }
        return result;
    }

    public List<TestData> filterNoSmokeTests(List<TestData> allTests) {
        List<TestData> result = new ArrayList<>();
        for (TestData t : allTests) {
            if (!t.isSmoke) result.add(t);
        }
        return result;
    }

    public List<TestData> filterByNameContaining(List<TestData> allTests, String substring) {
        List<TestData> result = new ArrayList<>();
        for (TestData t : allTests) {
            if (t.testName.contains(substring)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<TestData> filterByTestIdGreaterThan(List<TestData> allTests, int minId) {
        List<TestData> result = new ArrayList<>();
        for (TestData t : allTests) {
            if (t.testId >= minId) result.add(t);
        }
        return result;
    }
}