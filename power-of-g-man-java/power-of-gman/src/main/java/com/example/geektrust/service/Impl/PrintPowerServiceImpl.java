package com.example.geektrust.service.Impl;

import com.example.geektrust.common.constants.PowerConsumptionConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.common.exceptions.GameNotFoundException;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.IGameRepository;
import com.example.geektrust.service.IPrintPowerService;

import java.util.Optional;

public class PrintPowerServiceImpl implements IPrintPowerService {
    private IGameRepository gameRepository;

    public PrintPowerServiceImpl(IGameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    @Override
    public Integer calculateGamePower(Integer gameId) {
        Game game = Optional.ofNullable(gameRepository.findById(gameId)).orElseThrow(() -> new GameNotFoundException(ServiceConstants.INVALID_GAME));
        Point source = game.getSrc();
        Point destination = game.getDest();
        Integer horizontalTurns = Math.abs(source.getX() - destination.getX());
        Integer verticalTurns = Math.abs(source.getY() - destination.getY());
        return game.getINITIAL_POWER() -
                (((horizontalTurns + verticalTurns) * PowerConsumptionConstants.POWER_REDUCE_ON_STEP) +
                        PowerConsumptionConstants.POWER_REDUCE_ON_TURN * calculateTurns(game));
    }

    private Integer calculateTurns(Game game){
        Direction horDirection = Direction.EAST;
        if((game.getSrc().getX() - game.getDest().getX()) > 0){
            horDirection = Direction.WEST;
        }
        Direction verDirection = Direction.NORTH;
        if((game.getSrc().getY() - game.getDest().getY()) > 0 ){
            verDirection = Direction.SOUTH;
        }
        Integer totalTurns = 0;
        if(!horDirection.equals(game.getDirection())){
            totalTurns += 1;
        }
        if(!verDirection.equals(game.getDirection())){
            totalTurns += 1;
        }
        return totalTurns;
    }
}
