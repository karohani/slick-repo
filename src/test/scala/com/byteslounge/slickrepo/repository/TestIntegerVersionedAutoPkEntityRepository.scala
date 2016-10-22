package com.byteslounge.slickrepo.repository

import com.byteslounge.slickrepo.meta.{IntVersionedEntity, Versioned}
import slick.ast.BaseTypedType
import slick.driver.JdbcProfile

case class TestIntegerVersionedAutoPkEntity(override val id: Option[Int], price: Double, override val version: Option[Int]) extends IntVersionedEntity[TestIntegerVersionedAutoPkEntity, Int] {
  def withId(id: Int): TestIntegerVersionedAutoPkEntity = this.copy(id = Some(id))
  def withVersion(version: Int): TestIntegerVersionedAutoPkEntity = this.copy(version = Some(version))
}

class TestIntegerVersionedAutoPkEntityRepository(override val driver: JdbcProfile) extends VersionedRepository[TestIntegerVersionedAutoPkEntity, Int, Int](driver) {

  import driver.api._
  val pkType = implicitly[BaseTypedType[Int]]
  val versionType = implicitly[BaseTypedType[Int]]
  val tableQuery = TableQuery[TestIntegerVersionedAutoPkEntities]
  type TableType = TestIntegerVersionedAutoPkEntities

  class TestIntegerVersionedAutoPkEntities(tag: slick.lifted.Tag) extends Table[TestIntegerVersionedAutoPkEntity](tag, "TIV_APK_ENTITY") with Versioned[Int, Int] {
    def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
    def price = column[Double]("PRICE")
    def version = column[Int]("VERSION")

    def * = (id.?, price, version.?) <> ((TestIntegerVersionedAutoPkEntity.apply _).tupled, TestIntegerVersionedAutoPkEntity.unapply)
  }

}
