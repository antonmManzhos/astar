package com.astar.service;

import com.astar.model.Dot;
import org.springframework.stereotype.Service;

@Service
public class ManhattanHeuristicService implements HeuristicValue {

    @Override
    public int calculateHeuristicValue(Dot newCell, Dot endCell) {
        return (Math.abs(newCell.getX() - endCell.getX()) + Math.abs(newCell.getY() - endCell.getY()));
    }
}
