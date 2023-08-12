package com.example.geektrust.service;

import com.example.geektrust.common.constants.DirectionSymbolConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.IGameRepository;
import com.example.geektrust.service.Impl.PrintPowerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Print Power Service Impl Test.")
@ExtendWith(MockitoExtension.class)
public class PrintPowerServiceImplTest {
    @Mock
    private IGameRepository gameRepository;

    @InjectMocks
    private PrintPowerServiceImpl printPowerService;

    @Test
    @DisplayName("Calculate Power - 1")
    public void testCalculatePower1(){
        // inputs
        Integer expectedOutput = 145;
        Point src = new Point(1, 4);
        Point dest = new Point(4, 6);
        Direction direction = Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.NORTH_SYMBOL);
        Game game = new Game();
        game.setSrc(src);
        game.setDest(dest);
        game.setDirection(direction);
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        game.setId(ServiceConstants.GAME_ID);
        Mockito.when(gameRepository.findById(game.getId())).thenReturn(game);
        // output
        Integer power = printPowerService.calculateGamePower(game.getId());
        // verify
        Assertions.assertNotNull(power);
        Assertions.assertEquals(expectedOutput, power);
    }

    @Test
    @DisplayName("Calculate Power - 2")
    public void testCalculatePower2(){
        // inputs
        Integer expectedOutput = 110;
        Point src = new Point(3, 6);
        Point dest = new Point(1, 0);
        Direction direction = Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.NORTH_SYMBOL);
        Game game = new Game();
        game.setSrc(src);
        game.setDest(dest);
        game.setDirection(direction);
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        game.setId(ServiceConstants.GAME_ID);
        Mockito.when(gameRepository.findById(game.getId())).thenReturn(game);
        // output
        Integer power = printPowerService.calculateGamePower(game.getId());
        // verify
        Assertions.assertNotNull(power);
        Assertions.assertEquals(expectedOutput, power);
    }

    @Test
    @DisplayName("Calculate Power - 3")
    public void testCalculatePower3(){
        // inputs
        Integer expectedOutput = 90;
        Point src = new Point(0, 5);
        Point dest = new Point(6, 1);
        Direction direction = Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.WEST_SYMBOL);
        Game game = new Game();
        game.setSrc(src);
        game.setDest(dest);
        game.setDirection(direction);
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        game.setId(ServiceConstants.GAME_ID);
        Mockito.when(gameRepository.findById(game.getId())).thenReturn(game);
        // output
        Integer power = printPowerService.calculateGamePower(game.getId());
        // verify
        Assertions.assertNotNull(power);
        Assertions.assertEquals(expectedOutput, power);
    }

    @Test
    @DisplayName("Calculate Power - 4")
    public void testCalculatePower4(){
        // inputs
        Integer expectedOutput = 155;
        Point src = new Point(2, 1);
        Point dest = new Point(4, 3);
        Direction direction = Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.EAST_SYMBOL);
        Game game = new Game();
        game.setSrc(src);
        game.setDest(dest);
        game.setDirection(direction);
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        game.setId(ServiceConstants.GAME_ID);
        Mockito.when(gameRepository.findById(game.getId())).thenReturn(game);
        // output
        Integer power = printPowerService.calculateGamePower(game.getId());
        // verify
        Assertions.assertNotNull(power);
        Assertions.assertEquals(expectedOutput, power);
    }
}
