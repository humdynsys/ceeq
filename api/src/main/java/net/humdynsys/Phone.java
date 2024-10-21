package net.humdynsys;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Phone {
    @Length(min=1, max=3)
    private String countryCode;
    @Length(min=7, max=12)
    private String subscriberNumber;
}
