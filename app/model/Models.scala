package model

import java.util.UUID
import play.api.libs.json.Json

/**
 * @author Diptamay Sanyal
 * @version 1.0
 */
case class School(id: UUID = UUID.randomUUID(), name: String)

case class Student(id: UUID = UUID.randomUUID(), name: String)

case class Book(isbn: String, name: String)

case class CheckEntitlement(isbn: String, studentId: String)

case class EntitlementResult(isbn: String, studentId: String, entitled: Boolean)

object EntitlementResult {
  // implicits to be used by Json.toJson(entitlementResult) and Json.fromJson(entitlementResult)
  implicit val implicitEntitlementFormats = Json.format[EntitlementResult]
}
