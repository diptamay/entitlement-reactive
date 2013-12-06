package domain


class EntitlementService {
  lazy val selectUsingExtId = "SELECT id FROM user_profile WHERE accountType = ? and externalId = ? ALLOW FILTERING;"
  lazy val selectStatement = "SELECT id, accountType, externalId, firstName, lastName FROM user_profile WHERE id = ?;"
  lazy val insertStatement = "INSERT INTO user_profile(id, accountType, externalId, firstName, lastName) VALUES (?, ?, ?, ?, ?);"
  lazy val deleteStatement = "DELETE FROM user_profile WHERE id = ?;"

  def receive: Receive = {
    case GetUser(id) =>
      session.executeAsync(session.prepare(selectStatement).bind(id)) map (r => buildUserProfile(r.one)) pipeTo sender
  }

  def buildUserProfile(r: Row): Option[UserProfile] =
    if (r == null) // need to check for null because Row is a Java class
      None
    else
      Option(UserProfile(r.getString("id"), r.getString("accountType"), r.getString("externalId"), r.getString("firstName"), r.getString("lastName")))

}

}