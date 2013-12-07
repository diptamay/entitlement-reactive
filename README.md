# A Full Fledged Reactive Application using Play #

The goal is to write an 100% async application in Scala using event handlers, actors, and futures.

Software­
● Scala (2.10.x)
● SBT 
● Akka (2.2.x)
● Futures (scala futures for Scala 2.10.x)

Features­
● Accepts requests on either HTTP
● Uses a database (PostgreSQL) to store domain organization, resources and users.
● Parallel (scatter­gather like) async opera
● Has a test class or application entry point that runs a test (blocking/Await is OK in the

test). Should demonstrate access failures (access denied for a resource).

http://localhost:9000/v1/book/0385754728/entitled/student/02a31cb0-1432-11e1-8558-0b488e4fc115