package controllers

import javax.inject._
import models.{User, Users}
import play.api._
import play.api.libs.circe.Circe
import play.api.mvc._
import play.api.libs.functional.syntax._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  import play.api.libs.json._

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  implicit val userFormat = Json.format[User]
  implicit val usersFormat = Json.format[Users]
  val users = Users(Seq(User("name", 42, "country")))


  def index() = Action {
    implicit request: Request[AnyContent] =>
      Ok(Json.toJson(users))
  }


  def index2() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }


}


@Singleton
class HomeControllerC @Inject()(cc: ControllerComponents) extends AbstractController(cc) with Circe {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */

  import io.circe.generic.auto._
  import io.circe.syntax._
  
  val users = Users(Seq(User("name", 42, "country")))

  def index() = Action {
    implicit request: Request[AnyContent] =>
      Ok(users.asJson)
  }


  def index2() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }


}
