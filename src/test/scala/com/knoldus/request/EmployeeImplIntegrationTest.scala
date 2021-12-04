package com.knoldus.request

import com.knoldus.db.CompanyReadTo
import com.knoldus.models.Employee
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.funsuite.AnyFunSuite


class EmployeeImplIntegrationTest extends AnyFunSuite {
  val companyName = new CompanyReadTo
  val validateEmail = new EmailValidator
  val employeeValidator = new EmployeeValidator(companyName, validateEmail)

  val employeeImpl = new EmployeeImpl(employeeValidator)

  test("User cannot be created because company does not exist"){
    val lucifer: Employee = new Employee("Tony", "Stark", 52, 10000, "Intern", "Stark International", "tony.stark@gmail.com")
    val result = employeeImpl.createEmployee(lucifer)
    assert(result.isEmpty)
  }

  test("User not created because email is invalid"){
    val Hardik: Employee = new Employee("Hardik", "Talwar", 24, 12000, "Intern", "Knoldus", "hardik.talwar@gmailcom")
    val result = employeeImpl.createEmployee(Hardik)
    assert(result.isEmpty)
  }

  test("User cannot be created because email is invalid and company does not exist in DB"){
    val lucifer: Employee = new Employee("Lucifer", "MorningStar", 22, 10000, "Intern", "GoldMan Sachs", "lucifer.morningstar@gmalcom")
    val result = employeeImpl.createEmployee(lucifer)
    assert(result.isEmpty)
  }

  test("User can be created"){
    val Hardik: Employee = new Employee("Hardik", "Talwar", 24, 12000, "Intern", "Knoldus", "hardik.talwar@gmail.com")
    val result = employeeImpl.createEmployee(Hardik)
    assert(result.isDefined)
  }

}
