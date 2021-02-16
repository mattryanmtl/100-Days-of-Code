public class DayThree {

    public static void main(String[] args) {

        System.out.println(hexColor(255, 99, 71));
    }

    public static String hexColor(int a, int b, int c) {

        String aHex = "#" + Integer.toHexString(a);
        String bHex = Integer.toHexString(b);
        String cHex = Integer.toHexString(c);

        if (a == 0) {
            aHex = aHex.concat("0");
        }
        if (b == 0) {
            bHex = bHex.concat("0");
        }
        if (c == 0) {
            cHex = cHex.concat("0");
        }

        return aHex.concat(bHex).concat(cHex).toUpperCase();

    }
}
