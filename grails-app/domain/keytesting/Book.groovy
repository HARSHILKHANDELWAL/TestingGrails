package keytesting

import grails.gorm.annotation.Entity

@Entity
class Book {
    String id
    String title
    String description
    Author author
    String createdOn
    String createdBy
    static constraints = {
        // version false // Uncomment if you don't want versioning
        createdOn(nullable: true)
        createdBy(nullable: false)
    }

    static belongsTo = [author: Author]

    static mapping = {
        id generator: 'uuid'
        id column: 'uuid'
        author column: 'author_id' // This specifies the foreign key column
        author cascade: 'all'


    }
}