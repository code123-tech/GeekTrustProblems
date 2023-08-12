package com.example.geektrust.repository;

import com.example.geektrust.common.constants.DirectionSymbolConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.Impl.GameRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Game Repository Repo Impl Test.")
@ExtendWith(MockitoExtension.class)
public class GameRepositoryImplTest {
    @InjectMocks
    private GameRepositoryImpl gameRepository;

    @Test
    @DisplayName("test save method - New game is created.")
    public void testSaveMethodWhenNewGameCreated(){
        // inputs
        Point src = new Point(1, 2);
        Point dest = new Point(4, 5);
        Direction direction = Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.NORTH_SYMBOL);
        Game game = new Game();
        game.setSrc(src);
        game.setDest(dest);
        game.setDirection(direction);
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        // Output
        Game gameFromRepository = gameRepository.save(game);

        // Verify
        Assertions.assertNotNull(gameFromRepository);
        Assertions.assertEquals(ServiceConstants.GAME_ID, gameFromRepository.getId());
        Assertions.assertEquals(game.getSrc().getX(), gameFromRepository.getSrc().getX());
        Assertions.assertEquals(game.getDest().getX(), gameFromRepository.getDest().getX());
        Assertions.assertEquals(game.getSrc().getY(), gameFromRepository.getSrc().getY());
        Assertions.assertEquals(game.getDest().getY(), gameFromRepository.getDest().getY());
        Assertions.assertEquals(game.getDirection(), gameFromRepository.getDirection());
        Assertions.assertEquals(game.getINITIAL_POWER(), gameFromRepository.getINITIAL_POWER());
    }

    @Test
    @DisplayName("test save method - Existing Game.")
    public void testSaveMethodOnExistingGame(){
        // inputs
        Integer gameId = ServiceConstants.GAME_ID;
        Point src = new Point(1, 2);
        Point dest = new Point(4, 5);
        Direction direction = Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.NORTH_SYMBOL);
        Game game = new Game();
        game.setId(gameId);
        game.setSrc(src);
        game.setDest(dest);
        game.setDirection(direction);
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        // Output
        Game gameFromRepository = gameRepository.save(game);

        // Verify
        Assertions.assertNotNull(gameFromRepository);
        Assertions.assertEquals(game.getId(), gameFromRepository.getId());
        Assertions.assertEquals(game.getSrc().getX(), gameFromRepository.getSrc().getX());
        Assertions.assertEquals(game.getDest().getX(), gameFromRepository.getDest().getX());
        Assertions.assertEquals(game.getSrc().getY(), gameFromRepository.getSrc().getY());
        Assertions.assertEquals(game.getDest().getY(), gameFromRepository.getDest().getY());
        Assertions.assertEquals(game.getDirection(), gameFromRepository.getDirection());
        Assertions.assertEquals(game.getINITIAL_POWER(), gameFromRepository.getINITIAL_POWER());
    }

    @Test
    @DisplayName("test findById method - game exist.")
    public void testFindByIdMethodWhenGameExist(){
        // inputs
        Point src = new Point(1, 2);
        Point dest = new Point(4, 5);
        Direction direction = Direction.getDirectionBasedOnSymbol(DirectionSymbolConstants.NORTH_SYMBOL);
        Game game = new Game();
        game.setSrc(src);
        game.setDest(dest);
        game.setDirection(direction);
        game.setINITIAL_POWER(ServiceConstants.INITIAL_POWER);
        // Output
        Game newGame = gameRepository.save(game);
        Game gameFromRepository = gameRepository.findById(newGame.getId());

        // Verify
        Assertions.assertNotNull(gameFromRepository);
        Assertions.assertEquals(newGame.getId(), gameFromRepository.getId());
        Assertions.assertEquals(game.getSrc().getX(), gameFromRepository.getSrc().getX());
        Assertions.assertEquals(game.getDest().getX(), gameFromRepository.getDest().getX());
        Assertions.assertEquals(game.getSrc().getY(), gameFromRepository.getSrc().getY());
        Assertions.assertEquals(game.getDest().getY(), gameFromRepository.getDest().getY());
        Assertions.assertEquals(game.getDirection(), gameFromRepository.getDirection());
        Assertions.assertEquals(game.getINITIAL_POWER(), gameFromRepository.getINITIAL_POWER());
    }

    @Test
    @DisplayName("test findById method - game not exist.")
    public void testFindByIdMethodWhenGameNotExist(){
        // inputs
        Integer gameId = ServiceConstants.GAME_ID;
        // Output
        Game gameFromRepository = gameRepository.findById(gameId);

        // Verify
        Assertions.assertNull(gameFromRepository);
    }
}
