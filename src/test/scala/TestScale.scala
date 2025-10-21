package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  test("scale simple ellipse by 2"):
    val scaled = scale(2.0)(simpleEllipse)
    assert(scaled == Ellipse(100, 60))

  test("scale simple rectangle by 2"):
    val scaled = scale(2.0)(simpleRectangle)
    assert(scaled == Rectangle(160, 240))

  test("scale simple location by 2"):
    val scaled = scale(2.0)(simpleLocation)
    assert(scaled == Location(140, 60, Rectangle(160, 240)))

  test("scale basic group by 0.5"):
    val scaled = scale(0.5)(basicGroup)
    assert(scaled == Group(Ellipse(25, 15), Rectangle(10, 20)))

  test("scale simple group by 1.5"):
    val scaled = scale(1.5)(simpleGroup)
    assert(scaled == Group(
      Location(300, 150, Ellipse(75, 45)),
      Location(600, 450, Rectangle(150, 75))
    ))

  test("scale by 1.0 returns same dimensions"):
    val scaled = scale(1.0)(simpleRectangle)
    assert(scaled == simpleRectangle)

end TestScale

