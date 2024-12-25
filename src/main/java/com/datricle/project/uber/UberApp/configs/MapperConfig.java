package com.datricle.project.uber.UberApp.configs;

import com.datricle.project.uber.UberApp.dto.PointDto;
import com.datricle.project.uber.UberApp.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfig {
    ModelMapper mapper = new ModelMapper();
    @Bean
    public ModelMapper modelMapper() {
        mapper.typeMap(PointDto.class, Point.class).setConverter(converter->{
            PointDto pointDto = converter.getSource();
            return GeometryUtil.createPoint(pointDto);
        });
        mapper.typeMap(Point.class, PointDto.class).setConverter(context ->{
            Point point = context.getSource();
            double coordinates[] = {
                    point.getX(),
                    point.getY()
            };
return new PointDto(coordinates);
        });
        return mapper;
    }
}
