import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "render the index page" in new WithApplication {
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain("Entitlement Checker")
    }

    "send 200 on a good request" in new WithApplication {
      route(FakeRequest(GET, "/v1/books/0385754728/entitled/student/02a31cb0-1432-11e1-8558-0b488e4fc115")) must beNone
    }

    "send 404 on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/v1/books/entitled/student/02a31cb0-1432-11e1-8558-0b488e4fc115")) must beNone
    }
  }
}
