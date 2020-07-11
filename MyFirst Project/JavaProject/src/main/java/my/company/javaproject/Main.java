/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.company.javaproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author ShackM
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\ShackM\\Desktop\\JavaProjects\\MyFirst Project\\text.txt");
           
        Random rand = new Random();
        FileWriter writer = new FileWriter (file, false );
        int count = 10;
        for (int i=0;i<count;i++){
            writer.write(rand.nextInt(4)+2);
        }
        writer.close();
        
        List<Integer> grades = new ArrayList<>();
        
        FileReader in = new FileReader (file); 
        Integer num;
        while((num = in.read()) != -1 ){
            grades.add(num);
        }
        grades.forEach(n -> {
            System.out.println("Grade: " + n);
        });
        in.close();
    }
    
}
