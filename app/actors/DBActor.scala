package actors

import akka.actor.Actor
import model.{EntitlementResult, CheckEntitlement}
import scala.concurrent._
import play.api.db.DB
import anorm._
import anorm.SqlParser._
import akka.pattern.pipe
import ExecutionContext.Implicits.global
import play.Logger

/**
 * @author Diptamay Sanyal
 * @version 1.0
 */
class DBActor extends Actor {

  import play.api.Play.current

  lazy val selectEntitlement =
    """
      SELECT COUNT(*) FROM school_student as ss, school_book as sb
      WHERE ss.school_id = sb.school_id
      AND sb.isbn = {isbn}
      AND ss.student_id = {studentId}
    """

  def receive: Receive = {
    case CheckEntitlement(isbn, studentId) =>
      future {
        DB.withConnection {
          implicit connection =>
            Logger.debug(s"isbn: $isbn AND studentId: $studentId")
            val count = SQL(selectEntitlement).on("isbn" -> isbn, "studentId" -> studentId).as(scalar[Long].single)
            var entitled = false
            if (count > 0) entitled = true
            EntitlementResult(isbn, studentId, entitled)
        }
      } pipeTo sender
  }

}
