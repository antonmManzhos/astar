package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DotServiceTest3 {

    private DotService dotService;
    private List<Dot> walls;

    @BeforeEach
    void setUp() {
        Dot wall = new Dot();
        wall.setX(4);
        wall.setY(1);

        Dot wall2 = new Dot();
        wall2.setX(2);
        wall2.setY(2);

        Dot wall3 = new Dot();
        wall3.setX(3);
        wall3.setY(2);

        Dot wall4 = new Dot();
        wall4.setX(4);
        wall4.setY(2);

        Dot wall5 = new Dot();
        wall5.setX(3);
        wall5.setY(3);

        Dot wall6 = new Dot();
        wall6.setX(3);
        wall6.setY(4);

        Dot wall7 = new Dot();
        wall7.setX(6);
        wall7.setY(3);

        Dot wall8 = new Dot();
        wall8.setX(6);
        wall8.setY(4);

        Dot wall9 = new Dot();
        wall9.setX(5);
        wall9.setY(4);

        Dot wall10 = new Dot();
        wall10.setX(5);
        wall10.setY(5);

        walls = new ArrayList<Dot>(){
            {
                add(wall);
                add(wall2);
                add(wall3);
                add(wall4);
                add(wall5);
                add(wall6);
                add(wall7);
                add(wall8);
                add(wall9);
                add(wall10);
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
        startPoint.setX(1);
        startPoint.setY(1);

        Dot endPoint = new Dot();
        endPoint.setX(7);
        endPoint.setY(3);

        List<Dot> resultArray = dotService.gettingPath(startPoint, endPoint, walls);

        assertEquals(7, resultArray.size());

        assertEquals(1, resultArray.get(0).getX());
        assertEquals(2, resultArray.get(0).getY());

        assertEquals(2, resultArray.get(1).getX());
        assertEquals(3, resultArray.get(1).getY());

        assertEquals(2, resultArray.get(2).getX());
        assertEquals(4, resultArray.get(2).getY());

        assertEquals(3, resultArray.get(3).getX());
        assertEquals(5, resultArray.get(3).getY());

        assertEquals(4, resultArray.get(4).getX());
        assertEquals(4, resultArray.get(4).getY());

        assertEquals(5, resultArray.get(5).getX());
        assertEquals(3, resultArray.get(5).getY());

        assertEquals(6, resultArray.get(6).getX());
        assertEquals(2, resultArray.get(6).getY());

    }
}
