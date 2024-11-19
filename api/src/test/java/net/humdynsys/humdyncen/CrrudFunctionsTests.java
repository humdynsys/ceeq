package net.humdynsys.humdyncen;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CrrudFunctionsTests {

    String aFirstname = "F1234x";
    String aLastname = "N1212x001";
    String aPrimaryEmail = "FN12@example.com";
    Integer usCountryCode = 1;
    Long usPhone = 5610001111L;


    @Test
    void should_Create() {
        UUID uuid = UUID.randomUUID();
        Actor actorModel =
                Actor.builder()
                        .identifiedAs(
                                IdentifiedAs.builder()
                                        .uuid(uuid)
                                        .firstName(aFirstname)
                                        .lastName(aLastname)
                                        .primaryEmail(aPrimaryEmail)
                                        .secondaryEmail(null)
                                        .countryCode(usCountryCode)
                                        .subscriberNumber(usPhone)
                                        .build())
                        .build();

        assertThat(actorModel.identifiedAs().uuid()).isEqualTo(uuid);
        assertThat(actorModel.identifiedAs().firstName()).isEqualTo(aFirstname);
        assertThat(actorModel.identifiedAs().secondaryEmail()).isNull();
    }


}