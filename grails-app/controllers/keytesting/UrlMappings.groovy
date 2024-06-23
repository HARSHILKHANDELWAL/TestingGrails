package keytesting

class UrlMappings {
    static mappings = {


        "/book/$uuid?"(action:"index",controller:"Book",method:"POST")
        "/author"(action:"index",controller:"Author")
        "/author"(action:"getAllUser",controller:"Author")

        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}