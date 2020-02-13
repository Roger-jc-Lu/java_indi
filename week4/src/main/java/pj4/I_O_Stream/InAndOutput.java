package pj4.I_O_Stream;
import java.io.*;

public final class InAndOutput {
    
    public static void main(String[] args) {
        try{
            String inputFile = args[0];
            String outputFile = args[1];
            BufferedReader input = new BufferedReader(new FileReader(inputFile));
            PrintWriter output = new PrintWriter(new FileWriter(outputFile));

            String contentLine = input.readLine();
            while (contentLine != null){
                output.println(contentLine);
                contentLine = input.readLine();
            }

            input.close();
            output.close();
        }
        catch (IOException ex){
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
