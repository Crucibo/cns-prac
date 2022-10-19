import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;

public class ProductCipher {

    static void SubstitutionEncryption(String plainText, int key) {
        System.out.println("---Starting Substitution Encryption---");

        System.out.println("Your Plain Text : " + plainText);
        plainText = plainText.replace(" ", "");
        plainText = plainText.toLowerCase();
        char[] cypheredText = plainText.toCharArray();
        System.out.println("Plain Text after removing spaces :" + plainText);

        for (int i = 0; i < cypheredText.length; i++) {
            if ((int) cypheredText[i] + key >= 97 && (int) cypheredText[i] + key <= 122) {
                cypheredText[i] = (char) ((int) cypheredText[i] + key);
            }

            else if ((int) cypheredText[i] + key >= 123) {
                cypheredText[i] = (char) ((int) cypheredText[i] + key - 122 + 96);
            }

        }

        System.out.print("Ciphered Text After Substituion Cypher : ");
        System.out.println(cypheredText);
        System.out.println();
        TranspostionEncryption(cypheredText, key);
    }

    static void TranspostionEncryption(char[] cypheredText, int key) {
        char[][] TcypheredText = new char[cypheredText.length][cypheredText.length];
        int row = 0;
        int column = 0;
        System.out.println("---Starting Transpostion Encryption---");

        for (int i = 0; i < cypheredText.length; i++) {
            if (i == 0) {
                TcypheredText[row][column] = cypheredText[i];

                row++;
            }
            if (i != 0) {
                TcypheredText[row][column] = cypheredText[i];
                if (row + 1 >= key) {
                    row = 0;
                    column++;
                } else {
                    row++;
                }
            }

        }

        System.out.println("");
        for (int i = 0; i < TcypheredText[column].length; i++) {
            for (int j = 0; j < TcypheredText[row].length; j++) {
                if ((int) TcypheredText[j][i] != 0) {
                    System.out.print(TcypheredText[j][i] + " ");
                }
            }
            System.out.println();
        }
        String TraCypheredText = "";
        for (int i = 0; i < TcypheredText[column].length; i++) {
            for (int j = 0; j < TcypheredText[row].length; j++) {
                if ((int) TcypheredText[i][j] != 0) {
                    TraCypheredText = TraCypheredText + TcypheredText[i][j];
                }

            }
        }
        System.out.println("Ciphered Text After Keyless Transpostion Cypher: " + TraCypheredText);
        System.out.println();

        TranspostionDecryption(TcypheredText, key, column, row);
    }

    static void TranspostionDecryption(char[][] TcypheredText, int key, int column, int row) {
        System.out.println("---Starting Transpostion Decryption---");
        String DeTra = "";

        for (int i = 0; i < TcypheredText[column].length; i++)

        {
            for (int j = 0; j < TcypheredText[row].length; j++) {
                if ((int) TcypheredText[j][i] != 0) {
                    DeTra = DeTra + String.valueOf(TcypheredText[j][i]);
                }
            }
        }

        System.out.println("After Decryption of Transpositon Cypher, Cypher Text is : " + DeTra);
        System.out.println();

        SubstitutionDecryption(DeTra, key);
    }

    static void SubstitutionDecryption(String Detra, int key) {
        System.out.println("---Starting Subsitution Decryption---");
        char[] plainText = Detra.toCharArray();

        for (int i = 0; i < plainText.length; i++) {
            if ((int) plainText[i] - key >= 97 && (int) plainText[i] - key <= 122) {
                plainText[i] = (char) ((int) plainText[i] - key);
            }

            else if ((int) plainText[i] - key <= 98) {
                plainText[i] = (char) ((int) plainText[i] - key + 122 - 96);
            }

        }

        System.out.print("After Decryption of Substitution Cypher, Plane Text is : ");
        System.out.println(plainText);
        System.out.println();
    }

    public static void main(String[] args) {
        String plainText = "";
        int key = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text which has to be encrypted: ");
        plainText = sc.nextLine();
        System.out.println("Enter the key for encryption: ");
        key = sc.nextInt();
        System.out.println();
        SubstitutionEncryption(plainText, key);

    }
}
