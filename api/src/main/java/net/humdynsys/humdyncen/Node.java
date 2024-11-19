package net.humdynsys.humdyncen;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Node(
    UUID uuid,
    String name,
    String topic,
    String payload,
    PayloadTypeAs payloadTypeAs)
{}
