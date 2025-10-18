

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import ru.netology.User;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    @DisplayName("Добавление задачи: корректное название → задача добавлена")
    public void addDeal_validTask_taskAdded() {
        // given:
        String input = "Купить молоко";
        Scanner scanner = new Scanner(input);

        // when:
        user.addDeal(scanner);

        // then:
        assertEquals(1, user.getList().size());
        assertEquals("Купить молоко", user.getList().get(0));
    }

    @Test
    @DisplayName("Добавление задачи: пустое название → задача не добавлена")
    public void addDeal_emptyTask_taskNotAdded() {
        // given:
        String input = "";
        Scanner scanner = new Scanner(input);

        // when:
        user.addDeal(scanner);

        // then:
        assertTrue(user.getList().isEmpty());
    }

    @Test
    @DisplayName("Удаление по номеру: корректный номер → задача удалена")
    public void removeDealByNumber_validNumber_taskRemoved() {
        // given:
        user.getList().add("Задача 1");
        user.getList().add("Задача 2");
        String input = "1";
        Scanner scanner = new Scanner(input);

        // when:
        user.removeDealByNumber(scanner);

        // then:
        assertEquals(1, user.getList().size());
        assertEquals("Задача 2", user.getList().get(0));
    }

    @Test
    @DisplayName("Удаление по номеру: некорректный номер → список не изменился")
    public void removeDealByNumber_invalidNumber_listUnchanged() {
        // given:
        user.getList().add("Задача 1");
        String input = "5";
        Scanner scanner = new Scanner(input);

        // when:
        user.removeDealByNumber(scanner);

        // then:
        assertEquals(1, user.getList().size());
        assertEquals("Задача 1", user.getList().get(0));
    }

    @Test
    @DisplayName("Удаление по названию: задача существует → удалена")
    public void removeDealByName_existingTask_taskRemoved() {
        // given:
        user.getList().add("Прогулка");
        user.getList().add("Уборка");
        String input = "Уборка";
        Scanner scanner = new Scanner(input);

        // when:
        user.removeDealByName(scanner);

        // then:
        assertEquals(1, user.getList().size());
        assertEquals("Прогулка", user.getList().get(0));
    }

    @Test
    @DisplayName("Удаление по названию: задача не существует → список не изменился")
    public void removeDealByName_nonExistingTask_listUnchanged() {
        // given:
        user.getList().add("Прогулка");
        String input = "Сон";
        Scanner scanner = new Scanner(input);

        // when:
        user.removeDealByName(scanner);

        // then:
        assertEquals(1, user.getList().size());
        assertEquals("Прогулка", user.getList().get(0));
    }

    @Test
    @DisplayName("Удаление по названию: регистронезависимое сравнение")
    public void removeDealByName_caseInsensitive_taskRemoved() {
        // given:
        user.getList().add("ПРОГУЛКА");
        String input = "прогулка";
        Scanner scanner = new Scanner(input);

        // when:
        user.removeDealByName(scanner);

        // then:
        assertTrue(user.getList().isEmpty());
    }
}
