public class Print_patterns2 {
    public static void main(String[] args) {
        int midpoint = 4;
        for (int row = 1; row <= 10; row++){
            if (row%2==1) {
                for (int i = 1; i<=midpoint; i++){
                    System.out.print(" ");
                }
                for (int cols = 1; cols <= row; cols++) {
                    System.out.print(row);
                }
                System.out.println();
                midpoint -= 1;
            }
        }

        for (int row = 10; row >= 1; row--){
            if (row%2==1) {
                midpoint += 1;
                for (int i = 1; i<=midpoint; i++){
                    System.out.print(" ");
                }
                for (int cols = 1; cols <= row; cols++) {
                    System.out.print(row);
                }
                System.out.println();
            }
        }
    }
}
