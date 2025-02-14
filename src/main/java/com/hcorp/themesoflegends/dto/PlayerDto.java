package com.hcorp.themesoflegends.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlayerDto {
    private String name;
    private int score;
    private int combo;
    private String mastery;
}
