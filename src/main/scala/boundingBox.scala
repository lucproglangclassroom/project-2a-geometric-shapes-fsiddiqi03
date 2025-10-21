package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object boundingBox extends LazyLogging:
  
  def apply(s: Shape): Location = 
    logger.debug(s"Computing bounding box for shape: $s")
    val result: Location = s match
      case Rectangle(w, h) => 
        Location(0, 0, Rectangle(w, h))
      
      case Ellipse(w, h) => 
        // Ellipse centered at origin, so bounding box starts at negative half dimensions
        Location(-w / 2, -h / 2, Rectangle(w, h))
      
      case Location(x, y, shape) =>
        // Get bounding box of inner shape and translate it
        val Location(innerX, innerY, Rectangle(w, h)) = apply(shape): @unchecked
        Location(x + innerX, y + innerY, Rectangle(w, h))
      
      case Group(shapes*) =>
        // Calculate bounding box that encompasses all shapes using foldLeft
        val boxes = shapes.map(apply)
        
        // Extract coordinates for all boxes
        val coords = boxes.map { case Location(x, y, Rectangle(w, h)) => (x, y, x + w, y + h) }
        
        // Use foldLeft to find min/max coordinates in one pass
        val (minX, minY, maxX, maxY) = coords.foldLeft((Int.MaxValue, Int.MaxValue, Int.MinValue, Int.MinValue)) {
          case ((accMinX, accMinY, accMaxX, accMaxY), (x, y, x2, y2)) =>
            (accMinX.min(x), accMinY.min(y), accMaxX.max(x2), accMaxY.max(y2))
        }
        
        Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
    
    logger.debug(s"Bounding box result: $result")
    result

end boundingBox
