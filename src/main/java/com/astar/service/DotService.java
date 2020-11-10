package com.astar.service;

import com.astar.model.Dot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class DotService {

    private ArrayList<Dot> closedList = new ArrayList<>();
    private ArrayList<Dot> openedList = new ArrayList<>();
}
