package keytesting

import grails.gorm.annotation.Entity

@Entity
class Author {
 String id;
    String name
    static mapping = {
        id generator: 'uuid'
        id column: "uuid"
    }
    static constraints = {
//        version false

    }
    static hasMany = [books: Book]
}