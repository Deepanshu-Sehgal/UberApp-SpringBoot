package com.datricle.project.uber.UberApp.services;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
    double calculateDistance(Point src,Point dest);
}