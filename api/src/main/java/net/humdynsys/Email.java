package net.humdynsys;

import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Email {
    @jakarta.validation.constraints.Email
    private String primary;
    @jakarta.validation.constraints.Email
    private String secondary;
}
