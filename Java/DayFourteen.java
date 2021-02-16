import java.util.Scanner;
import java.io.*;

public class Day14 {

    public static void main(String[] args) {
        //string to store the first half of the HTML code
        String TopHalf = "<!DOCTYPE html>\n<html>\n<head>\n<title></title>\n</head>\n\n<body>\n<p>" ;
        //string to store the second half of the HTML code
        String Bottom = "</p>\n</body>\n</html>" ;
        //empty string that will later accept the user's input
        String Paragraph = "";

        //setup a way to get user input
        Scanner input = new Scanner(System.in);

        //get a name for the file
        System.out.println("Please name your file: ");
        System.out.println("(.html is automatically appended)");
        String fileName = input.nextLine();

        //get the paragraph
        System.out.print("Please enter your paragraph: ");
        Paragraph = input.nextLine();

        //create and write to the file
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName + ".html")))) {
            writer.write(TopHalf + Paragraph + Bottom);
        } catch (IOException ex){
            System.err.println("Problem writing to the file " + fileName + ".html");
        }
    }
}
