package net.humdynsys;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Name {
    private String firstName;
    private String lastName;
}
