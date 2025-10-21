package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object size extends LazyLogging:
  
  /** Counts the number of concrete leaf shapes (Rectangle and Ellipse) in a shape tree */
  def apply(s: Shape): Int = 
    logger.debug(s"Computing size for shape: $s")
    val result = s match
      case Rectangle(_, _) => 1
      case Ellipse(_, _) => 1
      case Location(_, _, shape) => apply(shape)
      case Group(shapes*) => shapes.map(apply).sum
    
    logger.debug(s"Size result: $result")
    result

end size

