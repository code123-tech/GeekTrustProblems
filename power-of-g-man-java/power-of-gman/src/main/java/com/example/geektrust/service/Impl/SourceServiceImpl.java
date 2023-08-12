package com.example.geektrust.service.Impl;

import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.IGameRepository;
import com.example.geektrust.repository.IPointRepository;
import com.example.geektrust.service.ISourceService;

public class SourceServiceImpl implements ISourceService {
    private IPointRepository pointRepository;
    private IGameRepository gameRepository;

    public SourceServiceImpl(IPointRepository pointRepository, IGameRepository gameRepository){
        this.pointRepository = pointRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public Point addPoint(Point point, String direction, Integer initialPower) {
        addGame(point, Direction.getDirectionBasedOnSymbol(direction), initialPower);
        return pointRepository.save(point);
    }
    private void addGame(Point point, Direction direction, Integer initialPower){
        Game game = new Game();
        game.setSrc(point);
        game.setDirection(direction);
        game.setINITIAL_POWER(initialPower);
        gameRepository.save(game);
    }
}
