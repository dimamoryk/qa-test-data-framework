package test_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String... args) {
        List<TestData> allTests = new ArrayList<>();
        allTests.add(new TestData("Login", 1, true));
        allTests.add(new TestData("Profile", 2, false));
        allTests.add(new TestData("Purchase", 3, true));
        allTests.add(new TestData("Logout", 4, false));

        TestService testService = new TestService();

        // Фильтрация по Smoke
        List<TestData> smokeTests = testService.filterSmokeTests(allTests);
        System.out.println("--- Smoke тесты ---");
        for (TestData td : smokeTests) {
            System.out.println(td);
        }

        // Фильтрация по НЕ Smoke
        List<TestData> nonSmokeTests = testService.filterNoSmokeTests(allTests);
        System.out.println("\n--- Не Smoke тесты ---");
        for (TestData td : nonSmokeTests) {
            System.out.println(td);
        }

        // Фильтрация по ID
        int searchId = 3;
        List<TestData> idMin = testService.filterByTestIdGreaterThan(allTests, searchId);
        System.out.println("\n--- Тесты, ID больше " + searchId + " ---");
        for (TestData td : idMin) {
            System.out.println(td);
        }

        // Фильтрация по имени
        String searchName = "Login";
        List<TestData> nameTest = testService.filterByNameContaining(allTests, searchName);
        System.out.println("\n--- Тесты, имя содержит '" + searchName + "' ---");
        for (TestData td : nameTest) {
            System.out.println(td);
        }
        Map<Integer, String> idToNameMap = testService.getSmokeTestIdsAndNames(allTests);
        System.out.println("--- Smoke тесты (ID -> Имя) ---");
        idToNameMap.forEach((id, name) ->System.out.println("ID: " + id + ", Имя: " + name));

        System.out.println("\n--- Smoke тесты, отсортированные по ID ---");
        testService.getSmokeTestsSortedById(allTests).forEach(System.out::println);

        System.out.println("\n--- Только имена тестов, содержащие 'Log' ---");
        testService.getFilteredTestNames(allTests, "Log").forEach(System.out::println);
    }
}