
import org.junit.runner.RunWith

import org.specs2.runner.JUnitRunner
import play.api.test._

import play.api.libs.ws._

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends PlaySpecification {

  "Application" should {

    "work from within a browser" in new WithBrowser {
      browser.goTo("http://localhost:" + port)
      browser.pageSource must contain("Entitlement Checker")
    }

    "return entitled=true" in new WithServer {
      val wsURL = "http://localhost:" + port + "/v1/book/0385754728/entitled/student/02a31cb0-1432-11e1-8558-0b488e4fc115"
      // await is from play.api.test.FutureAwaits
      await(WS.url(wsURL).get()).status must equalTo(OK)
    }

    "return entitled=false" in new WithServer {
      val wsURL = "http://localhost:" + port + "/v1/book/0385754728/entitled/student/02a31cb0-1432-11e1-8558-0b488e4fc115"
      // await is from play.api.test.FutureAwaits
      await(WS.url(wsURL).get()).status must equalTo(OK)
    }
  }
}
