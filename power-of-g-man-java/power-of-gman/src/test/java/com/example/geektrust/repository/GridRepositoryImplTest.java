package com.example.geektrust.repository;

import com.example.geektrust.common.constants.DirectionSymbolConstants;
import com.example.geektrust.common.constants.ServiceConstants;
import com.example.geektrust.common.enums.Direction;
import com.example.geektrust.modal.Game;
import com.example.geektrust.modal.Grid;
import com.example.geektrust.modal.Point;
import com.example.geektrust.repository.Impl.GridRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Grid Repository Repo Impl Test.")
@ExtendWith(MockitoExtension.class)
public class GridRepositoryImplTest {
    @InjectMocks
    private GridRepositoryImpl gridRepository;

    @Test
    @DisplayName("test save method - New grid is created.")
    public void testSaveMethodWhenNewGridCreated(){
        // inputs
        Grid grid = new Grid();
        Point point = new Point(0, 0);
        grid.setCell(0, 0, point);
        // Output
        Grid gridFromRepository = gridRepository.save(grid);
        Point pointFromGrid = gridFromRepository.getCell(0, 0);
        // Verify
        Assertions.assertNotNull(gridFromRepository);
        Assertions.assertEquals(point, pointFromGrid);
    }

    @Test
    @DisplayName("test save method - existing grid.")
    public void testSaveMethodWhenGridIsExisting(){
        // inputs
        Grid grid = new Grid();
        Point point = new Point(0, 0);
        grid.setCell(0, 0, point);
        grid.setId(1);
        // Output
        Grid existingGrid = gridRepository.save(grid);
        Point pointFromGrid = existingGrid.getCell(0, 0);
        // Verify
        Assertions.assertNotNull(existingGrid);
        Assertions.assertEquals(grid.getId(), existingGrid.getId());
        Assertions.assertEquals(point, pointFromGrid);
    }

    @Test
    @DisplayName("test findById method - grid exist.")
    public void testFindByIdMethodWhenGridExist(){
        // inputs
        Grid grid = new Grid();
        Point point = new Point(0, 0);
        grid.setCell(0, 0, point);
        Grid savedGrid = gridRepository.save(grid);
        // Output
        Grid gridFromRepo = gridRepository.findById(savedGrid.getId());

        // Verify
        Assertions.assertNotNull(gridFromRepo);
        Assertions.assertEquals(savedGrid.getId(), gridFromRepo.getId());
    }

    @Test
    @DisplayName("test findById method - grid not exist.")
    public void testFindByIdMethodWhenGridGameNotExist(){
        // inputs
        Integer gridId = ServiceConstants.GAME_ID;
        // Output
        Grid grid = gridRepository.findById(gridId);

        // Verify
        Assertions.assertNull(grid);
    }
}
