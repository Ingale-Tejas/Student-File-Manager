package studentmanager.com;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class studentManager {
   public static void main() throws IOException, InterruptedException {

       Scanner sc = new Scanner(System.in);
       int choice;
       boolean running = true;
       System.out.println("Student Manager System");
       //Menu Driven Program
       while (running) {
           //System.out.println("Student Manager System");
           System.out.println("----------------------");
           System.out.println("1. Create File");
           System.out.println("2. Add Details to file ");
           System.out.println("3. View File Details");
           System.out.println("4. View Folder Structure");
           System.out.println("5. Delete File");
           System.out.println("6. Exit");
           System.out.println("-------[Choose Options]---------------");
           System.out.print("Enter Choice: ");
           choice = sc.nextInt();

           switch (choice) {
               case 1:
                   createFile();
                   break;
               case 2:
                   addDetails();
                   break;
               case 3:
                   viewDetails();
                   break;
               case 4:
                   viewFolderDetails();
                   break;

               case 5:
                   deleteFile();
                   break;

               case 6:
                   System.out.println("Program Exiting ...");
                   running = false;
                   break;
               default:
                   System.out.println("Invalid Choice");
                   break;
           }
       }
   }

    public static void createFile() throws IOException, InterruptedException {
       Scanner cf = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        String filename = cf.nextLine();

        if (!filename.endsWith(".txt")) {
            filename += ".txt";
        }

       File f = new File("D:\\1. Coding World\\2_Projects\\Personal\\JAVA\\Student-File-Manager\\StudentManager\\"+ filename);
       //f.createNewFile();
        if(f.createNewFile())
        {
           System.out.println("\nCreating " +  filename + " file, Wait for 2sec ... \n");
           f.createNewFile();
           Thread.sleep(2000);
           System.out.println("File Successfully created\n");
       }
       else
       {
           System.out.println("File Already Exists\n");
       }
    }

    public static void addDetails() throws IOException, InterruptedException {
       Scanner as = new Scanner(System.in);

        System.out.print("Enter File Name: ");
        String filename = as.nextLine();

        if (!filename.endsWith(".txt")) {
            filename += ".txt";
        }

        File f = new File ("D:\\1. Coding World\\2_Projects\\Personal\\JAVA\\Student-File-Manager\\StudentManager\\"+ filename);

        if (f.exists()) {

            FileWriter fw = new FileWriter(f, true);
            System.out.print("Add Student Name: ");
            String name = as.nextLine();
            System.out.print("Add Student RollNo: ");
            int no = as.nextInt();
            System.out.print("Add Student Age: ");
            int age = as.nextInt();
            System.out.print("Add Student Marks: ");
            double marks = as.nextDouble();
            // System.out.println("Add Student Gender: ");

            fw.write("Student Name: " + name);
            fw.write("Roll No: " + no);
            fw.write("Age: " + age);
            fw.write("Marks: " + marks);

            fw.close();
            Thread.sleep(2000);
            System.out.println("Student Details Added Successfully ...\n");
        }
        else
        {
            System.out.println("File Not Found, Please enter Valid File Name\n");
        }
    }

    public static void viewDetails() throws IOException, InterruptedException {
        Scanner view = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        String filename = view.nextLine();
       if (!filename.endsWith(".txt")) {
            filename += ".txt";
       }

       File f = new File("D:\\1. Coding World\\2_Projects\\Personal\\JAVA\\Student-File-Manager\\StudentManager\\"+ filename);
       if (f.exists())
       {
           Scanner fw = new Scanner(f);
            while (fw.hasNextLine()) {
                System.out.println(fw.nextLine());
            }

            fw.close();

       }
       else {
           System.out.println("File Not Found, Please enter Valid File Name\n");
       }
    }

    public static void viewFolderDetails() throws IOException, InterruptedException {
       Scanner sc = new Scanner(System.in);

       File f = new File("D:\\1. Coding World\\2_Projects\\Personal\\JAVA\\Student-File-Manager\\StudentManager");
               if (f.exists() && f.isDirectory()){
                   File[] files = f.listFiles(); // create array of file to store all files present inside folder!

                   System.out.println("-----File in Directory are:-----");

                   if (files.length == 0) {
                       System.out.println("The folder is Empty");
                   }
                   else {
                       for (File f1 : files) {
                           if (f1.isFile()) {
                               System.out.println(f1.getName());
                           }
                       }
//                       System.out.println(" Directory : ");
//                       for (File f1 : files) {
//                           if (f1.isDirectory()) {
//                               System.out.println(f1.getName());
//                           } }
                   }
               }
               else {
                   System.out.println("Folder Not Found");
               }

    }
    public static void deleteFile() throws IOException, InterruptedException {
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        String filename = sc.nextLine();
        if (!filename.endsWith(".txt")) {
            filename += ".txt";
        }

        File f = new File("D:\\1. Coding World\\2_Projects\\Personal\\JAVA\\Student-File-Manager\\StudentManager\\"+ filename);
        if (f.exists()){
            System.out.print("Are You Sure about Deleting a File (Y/n): ");
            String option = sc.nextLine();
            if (option.equals("Y")){
                    System.out.println("\n Deleting your file ...");
                    f.delete();
                    Thread.sleep(2000);
                    System.out.println("File Deleted Successfully\n");
                }
            else {
                System.out.println("Requested Canceled!");
            }
        }
        else {
            System.out.println("File Not Found, Please enter Valid File Name\n");
        }
   }

}

