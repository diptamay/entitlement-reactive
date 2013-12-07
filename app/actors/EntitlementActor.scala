package actors

import model.CheckEntitlement

import akka.actor.{Props, Actor}
import akka.pattern.ask
import akka.pattern.pipe
import akka.util.Timeout

import scala.concurrent._
import ExecutionContext.Implicits.global

class EntitlementActor extends Actor {

  val dbActor = context.actorOf(Props[DBActor])

  def receive: Receive = {
    case CheckEntitlement(isbn, studentId) => {
      implicit val fiveSec = Timeout(5000)
      dbActor ? CheckEntitlement(isbn, studentId) pipeTo sender
    }
  }
}