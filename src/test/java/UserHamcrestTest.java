import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.User;

import java.util.Scanner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserHamcrestTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    public void addDeal_validTask_taskAdded() {
        // given
        Scanner scanner = new Scanner("Купить молоко\n");

        // when
        user.addDeal(scanner);

        // then
        assertThat(user.getList(), hasSize(1));
        assertThat(user.getList().get(0), equalTo("Купить молоко"));
    }

    @Test
    public void addDeal_emptyTask_taskNotAdded() {
        // given
        Scanner scanner = new Scanner("\n");

        // when
        user.addDeal(scanner);

        // then
        assertThat(user.getList(), empty());
    }

    @Test
    public void removeDealByNumber_validNumber_taskRemoved() {
        // given
        user.getList().add("Задача 1");
        user.getList().add("Задача 2");
        Scanner scanner = new Scanner("1\n");

        // when
        user.removeDealByNumber(scanner);

        // then
        assertThat(user.getList(), hasSize(1));
        assertThat(user.getList(), contains("Задача 2"));
    }

    @Test
    public void removeDealByName_existingTask_taskRemoved() {
        // given
        user.getList().add("Прогулка");
        user.getList().add("Уборка");
        Scanner scanner = new Scanner("Уборка\n");

        // when
        user.removeDealByName(scanner);

        // then
        assertThat(user.getList(), hasSize(1));
        assertThat(user.getList(), contains("Прогулка"));
    }

    @Test
    public void removeDealByName_removedTask_notInList() {
        // given
        user.getList().add("Сон");
        user.getList().add("Учёба");
        Scanner scanner = new Scanner("Сон\n");

        // when
        user.removeDealByName(scanner);

        // then
        assertThat(user.getList(), not(contains("Сон")));
    }

    @Test
    public void addDeal_taskWithNumbers_validFormat() {
        // given
        Scanner scanner = new Scanner("Задача №123\n");

        // when
        user.addDeal(scanner);

        // then
        String task = user.getList().get(0);
        assertThat(task, matchesPattern("Задача №\\d+"));
    }

    @Test
    public void listAfterAdd_hasExpectedProperties() {
        // given
        Scanner scanner = new Scanner("Погулять\n");

        // when
        user.addDeal(scanner);

        // then
        assertThat(user.getList(), contains(anyOf(equalTo("Погулять"), equalTo("погулять"))));
    }
}
