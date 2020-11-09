package com.astar.service;

import com.astar.model.Dot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellWallServiceTest {
    private CellWallService cellWallService;
    private List<Dot> walls;
    private Dot inWall;
    private Dot outWall;

    @BeforeEach
    void setUp() {

        cellWallService = new CellWallService();

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
    }

    @Test
    void isCellWall() {
        assertEquals(true, cellWallService.isCellWall(walls, inWall));
        assertEquals(false, cellWallService.isCellWall(walls, outWall));
    }
}