package controllers


import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Akka
import akka.actor.Props
import akka.util.Timeout
import play.api.libs.json.Json

object EntitlementController extends Controller {

  def isEntitled(bookId: String, studentId:String) = Action.async {
    val cassandraActor = Akka.system.actorOf(Props(new CassandraActor(session)))

    implicit val oneSec = Timeout(1000)
    cassandraActor ? GetUser(id) map {
      case Some(u: UserProfile) =>  Ok(Json.toJson(u)).withHeaders(CONTENT_TYPE -> "application/json")
      case None => Status(404)
    }
  }
}
