package com.example.geektrust.service.Impl;

import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.exceptions.GameNotFoundException;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.IGameRepository;
import com.example.geektrust.repository.IPointRepository;
import com.example.geektrust.service.IDestinationService;

import java.util.Optional;

public class DestinationServiceImpl implements IDestinationService {
    private IGameRepository gameRepository;
    private IPointRepository pointRepository;

    public DestinationServiceImpl(IGameRepository gameRepository, IPointRepository pointRepository){
        this.gameRepository = gameRepository;
        this.pointRepository = pointRepository;
    }

    @Override
    public Point addDestination(Point destination, Integer gameId) {
        Game game = Optional.ofNullable(gameRepository.findById(gameId)).orElseThrow(() -> new GameNotFoundException(ServiceConstants.INVALID_GAME));
        game.setDest(destination);
        gameRepository.save(game);
        return pointRepository.save(destination);
    }

}
