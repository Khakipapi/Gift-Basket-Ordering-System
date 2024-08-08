
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
@Author Jose Reyes
2/3/2022
UMGC
CMIS 242 6383
Inheritance and Encapsulation
Assignment 2
CMIS242ASG2ReyesJ

This program will take the users input to create an order of either a fruit basket or a sweets basket.
The user will be given an option for an add-on for a fee.
 This program will utilize Inheritance and Encapsulation using the parent class Gift.
 */
public class CMIS242ASG2ReyesJ {

    static class Gift {
        //attributes
        private String orderNumber;
        private String size;
        private int numberOfFruits;
        private double price;



        public Gift(String orderNumber, String size, int numberOfFruits, double price) {
            getOrderNumber();
            getSize();
            getNumberOfFruits();
            getPrice();

            setOrderNumber(orderNumber);
            setSize(size);
            setPrice(price);
            setNumberOfFruits(numberOfFruits);
        }
        
        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getNumberOfFruits() {
            return numberOfFruits;
        }

        public void setNumberOfFruits(int numberOfFruits) {
            this.numberOfFruits = numberOfFruits;
        }

        static void Order(List<Gift>orders) {
            try {
                double price = 0;
                int numberOfFruits = 0;

                Scanner input = new Scanner(System.in);
                Scanner orderInput = new Scanner(System.in);
                Scanner sizeInput = new Scanner(System.in);

                System.out.print("Do you want a Fruit Basket(1) or Sweets Basket(2): ");
                int choice = input.nextInt();

                if (choice == 1 || choice == 2) {


                    int digits = 0;


                    //prompt for order number
                    System.out.print("Create order number [FB or SB for type of gift and three integers]: ");
                    String orderNumber = orderInput.nextLine();
                    for (int inspector = 0; inspector < orderNumber.length(); inspector++) {
                        if (orderNumber.charAt(inspector) >= 48 && orderNumber.charAt(inspector) <= 57) {
                            digits++;
                        }
                    }

                    if (digits != 3) {
                        System.out.println("Invalid Entry: Must have 3 digits");
                        return;
                    }

                    if (orderNumber.length() != 5) {
                        System.out.println("Invalid Entry: Must have a length of 5 characters.");
                        return;
                    }

                    if (orderNumber.contains("FB") || orderNumber.contains("SB")) {
                        //prompt for size
                        System.out.print("\nWhat Size do you want: S, M, L:");
                        String size = sizeInput.nextLine();

                        if (size.equalsIgnoreCase("S")) {
                            price += 19.99;
                            numberOfFruits = 6;
                            size = "Small";
                        } else if (size.equalsIgnoreCase("M")) {
                            price += 29.99;
                            numberOfFruits = 9;
                            size = "Medium";
                        } else if (size.equalsIgnoreCase("L")) {
                            price += 39.99;
                            numberOfFruits = 15;
                            size = "Large";
                        } else {
                            System.out.println("Invalid Entry: Must be either S, M, or L");
                        }
                        String citrus = "";
                        String nuts = "";

                        if (choice == 1) {
                            System.out.println("Do you want citrus included? 1 for yes 2 for no: ");
                            int choice3 = input.nextInt();
                            if (choice3 == 1) {
                                price += 5.99;
                                citrus = "with citrus";
                            } else if (choice3 == 2) {
                                citrus = "without citrus";
                            }

                            orders.add(new FruitBasket(orderNumber, size, numberOfFruits, citrus, price));
                            System.out.println("Your order has been added");
                        } else if (choice == 2) {
                            System.out.println("Do you want nuts included? 1 for yes 2 for no: ");
                            int choice4 = input.nextInt();
                            if (choice4 == 1) {
                                price += 4.99;
                                nuts = "with nuts";
                            } else if (choice4 == 2) {
                                nuts = "without nuts";
                            }

                            orders.add(new SweetsBasket(orderNumber, size, numberOfFruits, nuts, price));
                            System.out.println("Your order has been added");
                        }
                    } else {
                        System.out.println("Invalid Entry: Must start with FB or SB");
                    }
                }// end choice validation
                else
                {
                    System.out.println("Invalid Entry: Must be 1 or 2");
                    return;
                }
                }catch(Exception order)
                {
                    System.out.println("\nInvalid input");
                }

        }//end Order

        static void ChangeOrder(List<Gift>orders)
        {
            if (orders.isEmpty())
            {
                System.out.println("\n No gift has been ordered yet\n");
                return;
            }

            try {
                String orderNumber;
                double price = 0;
                int numberOfFruits;
                Scanner input = new Scanner(System.in);
                System.out.println("Which order do you want to change? Enter order number: ");
                orderNumber = input.nextLine();

                for (Gift basket : orders) {
                    if (basket.orderNumber.equals(orderNumber)) {
                        System.out.println("Current order: " + basket.orderNumber);
                        System.out.println("Current gift size: " + basket.getSize());

                        if (basket instanceof FruitBasket)
                        {
                            System.out.println(((FruitBasket) basket).getCitrus());
                        }
                        if (basket instanceof SweetsBasket)
                        {
                            System.out.println(((SweetsBasket) basket).getNuts());
                        }

                        //remove order
                        orders.remove(basket);

                        //prompt for size and calculate price
                        System.out.print("What size do you want [enter same size or one of the order sizes]: ");
                        String size = input.nextLine();
                        if (size.equalsIgnoreCase("S")) {
                            price += 19.99;
                            numberOfFruits = 6;
                            size = "Small";
                        } else if (size.equalsIgnoreCase("M")) {
                            price += 29.99;
                            numberOfFruits = 9;
                            size = "Medium";
                        } else if (size.equalsIgnoreCase("L")) {
                            price += 39.99;
                            numberOfFruits = 15;
                            size = "Large";
                        } else {
                            System.out.println("\n Invalid Entry");
                            return;
                        }

                        String citrus = "";
                        String nuts = "";

                        Scanner citrusInput = new Scanner(System.in);
                        if (basket instanceof FruitBasket) {
                            System.out.print("Do you want citrus? 1 for yes 2 for no: ");
                            int citrusChoice = citrusInput.nextInt();
                            if (citrusChoice == 1) {
                                citrus = " with citrus";
                                price += 5.99;
                            } else if (citrusChoice == 2) {
                                citrus = " without citrus";
                            }

                            orders.add(new FruitBasket(orderNumber, size, numberOfFruits, citrus, price));
                            System.out.printf("New order is: " + orderNumber + " A " + size + " fruit basket "
                                    + "with " + numberOfFruits + " fruits " + citrus +
                                    " costing $" + "%.2f", price);


                        }
                       else if (basket instanceof SweetsBasket) {
                            System.out.print(" Do you want to add nuts? 1 for yes 2 for no: ");
                            int nutsChoice = citrusInput.nextInt();
                            if (nutsChoice == 1) {
                                nuts = "with nuts";
                                price += 4.49;
                            } else if (nutsChoice == 2)
                                nuts = "without nuts";

                            orders.add(new SweetsBasket(orderNumber, size, numberOfFruits, nuts, price));
                            System.out.printf("New order is: " + orderNumber + " A " + size + "sweets basket "
                                    + "with " + numberOfFruits + " fruits " + nuts
                                    + " costing $" + "%.2f", price);
                        }
                    }
                }
            }catch (Exception exception)
            {
                System.out.println("");
            }
        } //end ChangeOrder

        static void DisplayAll(List<Gift> orders)
        {
            if (orders.isEmpty())
            {
                System.out.println("\n No gift has been ordered yet\n");
                return;
            }

            for (Gift basket : orders)
            {
                String format = String.format("%.2f",basket.getPrice());
                if (basket instanceof FruitBasket) {
                    System.out.printf(basket.getOrderNumber() + " A " + basket.getSize() +
                            " fruit basket with " + basket.getNumberOfFruits() +" fruits " + ((FruitBasket) basket).getCitrus()
                            + " costing $" +format+ "\n");
                }
                if (basket instanceof SweetsBasket)
                {
                    String format2 = String.format("%.2f",basket.getPrice());
                    System.out.printf(basket.getOrderNumber() + " A " + basket.getSize() +
                            " sweets basket with " + basket.getNumberOfFruits() +" fruits "+ ((SweetsBasket) basket).getNuts()
                            + " costing $" + format2 +"\n");
                }
            }
        }//end of DisplayAll

        static void DisplayGift(List<Gift> orders)
        {
            String orderNumber;
            if (orders.isEmpty())
            {
                System.out.println("\n No gift has been ordered yet\n");
                return;
            }

            Scanner input = new Scanner(System.in);
            System.out.println("Which order do you want to display? Enter order number: ");
            orderNumber = input.nextLine();

            for (Gift basket : orders)
            {
                if (basket.orderNumber.equals(orderNumber))
                {
                    if (basket instanceof FruitBasket) {
                        String format3 = String.format("%.2f", basket.getPrice());
                        System.out.printf(basket.getOrderNumber() + " A " + basket.getSize() +
                                " fruit basket with " + basket.getNumberOfFruits() + " fruits " + ((FruitBasket) basket).getCitrus()
                                + " costing $" + format3 + "\n");
                    }
                     if (basket instanceof SweetsBasket)
                    {
                        String format4 = String.format("%.2f",basket.getPrice());
                        System.out.printf(basket.getOrderNumber() + " A " + basket.getSize() +
                                " sweets basket with " + basket.getNumberOfFruits()+ " fruits " + ((SweetsBasket) basket).getNuts()
                                + " costing $" + format4 +"\n");
                    }
                }
            }
        }//end of DisplayGift
    }//End of Gift

    static class FruitBasket extends Gift {

        private String citrus;

        public FruitBasket(String orderNumber, String size, int numberOfFruits, String citrus, double price) {
            super(orderNumber, size, numberOfFruits, price);
            setCitrus(citrus);
        }

        public String getCitrus() {
            return citrus;
        }

        public void setCitrus(String citrus) {
            this.citrus = citrus;
        }

        @Override
        public double getPrice() {
            return super.getPrice();
        }

        @Override
        public String toString() {
            return getOrderNumber() + ": a " + getSize() + " FruitBasket with " + getNumberOfFruits() + " with " + getCitrus()
                    + ".";
        }

    }//End of FruitBasket

    static class SweetsBasket extends Gift {

        private String nuts;

        public SweetsBasket(String orderNumber, String size, int numberOfFruits, String nuts, double price) {
            super(orderNumber, size, numberOfFruits, price);
            setNuts(nuts);
        }

        public String getNuts() {
            return nuts;
        }

        public void setNuts(String nuts) {
            this.nuts = nuts;
        }

        @Override
        public double getPrice() {
            return super.getPrice();
        }

        @Override
        public String toString() {
            return getOrderNumber() + ": a " + getSize() + " SweetBasket with " + getNumberOfFruits() + " with " + getNuts()
                    + ".";
        }
    }//End of SweetsBasket


    public static void Menu()
    {
        System.out.println("    Menu");
        System.out.println("1: Order A Gift Basket");
        System.out.println("2: Change Gift Basket");
        System.out.println("3: Display Gift Basket");
        System.out.println("4: Display all Gift Baskets");
        System.out.println("9: Exit program");
    }//End Menu method

    public static void main(String[] args) {
        Gift gift = new Gift("","",0,0);
        List<Gift> orders = new ArrayList<>();
        Scanner input2 = new Scanner(System.in);
        int selection;

        do {
            Menu();
            System.out.print("Enter your selection: ");
            selection = input2.nextInt();
            switch (selection)
            {
                case 1: gift.Order(orders);
                        break;
                case 2: gift.ChangeOrder(orders);
                        break;
                case 3: gift.DisplayGift(orders);
                        break;
                case 4: gift.DisplayAll(orders);
                        break;
                case 9: System.out.println("Thank you for using this program");
                        break;
                default: System.out.println("Invalid Entry");
            }

        }while (selection !=9);


    }//end Main
}//end of CMIS242ASG2ReyesJ
