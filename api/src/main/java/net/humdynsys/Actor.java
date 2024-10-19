package net.humdynsys;

import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class Actor {
    @Id
    private UUID uuid;
    private String name;

}
