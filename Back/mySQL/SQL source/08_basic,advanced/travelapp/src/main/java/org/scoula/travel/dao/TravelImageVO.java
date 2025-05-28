package org.scoula.travel.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravelImageVO {
    private long no;
    private String filename;
    private long travelNo;
}
