package org.example.application

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File
import java.nio.file.Paths

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        install(CORS) {
            allowMethod(HttpMethod.Post)
            allowMethod(HttpMethod.Get)
            anyHost()
        }
        routing {
            post("/upload") {
                val text = call.receiveText()

                val filename = "receivedFile.txt"
                val currentDirectory = Paths.get("").toAbsolutePath().toString()
                val filePath = Paths.get(currentDirectory, filename).toString()

                File(filePath).writeText(text)
                call.respond(HttpStatusCode.OK, "File saved successfully")
            }
        }
    }.start(wait = true)
}