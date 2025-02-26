public class Split2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Just one whole string");
            return;
        }

        String str_ip = args[0];
        int start = 0;
        int dot_position;
        
        while ((dot_position = str_ip.indexOf('.', start)) != -1) {
            System.out.println(str_ip.substring(start, dot_position));
            start = dot_position + 1;
        }

        // a5r goz2
        System.out.println(str_ip.substring(start));
    }
}
