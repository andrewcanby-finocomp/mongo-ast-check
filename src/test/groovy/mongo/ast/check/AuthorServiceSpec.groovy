package mongo.ast.check


import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import grails.test.mongodb.MongoSpec
import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.DockerImageName

class AuthorServiceSpec extends MongoSpec implements ServiceUnitTest<AuthorService>, DomainUnitTest<Author> {

    @Override
    MongoClient createMongoClient() {
        final MongoDBContainer mongoContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"))
        mongoContainer.start()
        return MongoClients.create(mongoContainer.getConnectionString())
    }

    void "test count"() {
        given: "Some existing Authors"
        int expectedAuthors = 20

        expectedAuthors.times {
            new Author(name: "Author $it").save(flush: true)
        }

        when: "Getting the count of all Authors"
        long numberOfAuthors = service.countAuthors()

        then:
        numberOfAuthors == expectedAuthors
    }
}
