import java.util.Random;
import java.util.Scanner;

public class VernamCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Prompt the user for a short message (letters and spaces only)
        System.out.print("Enter a short message (letters A-Z and spaces allowed): ");
        String message = scanner.nextLine().toUpperCase();

        // Validate input (must contain only A-Z letters and spaces)
        if (!message.matches("[A-Z ]+")) {
            System.out.println("Invalid input. Only letters A-Z and spaces are allowed.");
            return;
        }

        // Arrays to store plaintext values, pad values, and cipher values
        int[] plaintextValues = new int[message.length()];
        int[] padValues = new int[message.length()];
        int[] cipherValues = new int[message.length()];

        System.out.println("\nProcessing message...");
        System.out.printf("%-12s%-12s%-12s%-12s%n", "Letter", "Plaintext", "Pad", "Cipher");

        // Process each character in the message
        StringBuilder cipherText = new StringBuilder();
        
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);

            // Preserve spaces in the ciphertext
            if (letter == ' ') {
                cipherText.append(' ');
                System.out.printf("%-12c%-12s%-12s%-12s%n", letter, " ", " ", " ");
                continue;
            }

            // Convert letter to numeric value (A=1, B=2, ..., Z=26)
            plaintextValues[i] = letter - 'A' + 1;

            // Generate a random pad value (1–26)
            padValues[i] = random.nextInt(26) + 1;

            // Add plaintext value and pad value, apply modulo 26 to wrap around
            cipherValues[i] = plaintextValues[i] + padValues[i];
            if (cipherValues[i] > 26) {
                cipherValues[i] -= 26;
            }

            // Convert back to a letter and append to cipher text
            char cipherLetter = (char) ('A' + cipherValues[i] - 1);
            cipherText.append(cipherLetter);

            // Display the processing results
            System.out.printf("%-12c%-12d%-12d%-12d%n", letter, plaintextValues[i], padValues[i], cipherValues[i]);
        }

        System.out.println("\nEncrypted Cipher Text: " + cipherText);
        System.out.println("Your orginal text: " + message);
    }
}


// need to read 26 letters of the alpha bet.. 
// short messages will be read by user input, assigned a numeric value, given a new random pad test and pad numeric value
// pad will always be random and initial 26 letter numeric value will be different each time
// add the two values, then replace any value higher than 26 by subtracting the total by 26






import re


myDream = "During a winter, I had the opportunity to visit hawaii (from 1/3/2023 to 1/11/2022). The experience was incredibly pleasant; hawaii is such a beautiful place that I now wish I could move there and stay forever"

myDream = myDream.replace("/", "-")


hawaii_count = myDream.lower().count("hawaii")


myDream = myDream.replace("hawaii", "Hawaii")


myDream = myDream.replace("2022", "2023")


after_dot = myDream.split('.', 1)[1].strip() if '.' in myDream else ""


start_index = myDream.lower().find("during")
end_index = myDream.lower().find("hawaii") + len("hawaii")
substring = myDream[start_index:end_index].capitalize()


digit_count = sum(char.isdigit() for char in myDream)


first_w = myDream.find('w')
last_w = myDream.rfind('w')


print("Modified text:", myDream)
print("Occurrences of 'hawaii':", hawaii_count)
print("Text after the first dot:", after_dot)
print("Capitalized substring:", substring)
print("Total number of digits:", digit_count)
print("First 'w' position:", first_w)
print("Last 'w' position:", last_w)



