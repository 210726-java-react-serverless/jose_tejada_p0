package com.Revature.StudentManagementApp.repositories;

import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;
import com.Revature.StudentManagementApp.util.MongoConnection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import static com.mongodb.client.model.Filters.eq;

public class FacultyRepository implements CrudRepository<Faculty> {


    public Faculty findById(int id) {
        return null;
    }


    public Faculty save(Faculty user) {
        MongoConnection cm = MongoConnection.getInstance();
        MongoClient mongoClient = cm.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        MongoCollection<Document> usersCollection = p0.getCollection("facultyy");

        Document addressdoc = new Document("number", user.getUser().getAddress().getNumber())
                                    .append("street", user.getUser().getAddress().getStreet())
                                    .append("city", user.getUser().getAddress().getCity())
                                    .append("state", user.getUser().getAddress().getState())
                                    .append("country", user.getUser().getAddress().getCountry())
                                    .append("zip_code", user.getUser().getAddress().getZip_code());

        Document newUserDoc = new Document("first_name", user.getUser().getFirst_name())
                .append("last_name", user.getUser().getLast_name())
                .append("DOB", user.getUser().getDOB())
                .append("phone_num", user.getUser().getPhone_num())
                .append("user_name", user.getUser().getUser_name())
                .append("password", user.getUser().getPassword())
                .append("email", user.getUser().getEmail())
                .append("address", addressdoc);



        Document facultyDoc = new Document("Salary", user.getSalary())
                .append("Department", user.getDepartment())
                .append( "user", newUserDoc);

        usersCollection.insertOne(facultyDoc);



        user.setId(facultyDoc.get("_id").toString());
        System.out.println(user);
        return user;
    }

    @Override
    public boolean update(Faculty updatedResource) {
        return false;
    }


    public boolean update(Student updatedResource) {
        return false;
    }


    public boolean deleteById(int id) {
        return false;
    }

    public Faculty findUserByCredentials(String username, String password) {
        MongoConnection mc = MongoConnection.getInstance();
        MongoClient mongoClient = mc.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        Student student = null;
        MongoCollection<Document> usersCollection = p0.getCollection( "faculty");
//        Document queryDoc = new Document("user.user_name", username).append("user.password", password);
//        Document authUserDoc = usersCollection.find(queryDoc).first();
        Document doc = usersCollection.find(eq("user.user_name", username)).first();
        System.out.println(doc);
        if (doc == null) {
            return null;
        }else {
        }
        return new Faculty();

    }


    }
