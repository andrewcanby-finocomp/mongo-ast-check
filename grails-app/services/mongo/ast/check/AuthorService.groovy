package mongo.ast.check

import grails.gorm.transactions.Transactional
import groovy.util.logging.Slf4j

@Slf4j
@Transactional
class AuthorService {

    long countAuthors() {
        long count = Author.collection.countDocuments()
        log.debug("Got {} documents", count)
        return count
    }
}
