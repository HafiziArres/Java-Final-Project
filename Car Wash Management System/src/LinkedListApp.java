import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LinkedListApp {
    public static void main(String[] args) throws Exception {
        LinkedList<CarWash> carWashList = new LinkedList<>();
            
        try ( // Reading data from the input file
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\hafiz\\OneDrive\\Documents\\UNIVERSITY\\SUBJECTS\\CSC248\\GROUP PROJECT\\248 PROJECT\\CarWashList.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ";");
                String custId = st.nextToken();
                String custName = st.nextToken();
                String custPhone = st.nextToken();
                String custEmail = st.nextToken();
                boolean membership = Boolean.parseBoolean(st.nextToken());
                String carBrand = st.nextToken();
                String carModel = st.nextToken();
                String carLicensePlate = st.nextToken();
                String carCategory = st.nextToken();
                String washPackage = st.nextToken();
                
                CarWash carWash = new CarWash(custId, custName, custPhone, custEmail, membership,carBrand, carModel, carLicensePlate, carCategory, washPackage);
                carWashList.insertAtBack(carWash);
            }
        }
            
        try ( //INTERFACE
                Scanner sc = new Scanner(System.in)) {
            int choice;
            do{
                System.out.println("*=== Car Wash Menu ===*");
                System.out.println("Choose an option:");
                System.out.println("1. Display Car Wash List");
                System.out.println("2. Remove & Transfer Customer Who Dont Have A Membership");
                System.out.println("3. Sort Car Wash List by Membership Status or Package");
                System.out.println("4. Update Customer Detail");
                System.out.println("5. Insert New Car Wash Data");
                System.out.println("6. Search Customer Car Wash Detail by Car Category");
                System.out.println("7. Exit");
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                switch(choice) {
                    case 1:
                        System.out.println("===== Car Wash List =====");
                        carWashList.displayList();
                        break;
                    case 2:
                        LinkedList<CarWash> membershipList = new LinkedList<>();
                        LinkedList<CarWash> nonMembershipList = new LinkedList<>();
                        LinkedList<CarWash> allCarWashList;
                        allCarWashList = carWashList;
                        
                        while(allCarWashList.getHead() != null){
                            CarWash carwash = allCarWashList.removeFromFirst();
                            if(carwash.getMembership())
                                membershipList.insertAtBack(carwash);
                            else
                                nonMembershipList.insertAtBack(carwash);
                        }
                        System.out.println("==== Membership List ====");
                        membershipList.displayList();
                        System.out.println("\n==== Non-Membership List ====");
                        nonMembershipList.displayList();
                        
                        // Write membership list to file
                        try (BufferedWriter membershipWriter = new BufferedWriter(new FileWriter("C:\\Users\\hafiz\\OneDrive\\Documents\\UNIVERSITY\\SUBJECTS\\CSC248\\GROUP PROJECT\\248 PROJECT\\\\membership_list.txt"))) {
                            membershipWriter.write("==== Membership List ====\n");
                            membershipList.writeToFile(membershipWriter);
                            membershipWriter.write("\nTransfer complete!");
                        } catch (IOException e) {
                            System.out.println("Error writing to membership list file: " + e.getMessage());
                        }
                        
                        // Write non-membership list to file
                        try (BufferedWriter nonMembershipWriter = new BufferedWriter(new FileWriter("C:\\Users\\hafiz\\OneDrive\\Documents\\UNIVERSITY\\SUBJECTS\\CSC248\\GROUP PROJECT\\248 PROJECT\\non_membership_list.txt"))) {
                            nonMembershipWriter.write("==== Non-Membership List ====\n");
                            nonMembershipList.writeToFile(nonMembershipWriter);
                            nonMembershipWriter.write("\nTransfer complete!");
                        } catch (IOException e) {
                            System.out.println("Error writing to non-membership list file: " + e.getMessage());
                        }
                        
                        System.out.println("Transfer complete!");
                        break;
                    case 3:
                        System.out.println("1. Sort by Membership");
                        System.out.println("2. Sort by Package");
                        int sortChoice = sc.nextInt();
                        if(sortChoice == 1 || sortChoice == 2){
                            carWashList.selectionSort(sortChoice);
                            System.out.println("Car Wash List sorted successfully!");
                            carWashList.displayList();
                            break;
                        }
                        System.out.println("Invalid choice");
                        break;
                    case 4:
                        System.out.print("Enter Customer ID to update: ");
                        String updateCustomer = sc.nextLine();
                        CarWash customerToUpdate = carWashList.searchCustomer(updateCustomer);
                        if (customerToUpdate != null) {
                            System.out.print("Enter new Membership Status: ");
                            boolean newMembership = sc.nextBoolean();
                            sc.nextLine(); // Consume newline character
                            System.out.print("Enter new Wash Package: ");
                            String newWashPackage = sc.nextLine();
                            
                            // Update fields
                            customerToUpdate.setMembership(newMembership);
                            customerToUpdate.setWashPackage(newWashPackage);
                            System.out.println("Customer information updated.");
                            carWashList.displayList();
                        } else {
                            System.out.println("Customer not found.");
                        }
                        break;
                    case 5:
                        Boolean answer1 = true; // Start with true to enter the loop
                        while(answer1 != false) {
                            System.out.print("Enter Customer Id: ");
                            String custId = sc.nextLine();
                            System.out.print("Enter Customer Name: ");
                            String custName = sc.nextLine();
                            System.out.print("Enter Customer Phone: ");
                            String custPhone = sc.nextLine();
                            System.out.print("Enter Customer Email: ");
                            String custEmail = sc.nextLine();
                            System.out.print("Is Customer a Member? (true/false): ");
                            boolean membership = Boolean.parseBoolean(sc.nextLine());
                            System.out.print("Enter Car Brand: ");
                            String carBrand = sc.nextLine();
                            System.out.print("Enter Car Model: ");
                            String carModel = sc.nextLine();
                            System.out.print("Enter Car License Plate: ");
                            String carLicensePlate = sc.nextLine();
                            System.out.print("Enter Car Category: ");
                            String carCategory = sc.nextLine();
                            System.out.print("Enter Wash Package: ");
                            String washPackage = sc.nextLine();
                            
                            CarWash newListCarWash = new CarWash(custId, custName, custPhone, custEmail, membership, carBrand, carModel, carLicensePlate, carCategory, washPackage);
                            carWashList.insertAtBack(newListCarWash);
                            
                            try (PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\hafiz\\OneDrive\\Documents\\UNIVERSITY\\SUBJECTS\\CSC248\\GROUP PROJECT\\248 PROJECT\\newCarWashList.txt"))) {
                                newListCarWash = carWashList.getHead();
                                while(newListCarWash != null){
                                    pw.print(newListCarWash.toString() + "\n");
                                    newListCarWash = carWashList.getNext();
                                }
                            }
                            System.out.print("Do you want to add more data? (y/n): ");
                            String cont = sc.nextLine();
                            if(answer1 = cont.equalsIgnoreCase("n")){ // Continue if user inputs 'y'
                                answer1 = false;
                                System.out.println("New Customer Added!");
                            }
                        }
                        break;
                    case 6:
                        System.out.print("Enter Car License Plate or Customer ID to search:");
                        String search = sc.nextLine();
                        CarWash searchResult = carWashList.searchCustomer(search);
                        if (searchResult != null) {
                            System.out.println("Customer found:" + searchResult);
                        } else {
                            System.out.println("Customer not found.");
                        }
                        break;
                    case 7:
                        System.out.println("====Thankyou====");
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while(choice != 7);
        }       
    } 
    
}
    

        
        

    
    
    


