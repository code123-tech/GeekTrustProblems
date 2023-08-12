package com.example.geektrust.service;

import com.example.geektrust.common.constants.DirectionSymbolConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.IGameRepository;
import com.example.geektrust.repository.IPointRepository;
import com.example.geektrust.service.Impl.SourceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Source Service Impl Test.")
@ExtendWith(MockitoExtension.class)
public class SourceServiceImplTest {
    @Mock
    private IPointRepository pointRepository;
    @Mock
    private IGameRepository gameRepository;

    @InjectMocks
    private SourceServiceImpl sourceService;

    @Test
    @DisplayName("test - add point")
    public void testAddPoint(){
        // inputs
        Integer x = 1;
        Integer y = 1;
        Point point = new Point(x, y);
        String direction = DirectionSymbolConstants.NORTH_SYMBOL;
        Integer INITIAL_POWER = ServiceConstants.INITIAL_POWER;
        Mockito.when(pointRepository.save(point)).thenReturn(point);
        // outputs
        Point pointAdd = sourceService.addPoint(point, direction, INITIAL_POWER);
        //verify
        Assertions.assertNotNull(pointAdd);
        Assertions.assertEquals(point.getX(), pointAdd.getX());
    }
}
