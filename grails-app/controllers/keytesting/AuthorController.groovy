package keytesting

import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class AuthorController {

    def index() {
        def body = request.JSON
        println body
        def author = new Author(body)
        def ans=author.save(flush: true);
        render(ans as JSON)

    }
}