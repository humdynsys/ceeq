package net.humdynsys.humdyncen;

import lombok.Builder;

import java.util.UUID;

@Builder
public record IdentifiedAs(
    UUID uuid,
    String firstName,
    String lastName,
    String primaryEmail,
    String secondaryEmail,
    Integer countryCode,
    Long subscriberNumber)
{}
