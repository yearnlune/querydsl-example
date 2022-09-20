dependencies {
    /* SPRING */
    implementation(Dependency.Spring.WEB)
    implementation(Dependency.Spring.MONGODB)
    kapt(Dependency.Spring.CONFIGURATION_PROCESSOR)

    /* MONGODB */
    implementation(Dependency.DB.MONGO_DRIVER)

    /* QUERYDSL */
    implementation(Dependency.QueryDSL.MONGODB)
    kapt(Dependency.QueryDSL.APT)

    /* TEST */
    testImplementation(Dependency.DB.EMBEDDED_MONGO)
}

kapt {
    annotationProcessor("org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor")
}