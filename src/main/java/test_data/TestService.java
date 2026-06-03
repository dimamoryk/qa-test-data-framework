package test_data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestService {

    public List<TestData> filterSmokeTests(List<TestData> allTests) {
        // 1. Превращаем список в поток данных (Stream)
        return allTests.stream()
                // 2. Фильтруем. Лямбда-выражение оставляет только те объекты t, у которых t.isSmoke == true
                .filter(t -> t.isSmoke)
                // Сортировка по ID
                .sorted(Comparator.comparingInt(t -> t.testId))
                // 3. Собираем отфильтрованные объекты обратно в новый список
                .collect(Collectors.toList());
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
        return allTests.stream()
                .filter(t -> t.testId >= minId)
                .collect(Collectors.toList());
    }

    public List<String> getFilteredTestNames(List<TestData> allTests, String substring) {
        return allTests.stream()
                .filter(t -> t.testName.contains(substring))
                .map(t -> t.testName)
                .collect(Collectors.toList());
    }

    public List<TestData> getSmokeTestsSortedById(List<TestData> allTests) {
        return allTests.stream()
                .filter(t -> t.isSmoke)
                .sorted(Comparator.comparingInt(t -> t.testId))
                .collect(Collectors.toList());
    }

    public Map<Integer, String> getSmokeTestIdsAndNames(List<TestData> allTests) {
        return allTests.stream()
                .filter(t -> t.isSmoke)
                .collect(Collectors.toMap(t -> t.testId, t -> t.testName));
    }
}