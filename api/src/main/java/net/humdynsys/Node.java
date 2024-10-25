package net.humdynsys;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Node {
    private UUID uuid;
    private String name;
    private String payload;
    private Instant ts;
}
