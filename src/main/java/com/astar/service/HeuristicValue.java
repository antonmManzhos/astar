package com.astar.service;

import com.astar.model.Dot;

public interface HeuristicValue {
    int calculateHeuristicValue(Dot newCell, Dot endCell);
}
