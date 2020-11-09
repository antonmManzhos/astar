package com.astar.service;

import com.astar.model.Dot;

public class ManhattanHeuristicService {

    public int manhattanHeuristic(Dot newNode, Dot end)
    {
        return (Math.abs(newNode.getX() - end.getX()) + Math.abs(newNode.getY() - end.getY())) * 10;
    }
}
