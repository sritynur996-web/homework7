package Task4;

import java.io.File;
import java.util.Scanner;

class DirectoryAnalyzer {

    // Recursive function to calculate total size
    public long getDirectorySize(File directory) {
        long totalSize = 0;

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    totalSize += file.length(); // file size add
                } else if (file.isDirectory()) {
                    totalSize += getDirectorySize(file); // recursive call for subfolder
                }
            }
        }
        return totalSize;
    }

    // Additional: Print size of each directory
    public void printDirectorySizes(File directory, String indent) {
        long size = getDirectorySize(directory);
        System.out.printf("%s%s : %.2f MB, %.2f KB, %d Bytes\n",
                indent, directory.getName(),
                size / (1024.0 * 1024.0),
                size / 1024.0,
                size);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printDirectorySizes(file, indent + "  "); // go deeper
                }
            }
        }
    }
}

public class task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DirectoryAnalyzer analyzer = new DirectoryAnalyzer();

        System.out.print("Enter directory name/path: ");
        String path = sc.nextLine();

        File directory = new File(path);

        // Check if directory exists
        if (!directory.exists()) {
            System.out.println("Error: Directory does not exist.");
        } else if (!directory.isDirectory()) {
            System.out.println("Error: The path is not a directory.");
        } else {
            long totalSize = analyzer.getDirectorySize(directory);

            System.out.println("\nTotal size of directory:");
            System.out.printf("Megabytes: %.2f MB\n", totalSize / (1024.0 * 1024.0));
            System.out.printf("Kilobytes: %.2f KB\n", totalSize / 1024.0);
            System.out.printf("Bytes: %d Bytes\n", totalSize);

            System.out.println("\n--- Size of each subdirectory ---");
            analyzer.printDirectorySizes(directory, "");
        }

        sc.close();
    }
}