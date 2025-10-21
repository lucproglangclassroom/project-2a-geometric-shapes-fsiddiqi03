package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestBoundingBox extends AnyFunSuite:

  def testBoundingBox(description: String, s: Shape, x: Int, y: Int, width: Int, height: Int): Unit =
    test(description):
      val Location(u, v, Rectangle(w, h)) = boundingBox(s): @unchecked
      assert(x == u)
      assert(y == v)
      assert(width == w)
      assert(height == h)

  testBoundingBox("simple ellipse", simpleEllipse, -25, -15, 50, 30)
  testBoundingBox("simple rectangle", simpleRectangle, 0, 0, 80, 120)
  testBoundingBox("simple location", simpleLocation, 70, 30, 80, 120)
  testBoundingBox("basic group", basicGroup, -25, -15, 50, 55)
  testBoundingBox("simple group", simpleGroup, 175, 85, 325, 265)
  testBoundingBox("complex group", complexGroup, 40, 80, 460, 285)

end TestBoundingBox
