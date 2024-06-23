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
//        book fetch: 'join'  // Ensure books are eagerly fetched
     book lazy:false
    }
    static hasMany=[book:Book]
    static constraints = {
//        version false
        createdOn(nullable: true)
        createdBy(nullable: true)

    }

}