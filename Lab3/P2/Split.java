public class Split {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Just one whole string");
            return;
        }

        String str_ip = args[0];
        String[] parts = str_ip.split("\\."); 
		
        // h2sm we a4of 3adad eli 2smto
        
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }
    }
}
