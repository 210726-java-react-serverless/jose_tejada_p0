package com.Revature.StudentManagementApp.repositories;

import com.Revature.StudentManagementApp.models.Faculty;
import com.Revature.StudentManagementApp.models.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FacultyRepository implements CrudRepository<Faculty> {

    private File dataSource;
    public FacultyRepository(String dataSourcePath) {
        dataSource = new File(dataSourcePath);
    }



    public Faculty findById(int id) {
        return null;
    }


    public Faculty save(Faculty user) {
        File dataSource = new File("src/main/resources/data.txt");
        System.out.println(user);

        try {
            FileWriter writer = new FileWriter(dataSource, true);// TODO this will need to be fixed, as all users will have the same id.
            writer.write(user.toFile());
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

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
        dataSource = new File("src/main/resources/data.txt");
        Faculty user = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(dataSource))){

            String str = reader.readLine();
            while(str != null) {

                String[] parts = str.split(":");
                if(parts[4].equals(username) && parts[5].equals(password)) {
                    user = new Faculty(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    break;
                }
                str = reader.readLine();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user.equals(null))
        {
            System.out.println("User not found");

        }
        return user;
    }

}
