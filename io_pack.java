// construct a java program using java input output package
import java.io.*;

public class FileReadWrite {

    public static void main(String[] args) {
        String fileName = "student_data.txt";

        // Writing to the file
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Student Name: Alice Johnson\n");
            writer.write("Roll Number: 101\n");
            writer.write("Department: Computer Science\n");
            writer.close();
            System.out.println("Data has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred during writing: " + e.getMessage());
        }

        // Reading from the file
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            System.out.println("\nReading data from " + fileName + ":");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred during reading: " + e.getMessage());
        }
    }
}
