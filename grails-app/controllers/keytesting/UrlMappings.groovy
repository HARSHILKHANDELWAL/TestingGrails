package keytesting

class UrlMappings {
    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/book"(action:"index",controller:"Book")
        "/author"(action:"index",controller:"Author")

        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}