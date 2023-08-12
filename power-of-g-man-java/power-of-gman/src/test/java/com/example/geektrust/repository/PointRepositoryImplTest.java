package com.example.geektrust.repository;

import com.example.geektrust.common.constants.DirectionSymbolConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.Impl.GameRepositoryImpl;
import com.example.geektrust.repository.Impl.PointRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Points Repository Repo Impl Test.")
@ExtendWith(MockitoExtension.class)
public class PointRepositoryImplTest {
    @InjectMocks
    private PointRepositoryImpl pointRepository;

    @Test
    @DisplayName("test save method - New point is created.")
    public void testSaveMethodWhenNewPointCreated(){
        // inputs
        Point point = new Point(1, 2);
        // Output
        Point pointFromRepository = pointRepository.save(point);

        // Verify
        Assertions.assertNotNull(pointFromRepository);
        Assertions.assertEquals(point.getX(), pointFromRepository.getX());
        Assertions.assertEquals(point.getY(), pointFromRepository.getY());
    }

    @Test
    @DisplayName("test save method - Existing point.")
    public void testSaveMethodOnExistingPoint(){
        // inputs
        Point pointInp1 = new Point(2, 3);
        Point pointInp2 = new Point(2, 3);

        // Output
        Point point1 = pointRepository.save(pointInp1);
        Point point2 = pointRepository.save(pointInp2);

        // Verify
        Assertions.assertNotNull(point1);
        Assertions.assertNotNull(point2);
        Assertions.assertEquals(point1, point2);
    }

    @Test
    @DisplayName("test getByXAndY method - point exist.")
    public void testGetByXAndYMethodWhenPointExist(){
        // inputs
        Point point = new Point(1, 2);
        Point savedPoint = pointRepository.save(point);
        // Output
        Point pointByXAndY = pointRepository.getByXAndY(point.getX(), point.getY());
        // Verify
        Assertions.assertNotNull(pointByXAndY);
        Assertions.assertEquals(savedPoint, pointByXAndY);
        Assertions.assertEquals(savedPoint.getX(), pointByXAndY.getX());
        Assertions.assertEquals(savedPoint.getY(), pointByXAndY.getY());
    }

    @Test
    @DisplayName("test getByXAndY method - point not exist.")
    public void testGetByXAndYMethodWhenPointNotExist(){
        // inputs
        Integer x = 1;
        Integer y = 1;
        // Output
        Point point = pointRepository.getByXAndY(x, y);

        // Verify
        Assertions.assertNull(point);
    }
}
