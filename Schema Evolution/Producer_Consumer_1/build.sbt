name := "AvroTest"

val repositories = Seq(
    "confluent" at "https://packages.confluent.io/maven/",
    Resolver.sonatypeRepo("public")
)
                                            
libraryDependencies ++= Seq(
    "org.apache.avro" % "avro" % "1.10.2",
    "io.confluent" % "kafka-avro-serializer" % "5.3.0",
    "org.apache.kafka" % "kafka-clients" % "2.8.0"
     exclude("javax.jms", "jms")
     exclude("com.sun.jdmk", "jmxtools")
     exclude("com.sun.jmx", "jmxri")
     exclude("org.slf4j", "slf4j-simple")
)
                                            
resolvers += "confluent" at "https://packages.confluent.io/maven/"
