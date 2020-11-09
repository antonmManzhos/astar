package com.astar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dot {
    private int heuristicValue;
    private int pathLengthFromStartingPoint;
    private int previousCellX;
    private int previousCellY;
    private int x;
    private int y;
}
