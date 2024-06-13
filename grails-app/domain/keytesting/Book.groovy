package keytesting

import grails.gorm.annotation.Entity
import org.hibernate.annotations.Type

@Entity
class Book {
//    @Type(type = "pg-uuid")
    String id // This will be mapped to the UUID column in the database
    String title
    String description
    static transients = ['version']  // Declare as transient property
    static constraints = {
        // Allow id to be nullable and blank
        id nullable: true, blank: true
        title blank: false, maxSize: 255
        description nullable: true
    }

    static mapping = {
        // Specify the column type as UUID
        id column: 'uuid', generator: 'uuid' // Specify the column type as UUID and generator as assigned
        version false // Disable versioning if not needed

    }
}
