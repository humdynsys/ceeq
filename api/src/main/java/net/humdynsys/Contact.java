package net.humdynsys;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Contact {
    private Email email;
    private Phone phone;
}
