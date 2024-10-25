package net.humdynsys;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Phone {
    private @Length(min = 1, max = 3) Integer countryCode;
    private @Length(min = 7, max = 12) Long subscriberNumber;
}
