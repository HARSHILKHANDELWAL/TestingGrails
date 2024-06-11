package keytesting

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AuthorSpec extends Specification implements DomainUnitTest<Author> {

     void "test domain constraints"() {
        when:
        Author domain = new Author()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
