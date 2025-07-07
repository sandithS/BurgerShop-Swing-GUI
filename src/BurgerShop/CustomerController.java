
package BurgerShop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nirot
 */
public class CustomerController {

    public static boolean addCustomer(Burger customer) throws IOException {
        FileWriter fw = new FileWriter("Customer.txt", true);
        fw.write(customer.toString() + "\n");
        fw.close();
        return true;
    }

    public static String newCustomerId() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Customer.txt"));
        String line = null;
        while (input.hasNext()) {
            line = input.nextLine();
        }
        if (line == null) {
            return "B0001";
        }
        int lastIdNumber = Integer.parseInt(line.substring(1, 5));
        return String.format("B%04d", lastIdNumber + 1);
    }

    public static Burger searchCustomer(String id) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Customer.txt"));
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] rowData = line.split(",");
            if (rowData[0].equalsIgnoreCase(id)) {
                return new Burger(id, rowData[1], rowData[2], Integer.parseInt(rowData[3]), rowData[4]);
            }
        }
        return null;
    }

    public static boolean updateCustomer(Burger customer) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("Customer.txt"));
        List customerList = new List();
        String line = br.readLine();
        while (line != null) {
            String[] rowData = line.split(",");
            customerList.add(new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), rowData[4]));
            line = br.readLine();
        }
        br.close();
        customerList.set(customer);
        FileWriter fw = new FileWriter("Customer.txt");
        for (int i = 0; i < customerList.size(); i++) {
            Burger c1 = customerList.get(i);
            fw.write(c1.toString() + "\n");
        }
        fw.close();
        return true;
    }

    public static boolean deleteCustomer(String id) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("Customer.txt"));
        List customerList = new List();
        String line = br.readLine();
        while (line != null) {
            String[] rowData = line.split(",");
            customerList.add(new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), rowData[4]));
            line = br.readLine();
        }
        br.close();
        boolean isDeleted=customerList.remove(new Burger(id,null,null,0,null));
        FileWriter fw = new FileWriter("Customer.txt");
        for (int i = 0; i < customerList.size(); i++) {
            Burger c1 = customerList.get(i);
            fw.write(c1.toString() + "\n");
        }
        fw.close();
        return isDeleted;
    }
    public static  List getAllCustomers() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Customer.txt"));
        List customerList = new List();
        String line = br.readLine();
        while (line != null) {
            String[] rowData = line.split(",");
            customerList.add(new Burger(rowData[0], rowData[1], rowData[2], Integer.parseInt(rowData[3]), rowData[4]));
            line = br.readLine();
        }
        br.close(); 
        return customerList;
    }
}
