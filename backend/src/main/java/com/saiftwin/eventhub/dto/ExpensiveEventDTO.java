package com.saiftwin.eventhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensiveEventDTO {
    private String title;
    private Double finalPrice;
}
