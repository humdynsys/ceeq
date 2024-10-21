package net.humdynsys;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
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
        String firstname = "David";
        String lastname = "NonKlingon";
        String primaryEmail = "david.nonklingon@saasyfuss.co";
        String secondaryEmail = "david.vulcan@saasyfuss.co";
        String countryCode = "+1";
        String phone = "561-111-1000";
        Supplier<Actor> actor = () -> Actor.builder()
                .uuid(testUUID)
                .name(Name.builder().firstName(firstname).lastName(lastname).build())
                .contact(Contact.builder()
                        .email(Email.builder()
                                .primary(primaryEmail)
                                .secondary(secondaryEmail)
                                .build())
                        .phone(Phone.builder()
                                .countryCode(countryCode)
                                .subscriberNumber(phone).build())
                        .build())
                .subscriptionLevel(SubscriptionLevel.FREE)
                .build();

        // Option of Actor
        Optional<Actor> actorExists = Optional.ofNullable(actor.get());
        assertThat(actorExists).isNotNull();
        assertThat(actorExists.isPresent()).isTrue();

        Actor actualActor = actorExists.get();
        // UUID
        assertThat(actualActor.getUuid())
                .isNotNull()
                .isEqualByComparingTo(testUUID);
        // Name
        assertThat(actualActor.getName()).isNotNull();
        assertThat(actualActor.getName().getFirstName()).isNotNull().isEqualToIgnoringCase(firstname);
        assertThat(actualActor.getName().getLastName()).isNotNull().isEqualToIgnoringCase(lastname);
        // Contact
        assertThat(actualActor.getContact()).isNotNull();
        // Email
        assertThat(actualActor.getContact().getEmail()).isNotNull();
        assertThat(actualActor.getContact().getEmail().getPrimary()).isEqualToIgnoringCase(primaryEmail);
        assertThat(actualActor.getContact().getEmail().getSecondary()).isEqualToIgnoringCase(secondaryEmail);
        // Phone
        assertThat(actualActor.getContact().getPhone()).isNotNull();
        assertThat(actualActor.getContact().getPhone().getCountryCode()).isEqualToIgnoringCase(countryCode);
        assertThat(actualActor.getContact().getPhone().getSubscriberNumber()).isEqualToIgnoringCase(phone);
        // Subscription Level
        assertThat(Arrays.stream(SubscriptionLevel.values()).anyMatch(value -> value == actualActor.getSubscriptionLevel())).isTrue();
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
