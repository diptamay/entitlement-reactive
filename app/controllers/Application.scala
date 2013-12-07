package controllers

import play.api.mvc.{Action, Controller}
import akka.actor.Props
import actors.EntitlementActor
import akka.pattern.ask
import play.api.libs.json.Json
import play.api.Play.current
import play.api.libs.concurrent.Akka
import model.{EntitlementResult, CheckEntitlement}
import akka.util.Timeout
import scala.concurrent._
import ExecutionContext.Implicits.global

object Application extends Controller {

  val entitlementActor = Akka.system.actorOf(Props[EntitlementActor])

  def index = Action {
    Ok(views.html.index("Entitlement Checker"))
  }

  def isEntitled(isbn: String, studentId: String) = {
    implicit val fiveSec = Timeout(5000)
    Action.async {
      entitlementActor ? CheckEntitlement(isbn, studentId) map {
        case er: EntitlementResult => Ok(Json.toJson(er)).withHeaders(CONTENT_TYPE -> "application/json")
        case None => Status(404)
      }
    }
  }
}