package com.Revature.StudentManagementApp.repositories;

import com.Revature.StudentManagementApp.models.Courses;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;


public class CourseRepository implements CrudRepository<Courses>{


    public Courses findByCourseCode(String course_code) {


        String uri = "mongodb://TestUser:revature@3.238.219.255/jose_project_0";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("jose_project_0");
            MongoCollection<Document> collection = database.getCollection("courses");
            javax.swing.text.Document doc = (javax.swing.text.Document) collection.find(eq("name", "Canvas")).first();
            System.out.println(doc);

        }





        return null;



    }

    @Override
    public Courses findById(int id) {
        return null;
    }

    @Override
    public Courses save(Courses newResource) {
        return null;
    }

    @Override
    public boolean update(Courses updatedResource) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
