package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object scale extends LazyLogging:
  
  /** Recursively scales the dimensions of a shape by a given factor */
  def apply(factor: Double)(s: Shape): Shape = 
    logger.debug(s"Scaling shape by factor $factor: $s")
    val result = s match
      case Rectangle(w, h) => 
        Rectangle((w * factor).toInt, (h * factor).toInt)
      
      case Ellipse(w, h) => 
        Ellipse((w * factor).toInt, (h * factor).toInt)
      
      case Location(x, y, shape) => 
        Location((x * factor).toInt, (y * factor).toInt, apply(factor)(shape))
      
      case Group(shapes*) => 
        Group(shapes.map(apply(factor))*)
    
    logger.debug(s"Scaled result: $result")
    result

end scale

