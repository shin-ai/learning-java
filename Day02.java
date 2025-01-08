import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day02 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        // arr[2] = 3;
        // arr[3] = 4;
        // arr[4] = 5;

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Volvo");
        cars.add("Mazda");
        Collections.sort(cars);

        for (String car : cars) {
            System.out.println(car);
        }

        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }

        cars.set(0, "Ford");

        System.out.println();

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        for (Integer integer : numbers) {
            System.out.println(integer);
        }

        Integer totalInteger = 0;
        for (int i = 0; i < numbers.size(); i++) {
            totalInteger += numbers.get(i);
        }
        System.out.println("Total: " + totalInteger);

        totalInteger = 0;
        for (Integer number : numbers) {
            totalInteger += number;
        }
        System.out.println("Total: " + totalInteger);

        String nEscapeChar = "Pembekalan\nJava";
        System.out.println(nEscapeChar);
        String tEscapeChar = "Pembekalan\tJava";
        System.out.println(tEscapeChar);
        String escapeChar = "\"Football is simple. But playing simple football is the hardest thing to do\"\nJohan Cruyff";
        System.out.println(escapeChar);
        String firstName = "Muhammad";
        String surname = "Rifanny";
        System.out.println(firstName + " " + surname);
        System.out.println(firstName + "\r" + surname);

        String str = "Pembekalan";
        str.concat(" Java");
        System.out.println("Nilai dari variable str adalah "+str);

        Integer numInteger = 1;
        String numStr = String.valueOf(numInteger);
        System.out.println(numStr.getClass());

        String gigi = "tooth";
        System.out.println(gigi.replace('o','e'));
        char[] toothChar = gigi.toCharArray();
        toothChar[1] = 'e';
        System.out.println(String.valueOf(toothChar));

        String xsis = "PT. Xsis Mitra Utama 12345678 !@#$%^&*";
        System.out.println(xsis);
        System.out.println(xsis.replaceAll("[A-Za-z]", "ada"));
        System.out.println(xsis.replaceAll("[A-Za-z]+", "ada"));
        System.out.println(xsis.replaceAll("[^A-Za-z]", ""));
        System.out.println(xsis.replaceAll("[0-9]", ""));
        System.out.println(xsis.replaceAll("[^0-9]", ""));
        System.out.println(xsis.replaceAll("[^A-Za-z0-9\s]", ""));
        System.out.println(xsis.replaceAll("[A-Z&&[A-G]]", "Ada"));

        ArrayList<String> brands = new ArrayList<String>();
        brands.add("asus");
        brands.add("lenovo");
        brands.add("acer");
        brands.add("msi");
        System.out.println(String.valueOf(brands));

        Map<String, String> resMap = new HashMap<>();
        resMap.put("status", "200");
        resMap.put("message", "success");
        resMap.put("data", "asus");
        System.out.println(String.valueOf(resMap));
    }
}