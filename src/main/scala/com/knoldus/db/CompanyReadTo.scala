package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadTo {

  val knoldusCompany: Company = Company("Knoldus", "Knoldus@gmail.com", "Noida")
  val amazonCompany: Company = Company("Samsung", "samsung1716@gmail.com", "Noida")
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Amazon" -> amazonCompany)
  def getCompanyByName(name: String): Option[Company] = companies.get(name)


}
