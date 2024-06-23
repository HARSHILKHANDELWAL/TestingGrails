package keytesting

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.rest.RestfulController
import groovy.sql.Sql

import javax.sql.DataSource

@Transactional
class BookController extends RestfulController<Book> {
    static responseFormats = ['json', 'xml']

    BookController() {
        super(Book)
    }
    DataSource dataSource


    def index() {
        Sql sql = new Sql(dataSource)
        def userId="fdfdffdf"
        try {
            // Set the session variable
            def body=request.JSON
 

//            def ans1= Book.get(ans.id)

            def book = new Book(body)
            def ans=book.save(flush: true);
            print(body as JSON)
            render(ans as JSON)

        } finally {
            sql.close()
        }


    }}