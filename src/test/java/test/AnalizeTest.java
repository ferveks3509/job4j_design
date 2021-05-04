package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void diff() {
        Analize analize = new Analize();
        Analize.User user1 = new Analize.User();
        user1.id = 1;
        user1.name = "one";
        Analize.User user2 = new Analize.User();
        user2.id = 2;
        user2.name = "two";
        Analize.User user3 = new Analize.User();
        user3.id = 3;
        user3.name = "three";
        Analize.User userCn = new Analize.User();
        userCn.id = 1;
        userCn.name = "zero";

        Analize.Info info = analize.diff(
                List.of(user1, user2),
                List.of(userCn, user3)
        );
        assertThat(info.added, is(1));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
    }
}