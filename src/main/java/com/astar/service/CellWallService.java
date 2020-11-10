package com.astar.service;

import com.astar.model.Dot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CellWallService {

    final int MAX_Y = 99;
    final int MAX_X = 99;

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

    public boolean isCellWallPerimeter(Dot cell) {
        if(cell.getY() > MAX_Y) {
            return true;
        }
        if(cell.getX() > MAX_X) {
            return true;
        }
        return false;
    }
}
