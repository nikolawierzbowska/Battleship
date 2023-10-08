package com.codecool.battleship.player;

import com.codecool.battleship.board.*;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.SquareStatus;

import java.util.*;
import java.util.stream.Collectors;


public class ComputerPlayerNormal extends ComputerPlayerEasy {
    protected final Set<Position> pointsToAvoid = new HashSet<>();
    protected Position firstSquareOnShipHit;
    protected Position nextToShot;
    protected Ship currentShipToSunk;
    protected Direction currentShotDirection;
    protected Direction oppositeShotDirection;
    protected List<Direction> directionList = Arrays.stream(Direction.values()).collect(Collectors.toList());

    public ComputerPlayerNormal(Board board, String name) {
        super(board, name);
        Collections.shuffle(directionList);
    }

    @Override
    public Position getCoordinates() {
        if (currentShipToSunk == null)
            return generateRandomPoint();

        if (!currentShipToSunk.isShipAlive()) {
            shipSunk();
            return generateRandomPoint();
        }

        if (currentShotDirection == null)
            generateNewDirection();

        if (nextToShot == null)
            generateNextShotPoint(firstSquareOnShipHit);
        else
            generateNextShotPoint(nextToShot);

        if (super.opponentBoard.getSea()[nextToShot.getX()][nextToShot.getY()].getStatus() == SquareStatus.SHIP) {
            if (oppositeShotDirection == null)
                determineOppositeShotDirection();
            return nextToShot;
        } else {
            Position position = new Position(nextToShot.getX(), nextToShot.getY());
            if (oppositeShotDirection != null)
                currentShotDirection = oppositeShotDirection;
            else
                currentShotDirection = null;

            nextToShot = null;
            return position;
        }
    }

    private void determineOppositeShotDirection() {
        switch (currentShotDirection) {
            case WEST -> oppositeShotDirection = Direction.EAST;
            case EAST -> oppositeShotDirection = Direction.WEST;
            case NORTH -> oppositeShotDirection = Direction.SOUTH;
            case SOUTH -> oppositeShotDirection = Direction.NORTH;
        }
    }

    private void generateNextShotPoint(Position startingPosition) {
        Position position = new Position(startingPosition.getX() + currentShotDirection.getValue().getX(),
                startingPosition.getY() + currentShotDirection.getValue().getY());
        boolean isPointInRange = false;

        do{
            if (isIndexOutOfBounds(position.getX()) || isIndexOutOfBounds(position.getY()) ||
                    opponentBoard.getSea()[position.getX()][position.getY()].getStatus() == SquareStatus.MISSED) {

                setNewDirection();

                position = new Position(firstSquareOnShipHit.getX() + currentShotDirection.getValue().getX(),
                        firstSquareOnShipHit.getY() + currentShotDirection.getValue().getY());

            }else
                isPointInRange = true;

        }while(!isPointInRange);
        nextToShot = position;
    }
    private void setNewDirection(){
        if (oppositeShotDirection != null)
            currentShotDirection = oppositeShotDirection;
        else
            generateNewDirection();
    }

    private boolean isIndexOutOfBounds(int index) {
        return index < 0 || index >= super.opponentBoard.getSea().length;
    }

    private void shipSunk() {
        firstSquareOnShipHit = null;
        nextToShot = null;
        addPointsToSet();
        currentShipToSunk = null;
        currentShotDirection = null;
        oppositeShotDirection = null;
        directionList = Arrays.stream(Direction.values()).collect(Collectors.toList());
        Collections.shuffle(directionList);
    }

    private void generateNewDirection() {
        currentShotDirection = directionList.get(0);
        directionList.remove(0);
    }

    private Position generateRandomPoint() {

        Position toShoot = randomizePoint();

        if (super.opponentBoard.getSea()[toShoot.getX()][toShoot.getY()].getStatus() == SquareStatus.SHIP) {
            firstSquareOnShipHit = toShoot;
        }

        currentShipToSunk = super.opponentBoard.getShips()
                .stream()
                .filter(ship -> ship.getSquares().stream().anyMatch(square -> square.equals(toShoot)))
                .findAny().orElse(null);

        return toShoot;
    }

    private Position randomizePoint() {
        boolean isPointPositionNotAvaiable = true;
        Position position;

        do {
            position = super.getCoordinates();
            if (pointsToAvoid.contains(position))
                continue;
            SquareStatus status = super.opponentBoard.getSea()[position.getX()][position.getY()].getStatus();

            if (status == SquareStatus.EMPTY || status == SquareStatus.SHIP)
                isPointPositionNotAvaiable = false;
        } while (isPointPositionNotAvaiable);

        return position;
    }

    private void addPointsToSet() {
        currentShipToSunk.getSquares().forEach(square -> {
            for (int x = -1; x < 2; x++)
                for (int y = -1; y < 2; y++)
                    pointsToAvoid.add(new Position(square.getX() + x, square.getY() + y));
        });
    }
}