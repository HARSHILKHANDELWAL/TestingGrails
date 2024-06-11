package keytesting

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController
@Transactional
class BookController extends RestfulController<Book> {
    static responseFormats = ['json', 'xml']

    BookController() {
        super(Book)
    }

    @Override
    def index() {
        def json = request.JSON
        def book = new Book(json)

        if (book.save(flush: true)) {
            render book
        } else {
            render book.error
        }
    }
}