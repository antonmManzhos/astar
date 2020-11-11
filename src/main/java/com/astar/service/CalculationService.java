package com.astar.service;

import com.astar.model.Dot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculationService {

    final int STEP = 10;
    final int STEP_SIDEWAYS = 14;

    private final HeuristicValue manhattanHeuristicService;

    public CalculationService(HeuristicValue manhattanHeuristicService) {
        this.manhattanHeuristicService = manhattanHeuristicService;
    }

    public void UpdateWeightCell(Dot cell, Dot endCell, int index) {
        cell.setPathLengthFromStartCell(calcPathLengthFromStartCell(index));
        calcHeuristicValue(cell, endCell);
        calcWeightCell(cell);
    }

    private int calcPathLengthFromStartCell(int index) {
        if (index == 0 || index == 2 || index == 4 || index == 6) {
            return STEP;
        } else {
            return STEP_SIDEWAYS;
        }
    }

    private void calcHeuristicValue(Dot newCell, Dot endCell) {
        newCell.setHeuristicValue(manhattanHeuristicService.calculateHeuristicValue(newCell, endCell) * STEP);
    }

    private void calcWeightCell(Dot cell) {
        if (cell.getHeuristicValue() > 0 && cell.getPathLengthFromStartCell() > 0) {
            cell.setWeightCell(cell.getHeuristicValue() + cell.getPathLengthFromStartCell());
        } else {
            log.error("cell in calcWeightCell empty");
        }
    }
}
