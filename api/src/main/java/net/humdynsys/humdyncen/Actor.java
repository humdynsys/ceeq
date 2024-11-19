package net.humdynsys.humdyncen;


import lombok.Builder;

@Builder
public record Actor(
    IdentifiedAs identifiedAs,
    Node node)
{}
