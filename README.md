# Basic Java Practice App: Device Management System

## Overview

This Java application serves as a simple device management system, allowing users to perform various operations such as listing devices, adding new devices, editing existing device information, searching for devices by name, checking out devices, and checking in devices. Developed as part of the CSE 340 course by Shareen Bailey during the Summer session B, this application exemplifies basic Java programming concepts, object-oriented design, and interaction with the console.

## Files Description

The application consists of three main Java files:

1. **Device.java** - Defines the `Device` class with properties such as SKU, name, and availability status. This class is the backbone of the system, representing the devices managed by the application. It also contains the `displayMenu` method, which initiates the application's user interface.

2. **Setup.java** - Contains the `Setup` class, which acts as the application's backend logic. It manages a list of devices and includes methods to perform actions like listing all devices, adding a new device, editing device details, searching for devices, and changing the availability status of the devices.

3. **MP2Driver.java** - Serves as the entry point of the application, invoking the `displayMenu` method of the `Device` class to start the user interaction process.

## Getting Started

To run this application, ensure you have a Java Development Kit (JDK) installed on your system. Follow these steps:

1. Download the Java files (`Device.java`, `Setup.java`, and `MP2Driver.java`) to your local machine.

2. Compile the Java files using the following command in your terminal or command prompt:

   ```
   javac Device.java Setup.java MP2Driver.java
   ```

3. Run the application by executing the command:

   ```
   java MP2Driver
   ```

4. Follow the on-screen prompts to interact with the device management system.

## Features

- **List Devices by Title**: Displays all devices along with their details (SKU, name, availability).
- **Add New Devices**: Allows adding a new device to the system.
- **Edit Device Information**: Enables editing the details of an existing device.
- **Search by Device Name**: Search for devices by their name or a substring of their name.
- **Check Out Devices**: Mark a device as checked out (not available).
- **Check In Devices**: Mark a device as checked in (available).
- **Exit**: Exits the application.
