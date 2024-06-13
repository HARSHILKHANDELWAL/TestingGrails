package keytesting

import grails.gorm.annotation.Entity

@Entity
class Author {
 String id;
    String name
    String createdOn
    String createdBy
    static mapping = {
        id generator: 'uuid'
        id column: "uuid"
        createdBy column: 'created_by'

    }
    static constraints = {
//        version false
        createdOn(nullable: true)
        createdBy(nullable: true)

    }

}