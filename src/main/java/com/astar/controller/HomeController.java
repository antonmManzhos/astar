package com.astar.controller;

import com.astar.model.Dot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping({"/", "", "/home"})
    public ResponseEntity<String> getProductById() {

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
        ArrayList<Dot> walls = new ArrayList<Dot>(){
            {
                add(wall);
                add(wall2);
                add(wall3);
            }
        };

        return new ResponseEntity<String>("null", HttpStatus.OK);
    }
}
