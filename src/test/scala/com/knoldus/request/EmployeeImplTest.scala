package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Hardik:Employee = new Employee("Hardik","Talwar",24,12000,"Intern","Knoldus","hardik.talwar@gmail.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Hardik)) thenReturn(true)
    val result = userImpl.createEmployee(Hardik)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Hardik)) thenReturn(false)
    val result = userImpl.createEmployee(Hardik)
    assert(result.isEmpty)
  }
}