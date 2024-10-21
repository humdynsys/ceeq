package net.humdynsys;

import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Actor {
    @Id
    private UUID uuid;
    private Name name;
    private Contact contact;
    private SubscriptionLevel subscriptionLevel;
}
