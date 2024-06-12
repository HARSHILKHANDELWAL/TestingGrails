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
            sql.execute("BEGIN")

            // Set session variable within the transaction block
            sql.execute("SET LOCAL myapp.user_id = '${userId}'")

            // Optionally, you can perform additional operations here

            // Commit the transaction

            println body
            def book = new Book(body)
            println book as JSON
            println "book"

            def ans=book.save(flush: true);

            sql.execute("COMMIT")


//            def ans1= Book.get(ans.id)
            println ans as JSON


            render(ans as JSON)

        } finally {
            sql.close()
        }


    }}