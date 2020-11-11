package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenListCellsServiceTest {
    @InjectMocks
    private OpenListCellsService openListCellsService;

    @Mock
    CellWallService cellWallService;
    @Mock
    CalculationService calculationService;
    private Dot endCell;
    private Dot startCell;
    private List<Dot> walls;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        openListCellsService = new OpenListCellsService(cellWallService, calculationService);

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
    }
}