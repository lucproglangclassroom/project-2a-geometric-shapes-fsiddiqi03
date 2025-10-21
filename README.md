# Project 2a: Geometric Shapes in Scala

[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=21166915)

## Overview

This project implements a functional representation of geometric shapes in Scala 3, including various behaviors for manipulating and analyzing shape trees.

## Features Implemented

### Shape Types
- **Rectangle**: Rectangular shape with width and height
- **Ellipse**: Elliptical shape with width and height
- **Location**: Wrapper that positions a shape at (x, y) coordinates
- **Group**: Composite shape containing multiple child shapes

### Behaviors

1. **boundingBox**: Computes the minimal bounding box that encompasses a shape or group of shapes
   - Uses `map`, `min`, and `max` for functional implementation
   - Returns a `Location` containing a `Rectangle` representing the bounding box

2. **size**: Counts the number of concrete leaf shapes (Rectangle and Ellipse) in a shape tree
   - Uses `map` and `sum` for functional traversal

3. **height**: Computes the height (depth) of the shape tree
   - Uses `map` and `max` to find the deepest branch

4. **scale**: Recursively scales all dimensions of a shape by a given factor
   - Scales both shape dimensions (width/height) and positions (x/y coordinates)
   - Uses `map` for recursive application

### Validation

All shape constructors include validity checking:
- Rectangle and Ellipse dimensions must be non-negative
- Groups must contain at least one shape

### Testing

Comprehensive test suites are provided:
- **TestBoundingBox**: 6 tests for bounding box computation
- **TestSize**: 6 tests for size counting
- **TestHeight**: 6 tests for tree height
- **TestScale**: 6 tests for scaling operations
- **TestValidity**: 10 tests for constructor validation

### Logging

The project uses `scala-logging` with `logback` for configurable debug output. Set the logger level to DEBUG in `src/main/resources/logback.xml` to see detailed behavior execution traces.

## Building and Running

### Compile the project
```bash
sbt compile
```

### Run tests
```bash
sbt test
```

### Run the main application
```bash
sbt run
```

## Project Structure

```
src/
├── main/
│   ├── resources/
│   │   └── logback.xml          # Logging configuration
│   └── scala/
│       ├── shapes.scala          # Shape type definitions
│       ├── boundingBox.scala     # Bounding box behavior
│       ├── size.scala            # Size counting behavior
│       ├── height.scala          # Tree height behavior
│       └── scale.scala           # Scaling behavior
└── test/
    └── scala/
        ├── TestFixtures.scala    # Test data fixtures
        ├── TestBoundingBox.scala # Bounding box tests
        ├── TestSize.scala        # Size tests
        ├── TestHeight.scala      # Height tests
        ├── TestScale.scala       # Scale tests
        ├── TestValidity.scala    # Validity tests
        └── Main.scala            # Main entry point
```

## Design Notes

- All implementations follow functional programming principles with immutable data structures
- Pattern matching is used extensively for type-safe shape traversal
- Higher-order functions (`map`, `sum`, `min`, `max`) are used per requirements
- Logging provides insight into behavior execution without breaking immutability

## Dependencies

- Scala 3.7.3
- ScalaTest 3.2.19 (testing)
- scala-logging 3.9.5 (logging facade)
- logback-classic 1.5.15 (logging implementation)
- Doodle 0.30.0 (available for potential graphics rendering)

## Extra Credit

Extra credit features (graphical rendering with Doodle) were **not** implemented per the assignment instructions.
