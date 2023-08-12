package com.example.geektrust.common.enums;

import com.example.geektrust.common.constants.DirectionSymbolConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.exceptions.DirectionNotFoundException;

public enum Direction {
    NORTH(DirectionSymbolConstants.NORTH_SYMBOL),
    EAST(DirectionSymbolConstants.EAST_SYMBOL),
    WEST(DirectionSymbolConstants.WEST_SYMBOL),
    SOUTH(DirectionSymbolConstants.SOUTH_SYMBOL);
    private String symbol;
    Direction(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){
        return this.getSymbol();
    }

    public static Direction getDirectionBasedOnSymbol(String directionSymbol){
        switch (directionSymbol){
            case DirectionSymbolConstants.NORTH_SYMBOL:
                return Direction.NORTH;
            case DirectionSymbolConstants.EAST_SYMBOL:
                return Direction.EAST;
            case DirectionSymbolConstants.WEST_SYMBOL:
                return Direction.WEST;
            case DirectionSymbolConstants.SOUTH_SYMBOL:
                return Direction.SOUTH;
            default:
                throw new DirectionNotFoundException(ServiceConstants.INVALID_DIRECTION);
        }
    }
}
