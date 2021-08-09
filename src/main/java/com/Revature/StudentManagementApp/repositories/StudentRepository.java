package com.Revature.StudentManagementApp.repositories;
import com.Revature.StudentManagementApp.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.Revature.StudentManagementApp.util.MongoConnection;

import static com.mongodb.client.model.Filters.eq;

public class StudentRepository implements CrudRepository<Student>{





    public Student findById(int id) {
        return null;
    }


    public Student save(Student user) {
        MongoConnection mc = MongoConnection.getInstance();
        MongoClient mongoClient = mc.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        MongoCollection<Document> usersCollection = p0.getCollection("students");

        Document addressDoc = new Document("number", user.getUser().getAddress().getNumber())
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
                .append("address", addressDoc);

        Document StuDoc = new Document("major", user.getMajor())
                                .append( "user", newUserDoc);
      ;

        usersCollection.insertOne(StuDoc);


        user.setStudent_Id(StuDoc.get("_id").toString());
        System.out.println(user);

        return user;

    }


    public boolean update(Student updatedResource) {

        return false;
    }


    public boolean deleteById(int id) {
        return false;
    }

    public Student findUserByCredentials(String username, String password) {

        MongoConnection mc = MongoConnection.getInstance();
        MongoClient mongoClient = mc.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        Student student = null;
        MongoCollection<Document> usersCollection = p0.getCollection( "students");
//        Document queryDoc = new Document("user.user_name", username).append("user.password", password);
//        Document authUserDoc = usersCollection.find(queryDoc).first();
        Document doc = usersCollection.find(eq("user.user_name", username)).first();
        System.out.println(doc);
        if (doc == null) {
            return null;
        }else {
        }
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            student = mapper.readValue(doc.toJson(), Student.class);
//            student.setStudent_Id((Integer) doc.get("_id"));
//            System.out.println(student);
//        } catch (Exception y) {
//            y.printStackTrace();
//        }
//
//        return student;
        return student;
    }
}
