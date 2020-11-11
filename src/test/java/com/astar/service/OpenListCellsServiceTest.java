package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenListCellsServiceTest {
    @InjectMocks
    private OpenListCellsService openListCellsService;
    private Dot endCell;
    private Dot startCell;
    private List<Dot> walls;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        openListCellsService = new OpenListCellsService(new CellWallService(), new CalculationService(new ManhattanHeuristicService()));

        endCell = new Dot();
        endCell.setX(6);
        endCell.setY(3);

        startCell = new Dot();
        startCell.setX(2);
        startCell.setY(3);

    }

    @Test
    void generateOpenListCells() {
        List<Dot> openCells = openListCellsService.generateOpenListCells(startCell, endCell, walls);

        assertEquals(8, openCells.size());

        assertEquals(40, openCells.get(0).getWeightCell());
        assertEquals(54, openCells.get(1).getWeightCell());
        assertEquals(60, openCells.get(2).getWeightCell());
        assertEquals(74, openCells.get(3).getWeightCell());
        assertEquals(60, openCells.get(4).getWeightCell());
        assertEquals(74, openCells.get(5).getWeightCell());
        assertEquals(60, openCells.get(6).getWeightCell());
        assertEquals(54, openCells.get(7).getWeightCell());
    }
}