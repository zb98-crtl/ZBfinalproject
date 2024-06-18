import java.util.*;

// SalesPerson class
class SalesPerson {
    private String name;
    private String title;
    private ArrayList<Double> sales;

    // Constructor
    public SalesPerson(String name,  String title) {
        this.name = name;
        this.title = title;
        this.sales = new ArrayList<>();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Method to add a sale
    public void addSale(double amount) {
        sales.add(amount);
    }

    // Iterator for sales
    public Iterator<Double> iterSales() {
        return sales.iterator();
    }

    // Calculate total sales
    public double calculateTotalSales() {
        double total = 0.0;
        for (double sale :  sales) {
            total += sale;
        }
        return total;
    }

    // Calculate minimum sale
    public double getMinSale() {
        if (sales.isEmpty()) {
            return 0.0;
        }
        return Collections.min(sales);
    }

    // Calculate maximum sale
    public double getMaxSale() {
        if (sales.isEmpty()) {
            return 0.0;
        }
        return Collections.max(sales);
    }

    // Calculate average sale
    public double getAverageSale() {
        if (sales.isEmpty()) {
            return 0.0;
        }
        double sum = calculateTotalSales();
        return sum / sales.size();
    }
}

// Main class
public class SalesTrackingProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ArrayList to store SalesPerson objects
        ArrayList<SalesPerson> salesPeople = new ArrayList<>();

        // Input salesperson data
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Sales Person " + (i + 1) + " details: ");
            System.out.print("Name:  ");
            String name = scanner.nextLine();
            System.out.print("Title:  ");
            String title = scanner.nextLine();

            // Create SalesPerson object
            SalesPerson salesPerson = new SalesPerson(name,  title);

            // Input sales figures
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter sale " + (j + 1) + ":  ");
                double sale = scanner.nextDouble();
                salesPerson.addSale(sale);
            }
            scanner.nextLine(); // Consume newline left-over

            // Add SalesPerson to ArrayList
            salesPeople.add(salesPerson);
        }

        // Print sales report
        System.out.println("\nSales Report: ");
        System.out.println("===========================");

        double companyTotalSales = 0.0;

        // Iterate through each SalesPerson
        for (SalesPerson salesPerson :  salesPeople) {
            System.out.println("Sales Person:  " + salesPerson.getName());
            System.out.println("Title:  " + salesPerson.getTitle());

            // Calculate and print sales statistics
            Iterator<Double> iterator = salesPerson.iterSales();
            double minSales = salesPerson.getMinSale();
            double maxSales = salesPerson.getMaxSale();
            double totalSales = salesPerson.calculateTotalSales();
            double averageSales = salesPerson.getAverageSale();

            System.out.println("Total Sales:  " + totalSales);
            System.out.println("Minimum Sale:  " + minSales);
            System.out.println("Maximum Sale:  " + maxSales);
            System.out.println("Average Sale:  " + averageSales);
            System.out.println();

            // Accumulate total sales for company
            companyTotalSales += totalSales;
        }

        // Print total sales for the entire company
        System.out.println("Total Sales for the Company:  " + companyTotalSales);

        // Close scanner
        scanner.close();
    }
}
