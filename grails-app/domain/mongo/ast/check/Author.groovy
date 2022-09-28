package mongo.ast.check

import grails.compiler.GrailsCompileStatic
import grails.mongodb.MongoEntity

/**
 * Note that autocomplete will work if I add this implements, but shouldn't be required
 *
 * Grails Doco also suggests that using `mapWith` should hint, but is only necessary in a situation
 * where both hibernate and mongo are being used, this is not the case here
 */
@GrailsCompileStatic
class Author /*implements MongoEntity<Author>*/  {
//    static mapWith = "mongo"  // this should also work, but doesn't
    String name
}
