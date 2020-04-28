---
layout: docs
title:  "Automatic derivation"
---

### Automatic Derivation

It is also possible to derive `Encoder`s and `Decoder`s for many types with no boilerplate at all. Circe uses [shapeless](https://github.com/milessabin/shapeless) to automatically derive the necessary type class instances:

```scala mdoc
import io.circe013.generic.auto._, io.circe013.syntax._

case class Person(name: String)
case class Greeting(salutation: String, person: Person, exclamationMarks: Int)

Greeting("Hey", Person("Chris"), 3).asJson
```
