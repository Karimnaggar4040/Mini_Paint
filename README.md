# MiniPaint 

MiniPaint is a lightweight, graphical drawing application built using **JavaFX**. The project serves as a robust demonstration of core Object-Oriented Programming (OOP) principles, featuring a modular architecture that cleanly separates the drawing engine logic from the graphical user interface. 

Users can seamlessly create, customize, recolor, and manage geometric shapes on a dynamic canvas.

## Features

* **Multiple Shape Support:** Draw Circles, Rectangles, Squares, and Line Segments.
* **Precise Placement:** Define exact X and Y coordinates for shape placement.
* **Dynamic Customization:** Set unique properties for each shape (e.g., radius, width, height, length).
* **Color Management:** Fully customize both **Stroke Color** and **Fill Color** during creation or via the dedicated "Colorize" tool.
* **State Management:** A centralized `DrawingEngine` tracks all active shapes using an `ObservableList`.
* **Shape Selection & Deletion:** Select specific shapes from a dropdown menu to dynamically modify or remove them from the canvas.

---

## Object-Oriented Architecture

This project is deeply rooted in OOP principles, ensuring the codebase is scalable, maintainable, and highly cohesive.

### 1. Abstraction
* **`Shape` (Interface):** Defines the strict contract for all drawable objects, mandating methods for positioning, coloring, property mapping, and the core `draw(GraphicsContext)` action.
* **`DrawingEngine` (Interface):** Abstracts the management layer, defining how shapes are added, removed, and rendered without dictating the underlying data structures.

### 2. Inheritance
* **Geometric Hierarchy:** The abstract `GeometricShape` class implements the `Shape` interface to handle boilerplate code (position, colors, properties). Concrete classes like `Circle`, `Rectangle`, and `LineSegment` inherit from `GeometricShape` and implement their specific drawing logic. `Square` inherits directly from `Rectangle`, reusing its width/height logic.
* **UI Templating:** The abstract `AddShape` class handles the common layout, buttons, and grid setup for the shape-creation dialogs. Concrete classes (`AddCircle`, `AddRectangle`, etc.) extend it to inject shape-specific input fields (like a radius spinner vs. width/height spinners).

### 3. Polymorphism
* **Dynamic Rendering:** The `DrawingEngineImplementation` iterates through a list of generic `Shape` interfaces, calling `.draw(gc)` on each. The engine does not need to know *what* shape it is rendering; the Java runtime resolves the specific implementation (Circle, Rectangle, etc.) dynamically.
* **UI Factory Handling:** The `ComboBox` interacts with the shapes purely through their abstract names and properties, allowing universal modifications (like the `Colorize` class) to apply to any valid `Shape` object.

### 4. Encapsulation
* All internal class variables (coordinates, radii, colors, engine lists) are declared as `private`. They are exclusively accessed and modified through controlled `getter` and `setter` methods, ensuring data integrity and preventing unauthorized state changes from the UI components.

---

## Project Structure

* **Core UI:** * `MiniPaint.java`: The main JavaFX Application class containing the primary layout, canvas, and event listeners.
* **Shape Logic:** * `Shape.java` / `GeometricShape.java`: Interfaces and base classes.
  * `Circle.java`, `Rectangle.java`, `Square.java`, `LineSegment.java`: Concrete shape entities.
* **Engine:** * `DrawingEngine.java` / `DrawingEngineImplementation.java`: Handles the state, addition, deletion, and redrawing of shapes.
* **Dialog Windows:** * `AddShape.java`: Base UI layout for creation menus.
  * `AddCircle.java`, `AddRectangle.java`, `AddSquare.java`, `AddLineSegment.java`: Specific creation controllers.
  * `Colorize.java`: Dedicated window for editing existing shape colors.

---

## Getting Started

### Prerequisites
* **Java Development Kit (JDK):** Version 11 or higher.
* **JavaFX SDK:** Ensure JavaFX is properly configured in your IDE or build tool (Maven/Gradle).

### Installation & Execution
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure your JavaFX library paths and VM options are configured correctly. For example:
   ```bash
   --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
   ```
4. Run the `MiniPaint` class to launch the application.

### Usage
1. Click on one of the top buttons (Circle, Square, Rectangle, Line Segment) to open the creation dialog.
2. Input your desired dimensions, coordinates, and colors, then click **Draw**.
3. Use the dropdown menu on the left to select a previously drawn shape.
4. Click **Colorize** to change its colors, or **Delete** to remove it from the canvas.
