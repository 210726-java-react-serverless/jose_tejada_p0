package com.Revature.StudentManagementApp.util;


import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;



public class MongoConnection {

    private static MongoConnection connec = null;
    private  MongoClient mongoClient;



    private MongoConnection(){

        Properties appProperties = new Properties();

        try {
            appProperties.load(new FileReader("src/main/resources/properties.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        String ipAddress = appProperties.getProperty("ipAddress");
        int port = Integer.parseInt(appProperties.getProperty("port"));
        String dbName = appProperties.getProperty("dbName");
        String dbUsername = appProperties.getProperty("dbUsername");
        String dbPassword = appProperties.getProperty("dbPassword");



        try {
            this.mongoClient = MongoClients.create(
                    MongoClientSettings.builder()
                            .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(ipAddress, port))))
                            .credential(MongoCredential.createScramSha1Credential(dbName, dbUsername, dbPassword.toCharArray()))
                            .build());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static MongoConnection getInstance() {
        if (connec == null) {
            connec = new MongoConnection();
        }
        return connec;
    }



    public MongoClient getConnection() {
        return mongoClient;
    };


}
