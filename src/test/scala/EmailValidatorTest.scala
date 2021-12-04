import com.example.emailValidator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite

class EmailValidatorTest extends AnyFunSuite {
  var emailObject = new EmailValidator

  test("Without name of recipient"){
    assert(!emailObject.emailIsValid("@gmail.com"))
  }

  test("Without @ in the email"){
    assert(!emailObject.emailIsValid("hardik.talwar.gmail.com"))
  }

  test("Without domain name"){
    assert(!emailObject.emailIsValid("hardik.talwar@"))
  }

  test("Other domain name than .com| .net| .org "){
    assert(!emailObject.emailIsValid("hardik.talwar@rediffmail.in"))
  }

  test("correct one uppercase"){
    assert(emailObject.emailIsValid("HARDIK.TALWAR@REDIFFMAIL.COM"))
  }

  test("Correct one lowercase"){
    assert(emailObject.emailIsValid("hardik.talwar@rediffmail.com"))
  }

}
