package com.Revature.StudentManagementApp.util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IdGenerator {

    public static int getRandomId(){
      Random rand = new Random();

      int n = rand.nextInt(9999 - 1000) + 1000;
      return n;
    }


}


