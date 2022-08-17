
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;
import java.nio.file.StandardOpenOption;

public class FileOperations {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient Details in the order PatientID,Name,Gender,DateofBirth,HealthCondition,Date of Visit:");
        String details = scanner.nextLine();
        Path fileName = Path.of("data.db");

        // Writing into the file
        System.out.println("\nWriting the data into the file...\n");
        Files.writeString(fileName, details+"\n", StandardOpenOption.APPEND);

        // Reading the content of the file
        System.out.println("Reading the data into the file...\n");
        String file_content = Files.readString(fileName);

        // Printing the content inside the file
        System.out.println("*************** Data Content ****************\n");
        System.out.println("Enter name to see records:");
        Scanner input = new Scanner(System.in);
        String name = scanner.nextLine();

        String[] dataRows = file_content.split("[\n]");
        for (int i = 0; i < dataRows.length; i++) {
            String row = dataRows[i];
            String[] col = row.split("[,]");
            if (Objects.equals(col[1], name)){
                for (int j = 0; j < col.length; j++){
                    System.out.print(col[j]+"\t");
                }
                System.out.print("\n");
            }
        }

        /*
        String[] dataRows = file_content.split("[\n]");
        for (int i = 0; i < dataRows.length; i++) {
            String row = dataRows[i];
            String[] col = row.split("[,]");
            for (int j = 0; j < col.length; j++){
                System.out.print(col[j]+"\t");
            }
            System.out.print("\n");
        }
         */
    }
}
