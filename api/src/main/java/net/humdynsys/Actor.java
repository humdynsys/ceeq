package net.humdynsys;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Actor {
    private UUID uuid;
    private Name name;
    private Contact contact;
    private SubscriptionLevel subscriptionLevel;
}
