package com.feiralivre.api.controllers

import com.feiralivre.api.models.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/api")
class GreetingController {
    val counter: AtomicLong = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello World!")
    }
}
