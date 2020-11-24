package com.astar.service;

import com.astar.model.Dot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DotService {

    private final OpenListCellsService openListCellsService;

    public DotService(OpenListCellsService openListCellsService) {
        this.openListCellsService = openListCellsService;
    }

    public List<Dot> gettingPath(Dot startCell, Dot endCell, List<Dot> walls) {
        //walls.add(startCell);

        List<Dot> openList = openListCellsService.generateOpenListCells(startCell, endCell, walls);
        List<Dot> resultArray = new ArrayList<>();

        if (openList.size() > 0) {

            int minValue = openList.get(0).getWeightCell();
            Dot minDot = openList.get(0);
            resultArray = new ArrayList<>();

            while (!minDot.equals(endCell)) {

                if (openList.size() > 0) {
                    for (Dot dot : openList) {
                        if (minValue > dot.getWeightCell()) {
                            minValue = dot.getWeightCell();
                            minDot = dot;
                        }
                    }
                }

                resultArray.add(minDot);

                System.out.println("min dot x=" + minDot.getX() + " y=" + minDot.getY());

                openList = openListCellsService.generateOpenListCells(minDot, endCell, walls);

                minDot = openList.get(0);
                minValue = minDot.getWeightCell();

                for (Dot dot : resultArray) {
                    if (dot.equals(minDot)) {
                        resultArray.clear();
                        walls.add(minDot);
                        openList = openListCellsService.generateOpenListCells(startCell, endCell, walls);
                        minDot = openList.get(0);
                        minValue = minDot.getWeightCell();
                        break;
                    }
                }
            }
        }

        return resultArray;
    }
}
