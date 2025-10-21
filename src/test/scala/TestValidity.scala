package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import Shape.*

class TestValidity extends AnyFunSuite:

  test("Rectangle with negative width should fail"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(-10, 20)

  test("Rectangle with negative height should fail"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(10, -20)

  test("Ellipse with negative width should fail"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(-10, 20)

  test("Ellipse with negative height should fail"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(10, -20)

  test("Group with no shapes should fail"):
    assertThrows[IllegalArgumentException]:
      Shape.group()

  test("Rectangle with zero dimensions should succeed"):
    val r = Shape.rectangle(0, 0)
    assert(r.width == 0)
    assert(r.height == 0)

  test("Valid Rectangle should succeed"):
    val r: Rectangle = Rectangle(10, 20)
    assert(r.width == 10)
    assert(r.height == 20)

  test("Valid Ellipse should succeed"):
    val e: Ellipse = Ellipse(10, 20)
    assert(e.width == 10)
    assert(e.height == 20)

  test("Valid Group should succeed"):
    val g: Group = Group(Rectangle(10, 20))
    assert(g.shapes.length == 1)

end TestValidity

