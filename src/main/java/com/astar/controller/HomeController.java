package com.astar.controller;

import com.astar.model.Dot;
import com.astar.service.DotService;
import com.astar.service.OpenListCellsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final DotService dotService;

    public HomeController(DotService dotService) {
        this.dotService = dotService;
    }

    @GetMapping({"/", "", "/home"})
    public ResponseEntity<List<Dot>> getProductById() {

        Dot startPoint = new Dot();
        startPoint.setX(2);
        startPoint.setY(3);

        Dot endPoint = new Dot();
        endPoint.setY(3);
        endPoint.setX(6);

        Dot wall = new Dot();
        wall.setX(3);
        wall.setY(2);

        Dot wall2 = new Dot();
        wall2.setX(4);
        wall2.setY(2);

        Dot wall3 = new Dot();
        wall3.setX(4);
        wall3.setY(3);
        ArrayList<Dot> walls = new ArrayList<Dot>() {
            {
                add(wall);
                add(wall2);
                add(wall3);
            }
        };

        List<Dot> resultArray = dotService.gettingPath(startPoint, endPoint, walls);

        return new ResponseEntity<List<Dot>>(resultArray, HttpStatus.OK);
    }
}
