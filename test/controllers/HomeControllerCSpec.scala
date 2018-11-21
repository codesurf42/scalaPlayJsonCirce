package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test.Helpers._
import play.api.test._

class HomeControllerCSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "HomeControllerC GET" should {

    val cntTypeJson = "application/json"
    val path = "/c"

    "render the index page from a new instance of controller" in {
      val controller = new HomeControllerC(stubControllerComponents())
      val home = controller.index().apply(FakeRequest(GET, path))

      status(home) mustBe OK
      contentType(home) mustBe Some(cntTypeJson)
      contentAsString(home) must include ("country")
    }

    "render the index page from the application" in {
      val controller = inject[HomeControllerC]
      val home = controller.index().apply(FakeRequest(GET, path))

      status(home) mustBe OK
      contentType(home) mustBe Some(cntTypeJson)
      contentAsString(home) must include ("name")
    }

    "render the index page from the router" in {
      val request = FakeRequest(GET, path)
      val home = route(app, request).get

      status(home) mustBe OK
      contentType(home) mustBe Some(cntTypeJson)
      contentAsString(home) must include ("country")
    }
  }
}
