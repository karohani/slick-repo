package com.byteslounge.slickrepo.domain

import com.byteslounge.slickrepo.meta.Entity
import com.byteslounge.slickrepo.meta.Keyed
import slick.driver.H2Driver.api._

case class Person(override val id: Option[Int] = None, name: String) extends Entity[Int]

class Persons(tag: slick.lifted.Tag) extends Table[Person](tag, "PERSON") with Keyed[Int] {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  
  def * = (id.?, name) <> ((Person.apply _).tupled, Person.unapply _)
}