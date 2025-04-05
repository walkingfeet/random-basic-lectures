---
# You can also start simply with 'default'
theme: default
# random image from a curated Unsplash collection by Anthony
# like them? see https://unsplash.com/collections/94734566/slidev
#background: https://cover.sli.dev 
# some information about your slides (markdown enabled)
title: Serialization
info: |
  ## Slides for lecture serialization
# apply unocss classes to the current slide
class: text-center
# https://sli.dev/features/drawing
drawings:
  persist: false
# slide transition: https://sli.dev/guide/animations.html#slide-transitions
transition: fade-out
# enable MDC Syntax: https://sli.dev/features/mdc
mdc: true
# open graph
# seoMeta:
#  ogImage: https://cover.sli.dev
---

# Welcome to Serialization

Encoding, serialization, marshalling <br />
Unencoding, parsing, deserialization, unmarshalling

<div class="abs-br m-6 text-xl">
  <button @click="$slidev.nav.openInEditor()" title="Open in Editor" class="slidev-icon-btn">
    <carbon:edit />
  </button>
  <a href="https://github.com/walkingfeet/random-basic-lectures" target="_blank" class="slidev-icon-btn">
    <carbon:logo-github />
  </a>
</div>
---
layout: two-cols
layoutClass: gap-16
---

# Plan

* 10 minutes - Introduction
* 20 minutes - Workshop
* 20 minutes - Presentation material
* 20 minutes - Demo code
* 10 minutes - Q&A

::right::

<Toc text-sm minDepth="1" maxDepth="2" />


---
---
 
# Sources
* [Designing Data-Intensive Applications by Martin Kleppmann - CHAPTER 4 Encoding and Evolution](https://www.amazon.com/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/1449373321)
* [Thinking in Java by Bruce Eckel - Object serialization](https://www.amazon.com/Thinking-Java-4th-Bruce-Eckel/dp/0131872486)

---
---

# What is serialization?

What task does it solve?

<div v-click>
The translation from the in-memory representation to a byte sequence is called encoding (also known as serialization or marshalling), and the reverse is called decoding (parsing, deserialization, unmarshalling).
</div>
<br>

<div v-click>
⚠️ IT HAS Nothing common with serializable level in database transactions
</div>

---
---
# Workshop

Write your own encoder/decoder for class

<<< @/snippets/serialization-sample/src/main/kotlin/com/walkingfeet/WorkshopCustomSimpleExample.kt#dataClass kotlin


<br>
<v-click>
Sample implementation

<<< @/snippets/serialization-sample/src/main/kotlin/com/walkingfeet/WorkshopCustomSimpleExample.kt#serializerImplementation kotlin
</v-click>

---
---
# Inner objects workshop
Write your own encoder/decoder for class Customer
<<< @/snippets/serialization-sample/src/main/kotlin/com/walkingfeet/WorkshopCustomInnerObjectsExample.kt#dataClass kotlin
<br>
<v-click>
Sample implementation

<<< @/snippets/serialization-sample/src/main/kotlin/com/walkingfeet/WorkshopCustomInnerObjectsExample.kt#serializerImplementation kotlin
</v-click>

<!-- It's incorrect - because one decoder have to know how many fields in another - just to highlight problems -->


--- 
---
# Java example serialization

<<< @/snippets/serialization-sample/src/test/kotlin/com/walkingfeet/java/BankCustomerSerializeJavaTest.java#serializerImplementation java

--- 
---
# Formats
* Language-specific formats (java.io.serializable, Ruby — marshal, Python — pickle etc.)
* Text encodings - Json, XML, CSV
* Binary encodings — Thrift, Protocol buffers, Avro

--- 
---
# Problems

* Reading by machine
* Reading by human
* Types — Big decimal, or file as field
* Schema as common protocol
* Versioning
* Volume

--- 
---
# Java serializable

* Language specific
* No human readable text
* Types — any, but problems with non implementing serializable
* Schema — as java file
* Versioning — no backward compatibility - serialVersionUID

---
---
# JSON/XML

* On any language
* Human readable
* Types — can be limited (Json — difficulties with binary types)
* Schema — exists, no central communication
* Versioning — custom

---
---
# CSV
* No standard based — any languages
* Human readable
* No types — string — based
* No schema
* No versioning - custom

--- 
---
# Protobuf, Avro, Thirft
* On many languages
* Not human readable — need translator
* Types — can be limited (?)
* Schema — exists, no central communication
* Versioning — in the protocol
* Volume — less than text based, bytes


---
---
# Examples

<!-- See examples in snippets/serialization-sample-->
---
layout: center
class: text-center
---

# Q&A

<PoweredBySlidev mt-10 />
