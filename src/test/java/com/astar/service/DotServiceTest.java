package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DotServiceTest {

    private DotService dotService;
    private List<Dot> walls;
    private Dot inWall;
    private Dot outWall;

    @BeforeEach
    void setUp() {
        inWall = new Dot();
        outWall = new Dot();

        inWall.setX(3);
        inWall.setY(2);

        outWall.setX(5);
        outWall.setY(5);

        Dot wall = new Dot();
        wall.setX(3);
        wall.setY(2);

        Dot wall2 = new Dot();
        wall2.setX(4);
        wall2.setY(2);

        Dot wall3 = new Dot();
        wall3.setX(4);
        wall3.setY(3);
        walls = new ArrayList<Dot>(){
            {
                add(wall);
                add(wall2);
                add(wall3);
            }
        };

        HeuristicValue manhattanHeuristicService = new ManhattanHeuristicService();
        CalculationService calculationService = new CalculationService(manhattanHeuristicService);
        CellWallService cellWallService = new CellWallService();
        OpenListCellsService openListCellsService = new OpenListCellsService(cellWallService, calculationService);
        dotService = new DotService(openListCellsService);
    }

    @Test
    void gettingPath() {
        Dot startPoint = new Dot();
        startPoint.setX(2);
        startPoint.setY(3);

        Dot endPoint = new Dot();
        endPoint.setX(6);
        endPoint.setY(3);

        List<Dot> resultArray = dotService.gettingPath(startPoint, endPoint, walls);

        assertEquals(3, resultArray.size());

        assertEquals(3, resultArray.get(0).getX());
        assertEquals(3, resultArray.get(0).getY());

        assertEquals(4, resultArray.get(1).getX());
        assertEquals(4, resultArray.get(1).getY());

        assertEquals(5, resultArray.get(2).getX());
        assertEquals(3, resultArray.get(2).getY());

    }
}