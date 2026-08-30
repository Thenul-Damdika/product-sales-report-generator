package salesreport;

public class Main {

    public static void main(String[] args) {

        // Check CSV path and output method are provided
        if (args.length < 2) {
            System.err.println("Usage: java SalesReporter <csv-file-path> <output-method> [output-file-path]");
            return;
        }

        String csvFilePath = args[0];
        String outputMethod = args[1];

        // Validate output method
        if (!outputMethod.equalsIgnoreCase("console")
                && !outputMethod.equalsIgnoreCase("file")) {

            System.err.println("Error: Invalid output method. Use 'console' or 'file'.");
            return;
        }

        // File output requires an output file path
        if (outputMethod.equalsIgnoreCase("file") && args.length < 3) {
            System.err.println("Error: Output file path is required when using 'file' output.");
            return;
        }

        System.out.println("Command-line arguments are valid.");
        System.out.println("CSV file: " + csvFilePath);
        System.out.println("Output method: " + outputMethod);
    }
} 