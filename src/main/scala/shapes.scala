package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Ellipse(w, h) | Location(x, y, Shape) | Group(Shape*) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Ellipse(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)

object Shape:
  /** Factory method for Rectangle with validation */
  def rectangle(width: Int, height: Int): Rectangle =
    require(width >= 0, "Rectangle width must be non-negative")
    require(height >= 0, "Rectangle height must be non-negative")
    Rectangle(width, height)
  
  /** Factory method for Ellipse with validation */
  def ellipse(width: Int, height: Int): Ellipse =
    require(width >= 0, "Ellipse width must be non-negative")
    require(height >= 0, "Ellipse height must be non-negative")
    Ellipse(width, height)
  
  /** Factory method for Group with validation */
  def group(shapes: Shape*): Group =
    require(shapes.nonEmpty, "Group must contain at least one shape")
    Group(shapes*)
