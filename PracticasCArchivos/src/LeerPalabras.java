import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LeerPalabras {
    public static boolean hasDigits(String worter) {
        for (char a : worter.toCharArray()) {
            if (Character.isDigit(a)) {
                return true;
            }
        }
        return false;
    }
    public static void checkWord(String worterzwei, int[] numcounters) {
        int worterLange = worterzwei.length();
        if (worterLange >= 2 && worterLange <= 10 && !hasDigits(worterzwei)) {
            int index = worterLange- 2;
            numcounters[index]++;
        }
    }
    public static void imprHisto(int[] numcounters) {
        int scale = 1000;
        for (int i = 0; i < numcounters.length; i++) {
            int worterLange = i + 2;
            System.out.print("Palabras que son de " + worterLange + " caracteres de largo: ");
            int cuenta = numcounters[i] / scale;
            for (int j = 0; j < cuenta; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String inputFilePath = "divina_comedia_sp.txt";
        int[] numcounters = new int[9];
        try (BufferedReader Leser = new BufferedReader(new FileReader(inputFilePath))) {
            String Zeile;
            while ((Zeile = Leser.readLine()) != null) {
                String[] worterdrei = Zeile.split("\\s+");
                for (String wortervier : worterdrei) {
                    checkWord(wortervier, numcounters);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        imprHisto(numcounters);
        System.out.print("\n");
        System.out.println("Cada * representa mil elementos contados.");
    }
}