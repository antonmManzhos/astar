package com.astar.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Repository
public class Dot {
    private int heuristicValue;
    private int pathLengthFromStartCell;
    private int previousCellX;
    private int previousCellY;
    private int x;
    private int y;
    private int weightCell;
}
