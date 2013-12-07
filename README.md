# A Full Fledged Reactive Application using Play, Akka and Scala #

The goal is to write an 100% async application in Scala using event handlers, actors, and futures which acts as an entitlement check service. The problem statement is simple:
- A School has students
- A School has books
- A student is entitled to having a book if the School has the book. The entitlement check service looks like `http://localhost:9000/v1/book/{isbn}/entitled/student/{studentId}`

Software­
--------
- Scala (2.10.x)
- SBT 
- Akka (2.2.x)
- Play (2.2.x)
- Futures (scala futures for Scala 2.10.x)

Features­
--------
- Accepts requests on HTTP using Play! Requests are handled asynchronously, using Play! async and Akka actors.
- Uses a database (PostgreSQL) to store domain data. This example uses the standard PostgreSQL jdbc driver. But makes DB calls using futures.
- Parallel (scatter­gather like) async operations. 
- Has a test class that runs tests (using await). Refer to `IntegrationSpec` under `test` 
- Uses the Play! evolutions plugin to setup data in PostgreSQL

Steps to Run
------------
- Prerequisite -> Have PostgreSQL installed and running locally and have a database named `entitlementdb` is available to use. This can be changed under `conf\application.conf` for property `db.default.url=db.default.url="jdbc:postgresql://localhost:5432/entitlementdb"`	
- `play run -DapplyEvolutions.default=true`	
- In browser goto `http://localhost:9000/v1/book/0385754728/entitled/student/02a31cb0-1432-11e1-8558-0b488e4fc115`
- To run tests -> `play test -DapplyEvolutions.default=true`
