package com.Revature.StudentManagementApp.repositories;

import com.Revature.StudentManagementApp.models.Courses;

import com.Revature.StudentManagementApp.util.MongoConnection;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;


public class CourseRepository implements CrudRepository<Courses>{



    @Override
    public Courses findById(int id) {
        return null;
    }

    @Override
    public Courses save(Courses course) {

        MongoConnection cm = MongoConnection.getInstance();
        MongoClient mongoClient = cm.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        MongoCollection<Document> courseCollection = p0.getCollection("courses");

        Document Coursedoc = new Document("course_name", course.getCourse_name())
                .append("course_code", course.getCourse_code())
                .append("start_date", course.getStart_date())
                .append("end_date", course.getEnd_date());


        courseCollection.insertOne(Coursedoc);

        System.out.println(Coursedoc.values());



        return course;
    }



    @Override
    public boolean update(Courses updatedResource) {


        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    public void deleteByCourseCode(String code){
        MongoConnection mc = MongoConnection.getInstance();
        MongoClient mongoClient = mc.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        MongoCollection<Document> usersCoursesCollection = p0.getCollection("courses");
        Document queryDoc = new Document("course_code", code);

        try{
            DeleteResult result = usersCoursesCollection.deleteMany(queryDoc);
            System.out.println("Removed: " + result);
        }catch(MongoException m)
        {
            System.out.println("user doesnt exist");
        }
    }

    public void updateCourse(Courses c, String field, String changeTo){
        MongoConnection mc = MongoConnection.getInstance();
        MongoClient mongoClient = mc.getConnection();

        MongoDatabase p0 = mongoClient.getDatabase("jose_project_0");
        MongoCollection<Document> usersCoursesCollection = p0.getCollection("courses");
        Document queryDoc = new Document().append("course_code", c.getCourse_code());

        Bson updates = Updates.set(field, changeTo);
        UpdateOptions options = new UpdateOptions().upsert(true);

        try{
            UpdateResult result = usersCoursesCollection.updateOne(queryDoc, updates, options);
            System.out.println("Modified document count: " + result.getModifiedCount());
            System.out.println("Upserted id: " + result.getUpsertedId());

        }catch(MongoException me)
        {
            System.err.println("Unable to update due to an error: " + me);
        }


    }

}
