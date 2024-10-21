package net.humdynsys;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Contact {
    private String email;
    private String phone;
}
