# CarQueue Unit Testing Documentation
## Overview
This documentation provides an overview of the CarQueueTest class, which is designed to test the functionality of the CarQueue class in a Java application. The CarQueue class is responsible for managing a queue of Car objects, typically used in the context of a charging station for electric vehicles. The tests utilize the JUnit 5 framework for writing and running tests, and Mockito for mocking dependencies.

## Setup
Before running these tests, ensure the following dependencies are included in your project:

JUnit 5: For writing and executing tests.
Mockito: For creating mocks of classes.
Test Environment
Java Version: Ensure you are running Java 8 or higher.
Build Tool: These tests are compatible with build tools like Maven or Gradle that support JUnit 5 and Mockito.
Class Description
CarQueueTest
This test class focuses on verifying the behavior of the CarQueue class. It includes methods to test various functionalities such as adding, removing, and retrieving cars from the queue, as well as interacting with a mocked ChargingStationGUI object.

## Methods
setUp(): Initializes the test environment before each test. It creates a mock of ChargingStationGUI and a new instance of CarQueue. It also clears the queue to ensure a fresh start for each test.
testAddCar(): Tests the addition of a car to the queue and checks if the queue size increases accordingly. It also verifies that the GUI is updated.
testGetNextCar(): Tests the retrieval of the next car from the queue and ensures the queue size decreases. It also verifies the number of times the GUI is updated.
testQueueSizeAfterInitialization(): Checks the queue size immediately after initialization to ensure it starts empty.
testReturnCar(): Tests the functionality of returning a car to the queue and checks if the queue size is updated correctly. Verifies GUI updates.
testRemoveCar(): Tests the removal of a car from the queue and ensures the queue size decreases. Verifies the frequency of GUI updates.
