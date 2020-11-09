package com.astar.service;

import com.astar.model.Dot;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CellWallService {

    public boolean isCellWall(List<Dot> walls, Dot cell) {
        if (walls == null) {
            return false;
        }

        if (cell == null) {
            log.error("cell in isCellWall empty");
        }

        for (Dot wall : walls) {
            if (wall.getX() == cell.getX() && wall.getY() == cell.getY()) {
                return true;
            }
        }
        return false;
    }
}
