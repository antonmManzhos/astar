package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenListCellsServiceTest2 {
    @InjectMocks
    private OpenListCellsService openListCellsService;
    private Dot endCell;
    private Dot startCell;
    private List<Dot> walls;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        openListCellsService = new OpenListCellsService(new CellWallService(), new CalculationService(new ManhattanHeuristicService()));

        Dot wall = new Dot();
        wall.setX(3);
        wall.setY(2);

        Dot wall2 = new Dot();
        wall2.setX(4);
        wall2.setY(2);

        Dot wall3 = new Dot();
        wall3.setX(5);
        wall3.setY(2);

        Dot wall4 = new Dot();
        wall4.setX(6);
        wall4.setY(2);

        Dot wall5 = new Dot();
        wall5.setX(2);
        wall5.setY(4);

        Dot wall6 = new Dot();
        wall6.setX(3);
        wall6.setY(4);

        walls = new ArrayList<Dot>(){
            {
                add(wall);
                add(wall2);
                add(wall3);
                add(wall4);
                add(wall5);
                add(wall6);
            }
        };

        startCell = new Dot();
        startCell.setX(1);
        startCell.setY(5);

        endCell = new Dot();
        endCell.setX(2);
        endCell.setY(5);

    }

    @Test
    void generateOpenListCells() {
        List<Dot> openCells = openListCellsService.generateOpenListCells(startCell, endCell, walls);

        assertEquals(2, openCells.size());

        assertEquals(90, openCells.get(0).getWeightCell());
        assertEquals(70, openCells.get(1).getWeightCell());


//        assertEquals(60, openCells.get(2).getWeightCell());
//        assertEquals(74, openCells.get(3).getWeightCell());
//        assertEquals(60, openCells.get(4).getWeightCell());
//        assertEquals(74, openCells.get(5).getWeightCell());
//        assertEquals(60, openCells.get(6).getWeightCell());
//        assertEquals(54, openCells.get(7).getWeightCell());
    }
}
