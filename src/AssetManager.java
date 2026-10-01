import java.util.*;
import java.io.*;

public class AssetManager {

        private ArrayList<Asset> assets;

        public AssetManager() {
            this.assets = new ArrayList<>();
        }

        // Add a new asset to the list
        public void addAsset(Asset asset) {
            assets.add(asset);
            System.out.println("Added: " + asset.getName());
        }

        // Print all assets in the system
        public void printAllAssets() {
            System.out.println("\n--- All IT Assets ---");
            for (Asset a : assets) {
                System.out.println(a.getSummary());
            }
        }

        // Print only unassigned/available assets
        public void printAvailableAssets() {
            System.out.println("\n--- Available Assets ---");
            for (Asset a : assets) {
                if (!a.isAssigned())
                    System.out.println(a.getSummary());
                }
            }
        public void saveToFile(String filename) {
            try (PrintWriter writer = new PrintWriter(filename)) {
               for (Asset a : assets) {
                // Format: ID,Name,Category,isAssigned
                writer.println(a.getId() + "," + a.getName() + "," + a.getCategory() + "," + a.isAssigned());
            }
            System.out.println("Assets saved successfully to " + filename);
        }
            catch (FileNotFoundException e) {
            System.out.println("Error saving assets: " + e.getMessage());
        }
    }

    // Load assets from the text file back into memory
        public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return;
        }

            try (Scanner fileScanner = new Scanner(file)) {
            assets.clear(); // Clear existing list before loading fresh data
                while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String category = parts[2];
                    boolean isAssigned = Boolean.parseBoolean(parts[3]);

                    Asset asset = new Asset(id, name, category);
                    if (isAssigned) {
                        asset.assign();
                    }
                    assets.add(asset);
                }
            }
            System.out.println("Assets loaded successfully from " + filename);
        }
            catch (FileNotFoundException e) {
            System.out.println("Error loading assets: " + e.getMessage());
        }
    }
}
