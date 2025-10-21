package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object height extends LazyLogging:
  
  /** Computes the height (depth) of a shape tree */
  def apply(s: Shape): Int = 
    logger.debug(s"Computing height for shape: $s")
    val result = s match
      case Rectangle(_, _) => 1
      case Ellipse(_, _) => 1
      case Location(_, _, shape) => 1 + apply(shape)
      case Group(shapes*) => 
        if shapes.isEmpty then 1
        else 1 + shapes.map(apply).max
    
    logger.debug(s"Height result: $result")
    result

end height

