package net.humdynsys;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class ActorTests {

    @Test
    public void create_newActor() {
        UUID testUUID = UUID.randomUUID();
        String expectedUsername = "davidking";
        Supplier<Actor> actor = () -> Actor.builder()
                .uuid(testUUID)
                .name("davidking")
                .build();
        Optional<Actor> actorExists = Optional.ofNullable(actor.get());

        assertThat(actorExists).isNotNull();
        assertThat(actorExists.isPresent()).isTrue();

        Actor actualActor = actorExists.get();
        assertThat(actualActor.getUuid())
                .isNotNull()
                .isEqualByComparingTo(testUUID);
        assertThat(actualActor.getName()).isNotNull().isEqualToIgnoringCase(expectedUsername);
    }

    @Test
    public void willNotCreate_NullActor() {
        Supplier<Actor> actor = () -> Actor.builder()
                .build();
        assertThat(actor.get()).isNotNull();
        assertThat(actor.get().getUuid()).isNull();
        assertThat(actor.get().getName()).isNull();
    }
}
