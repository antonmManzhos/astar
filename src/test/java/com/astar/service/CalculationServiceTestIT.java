package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationServiceTestIT {
    private CalculationService calculationService;

    @BeforeEach
    void setUp() {
        HeuristicValue manhattanHeuristicService = new ManhattanHeuristicService();
        calculationService = new CalculationService(manhattanHeuristicService);
    }

    @Test
    void updateWeightCell() {
        int index = 0;
        Dot cellNearStartCellWithZeroIndex = new Dot();
        cellNearStartCellWithZeroIndex.setX(3);
        cellNearStartCellWithZeroIndex.setY(3);

        Dot endCell = new Dot();
        endCell.setX(6);
        endCell.setY(3);

        calculationService.UpdateWeightCell(cellNearStartCellWithZeroIndex, endCell, index);
        assertEquals(10, cellNearStartCellWithZeroIndex.getPathLengthFromStartCell());
        assertEquals(30, cellNearStartCellWithZeroIndex.getHeuristicValue());
        assertEquals(40, cellNearStartCellWithZeroIndex.getWeightCell());
    }
}