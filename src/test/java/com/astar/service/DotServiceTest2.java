package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DotServiceTest2 {

    private DotService dotService;
    private List<Dot> walls;

    @BeforeEach
    void setUp() {

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

        HeuristicValue manhattanHeuristicService = new ManhattanHeuristicService();
        CalculationService calculationService = new CalculationService(manhattanHeuristicService);
        CellWallService cellWallService = new CellWallService();
        OpenListCellsService openListCellsService = new OpenListCellsService(cellWallService, calculationService);
        dotService = new DotService(openListCellsService);
    }

    @Test
    void gettingPath() {
        Dot startPoint = new Dot();
        startPoint.setX(5);
        startPoint.setY(1);

        Dot endPoint = new Dot();
        endPoint.setX(2);
        endPoint.setY(5);

        List<Dot> resultArray = dotService.gettingPath(startPoint, endPoint, walls);

        assertEquals(5, resultArray.size());

        assertEquals(1, resultArray.get(0).getX());
        assertEquals(4, resultArray.get(0).getY());

        assertEquals(2, resultArray.get(1).getX());
        assertEquals(3, resultArray.get(1).getY());

        assertEquals(2, resultArray.get(2).getX());
        assertEquals(2, resultArray.get(2).getY());

        assertEquals(3, resultArray.get(3).getX());
        assertEquals(1, resultArray.get(3).getY());

        assertEquals(4, resultArray.get(4).getX());
        assertEquals(1, resultArray.get(4).getY());
    }
}
