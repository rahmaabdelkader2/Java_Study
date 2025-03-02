public class Pattern {
    public static void main(String[] args) {
        int n = 4; // Number of rows
        int spaceBetween = 8; // Adjust this to increase the gap

        for (int i = 1; i <= n; i++) {
            // Print left-aligned stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println(); // Move to the next line
        }
    }
}
