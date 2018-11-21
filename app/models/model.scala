package models

final case class User(name: String, age: Int, countryOfResidence: String)
final case class Users(users: Seq[User])
