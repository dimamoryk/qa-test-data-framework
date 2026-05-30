package test_data;

public class TestData {

    // Поля класса (данные, которые хранит объект)
    String testName;
    int testId;
    boolean isSmoke;

    // КОНСТРУКТОР: Это метод, который создает объект.
    // Без него мы не можем инициализировать поля.
    public TestData(String testName, int testId, boolean isSmoke) {
        this.testName = testName;
        this.testId = testId;
        this.isSmoke = isSmoke;
    }


    // МЕТОД toString: Нужен, чтобы, когда мы печатаем объект в консоль,
    // он выводил имена полей, а непонятный код типа "TestData@2a139a55".
    public String toString() {
        return "TestData{" +
                "testName='" + testName + '\'' +
                ", testId=" + testId +
                ", isSmoke=" + isSmoke +
                '}';
    }
}
