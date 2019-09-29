package me.andreabreu

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Serializable
data class Person(val firstName: String, val lastName: String)

val json = Json(JsonConfiguration.Stable)

@Path("/hello")
class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        val harry = Person(firstName = "Harry 2", lastName = "Potter")
        return json.stringify(Person.serializer(), harry)
    }
}
