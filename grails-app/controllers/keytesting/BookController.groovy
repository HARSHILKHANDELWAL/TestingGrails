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

            // Set session variable within the transaction block

            // Optionally, you can perform additional operations here

            // Commit the transaction
   def id=params.uuid
            println id
            def book = new Book(body)
            def ans=book.save(flush: true);
//            def ans1= Book.get(ans.id)
            def brandIdentity=[
                    id:id,
                    brand:[
                            "id":id
                    ]
                    ]
            print(brandIdentity)
            body.brandIdentity=brandIdentity
//            body.brandidentity=[
//                    "id":id
//            ] as JSON
//            body.brand=[
//                "id":id
//            ] as JSON
            print(body as JSON)
            render(ans as JSON)

        } finally {
            sql.close()
        }


    }}