package keytesting

import grails.converters.JSON
import grails.core.GrailsApplication
import grails.gorm.transactions.Transactional
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired

import javax.sql.DataSource

@Transactional
class AuthorController {
@Autowired
GrailsApplication grailsApplication
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


            def author = new Author(body)
            def ans=author.save(flush: true);

            sql.execute("COMMIT")


            def ans1= author.get(ans.id)
            println ans1


            render(ans1 as JSON)

        } finally {
            sql.close()
        }


    }
}