import java.util.ArrayList;

public class solution {
    public static void main(String[] args) throws Exception {
     
		// Define an array of email addresses
        String[] emails = { "jpp@gmail.com", "tom@sfr.com", "fred@hotmail.com", "paul@sfr.com", "victor@aol.com","jhon@outlook.com", "lise@yahoo.com", "mike@gmail.com", "steve@outlook.com", "jane@gmail.com" };
		// Define an array to store the provider names
        ArrayList<String> providers = new ArrayList<String>();
		// Extract the provider name from each email address and add it to the providers
		// array

        for (String email:emails) {
            int providerIndex = email.lastIndexOf("@") + 1;
            providers.add(email.substring(providerIndex, email.length()));
        }
		// Remove duplicates from the providers array
        ArrayList<String> providersShare = (ArrayList)providers.clone();

        for (int i = 0; i < providers.size(); i++){
            for (int j = 0; j < providers.size(); j++){
                String c =providers.get(j);
                if (c.equals(providers.get(i)) && i != j){
                    providers.remove(j);
                }
            }
        }

        ArrayList<String> printed = new ArrayList<>(); 
        
        for (int i = 0; i < providersShare.size(); i++){
            double occ = 0;
            for (int j = 0; j < providersShare.size(); j++){
                String c =providersShare.get(j);
                
                if (c.equals(providersShare.get(i))){
                    occ++;
                }
            }
            if (!printed.contains(providersShare.get(i))){
                double size = (double) providersShare.size();
                Double res = (double) (occ / size) * 100;

                System.out.println(String.format("%s: %.1f%%", providersShare.get(i), res));
                System.out.println();
            }
            printed.add(providersShare.get(i));
        }




		// Define an array to store the market share of each provider

		// Calculate the market share of each provider

		// Print the market share of each provider

    }
}