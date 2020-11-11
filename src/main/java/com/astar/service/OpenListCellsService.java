package com.astar.service;

import com.astar.model.Dot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpenListCellsService {

    final int CELLS_IN_RADIUS = 8;
    final int[] x = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    final int[] y = new int[]{0, 1, 1, 1,  0, -1, -1, -1};
    private final CellWallService cellWallService;
    private final CalculationService calculationService;

    public OpenListCellsService(CellWallService cellWallService, CalculationService calculationService) {
        this.cellWallService = cellWallService;
        this.calculationService = calculationService;
    }

    public List<Dot> generateOpenListCells(Dot startCell, Dot endCell, List<Dot> walls) {
        List<Dot> openList = new ArrayList<>();
        for (int i = 0; i < CELLS_IN_RADIUS; i++) {

            Dot cell = this.generateCoordinatesDotAroundStartCell(startCell, i);

            if (cellWallService.isCellWallPerimeter(cell)) {
                break;
            }

            if (cellWallService.isCellWall(walls, cell)) {
                break;
            }
            calculationService.UpdateWeightCell(cell, endCell, i);
            openList.add(cell);
        }
        return openList;
    }

    private Dot generateCoordinatesDotAroundStartCell(Dot startCell, int index) {
        Dot cell = new Dot();
        cell.setX(startCell.getX() + x[index]);
        cell.setY(startCell.getY() + y[index]);
        return cell;
    }
}
