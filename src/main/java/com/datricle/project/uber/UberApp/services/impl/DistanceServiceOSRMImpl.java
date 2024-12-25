package com.datricle.project.uber.UberApp.services.impl;

import com.datricle.project.uber.UberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {

    @Override
    public double calculateDistance(Point src, Point dest) {
        //TODO: call the third party api called osr, to fetch the distance
        return 0;
    }
}
