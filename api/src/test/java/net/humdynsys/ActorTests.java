package net.humdynsys;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
public class ActorTests {
    UUID testUUID = UUID.randomUUID();
    String firstname = "David";
    String lastname = "NonKlingon";
    String primaryEmail = "david.nonklingon@saasyfuss.co";
    String secondaryEmail = "david.vulcan@saasyfuss.co";
    Integer countryCode = 1;
    Long phone = 5611111000L;
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
    
    @Test
    public void create_newActor() {
        // Option of Actor
        Actor actualActor = assertActorAndGet();

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
        assertThat(actualActor.getContact().getPhone().getCountryCode()).isEqualTo(countryCode);
        assertThat(actualActor.getContact().getPhone().getSubscriberNumber()).isEqualTo(phone);
        // Subscription Level
        assertThat(Arrays.stream(SubscriptionLevel.values())
                .anyMatch(value -> value == actualActor.getSubscriptionLevel())).isTrue();
    }

    private Actor assertActorAndGet() {
        Optional<Actor> actorExists = Optional.ofNullable(actor.get());
        assertThat(actorExists).isNotNull();
        assertThat(actorExists.isPresent()).isTrue();

        return actorExists.get();
    }

    @Test
    public void willNotCreate_NullActor() {
        Supplier<Actor> actor = () -> Actor.builder()
                .build();
        assertThat(actor.get()).isNotNull();
        assertThat(actor.get().getUuid()).isNull();
        assertThat(actor.get().getName()).isNull();
        assertThat(actor.get().getContact()).isNull();
        assertThat(actor.get().getSubscriptionLevel()).isNull();
    }

    @Test
    public void verify_Actor_Phone() {
        // Option of Actor
        Actor actualActor = assertActorAndGet();
        final Long phoneUS =
                actualActor.getContact().getPhone().getSubscriberNumber();
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber usNumber = new Phonenumber.PhoneNumber();
        usNumber.setCountryCode(actualActor.getContact().getPhone().getCountryCode());
        usNumber.setNationalNumber(actualActor.getContact().getPhone().getSubscriberNumber());
        System.out.printf("verify_Actor_Phone: Mobile Number is: %s%n", usNumber);
        boolean isGoodNumber = phoneNumberUtil.isPossibleNumberForType(usNumber, PhoneNumberUtil.PhoneNumberType.MOBILE);
        assertThat(isGoodNumber).isTrue();
    }
}
