package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarQueueTest {

    private CarQueue carQueue;
    private ChargingStationGUI mockGUI;

    @BeforeEach
    public void setUp() {
        mockGUI = Mockito.mock(ChargingStationGUI.class);
        carQueue = new CarQueue(mockGUI);

        // Since the constructor adds cars, we remove them to start fresh for each test
        while (carQueue.getNextCar() != null);
    }

    @Test
    public void testAddCar() {
        Car car = new Car("Test Car");
        carQueue.addCar(car);
        assertEquals(1, carQueue.getQueueSize());
        Mockito.verify(mockGUI).updateQueue(2); // Verifies that the GUI was updated correctly
    }

    @Test
    public void testGetNextCar() {
        Car car = new Car("Test Car");
        carQueue.addCar(car);
        Car retrievedCar = carQueue.getNextCar();
        assertEquals("Test Car", retrievedCar.getLicensePlate());
        assertEquals(0, carQueue.getQueueSize());
        Mockito.verify(mockGUI, Mockito.times(13)).updateQueue(Mockito.anyInt()); // Verifies that the GUI was updated 13 times
    }

    @Test
    public void testQueueSizeAfterInitialization() {
        assertEquals(0, carQueue.getQueueSize());
    }

    @Test
    public void testReturnCar() {
        Car car = new Car("Return Test Car");
        carQueue.returnCar(car);
        assertEquals(1, carQueue.getQueueSize());
        Mockito.verify(mockGUI).updateQueue(2); // Verifies that the GUI was updated correctly
    }

    @Test
    public void testRemoveCar() {
        Car car = new Car("Remove Test Car");
        carQueue.addCar(car);
        carQueue.removeCar(car);
        assertEquals(0, carQueue.getQueueSize());
        Mockito.verify(mockGUI, Mockito.times(13)).updateQueue(Mockito.anyInt()); // Verifies that the GUI was updated 13 times
    }
}
