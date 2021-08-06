package com.Revature.StudentManagementApp.repositories;
import com.Revature.StudentManagementApp.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.Revature.StudentManagementApp.util.MongoConnection;
public class StudentRepository implements CrudRepository<Student>{





    public Student findById(int id) {
        return null;
    }


    public Student save(Student user) {
        MongoConnection mc = MongoConnection.getInstance();
        MongoClient mongoClient = mc.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        MongoCollection<Document> usersCollection = p0.getCollection("students");
        Document newUserDoc = new Document("first_name", user.getUser().getFirst_name())
                                    .append("last_name", user.getUser().getLast_name())
                                    .append("email", user.getUser().getEmail())
                                    .append("user_name", user.getUser().getUser_name())
                                    .append("password", user.getUser().getPassword());

        Document StuDoc = new


        if (newUserDoc == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            Student authUser = mapper.readValue(newUserDoc.toJson(), Student.class);
            authUser.setStudent_Id((Integer) newUserDoc.get("_id"));
        } catch (Exception y) {
            System.out.println(y);
        }

        System.out.println("made it in here");
        System.out.println(newUserDoc);

        user.setStudent_Id((Integer) newUserDoc.get("_id"));
        System.out.println(user);


        usersCollection.insertOne(newUserDoc);


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
        MongoCollection<Document> usersCollection = p0.getCollection("users");
        Document queryDoc = new Document("username", username).append("password", password);
        Document authUserDoc = usersCollection.find(queryDoc).first();


        if (authUserDoc == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            student = mapper.readValue(authUserDoc.toJson(), Student.class);
            student.setStudent_Id((Integer) authUserDoc.get("_id"));
            System.out.println(student);
        } catch (Exception y) {
            System.out.println();
        }

        return student;

    }
}
