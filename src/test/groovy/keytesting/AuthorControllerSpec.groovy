package keytesting

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class AuthorControllerSpec extends Specification implements ControllerUnitTest<AuthorController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
