package com.example.geektrust.service;

import com.example.geektrust.common.constants.DirectionSymbolConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.IGameRepository;
import com.example.geektrust.repository.IPointRepository;
import com.example.geektrust.service.Impl.DestinationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Destination Service Impl Test.")
@ExtendWith(MockitoExtension.class)
public class DestinationServiceImplTest {
    @Mock
    private IPointRepository pointRepository;
    @Mock
    private IGameRepository gameRepository;

    @InjectMocks
    private DestinationServiceImpl destinationService;

    @Test
    @DisplayName("test - add point")
    public void testAddPoint(){
        // inputs
        Integer x = 1;
        Integer y = 1;
        Point point = new Point(x, y);
        Game game = new Game();
        game.setSrc(new Point(3, 4));
        game.setDirection(Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.NORTH_SYMBOL));
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        game.setId(ServiceConstants.GAME_ID);
        Mockito.when(gameRepository.findById(game.getId())).thenReturn(game);
        Mockito.when(pointRepository.save(point)).thenReturn(point);
        // outputs
        Point pointAdd = destinationService.addDestination(point, game.getId());
        //verify
        Assertions.assertNotNull(pointAdd);
        Assertions.assertEquals(point.getX(), pointAdd.getX());
    }
}
