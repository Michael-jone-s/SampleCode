package HotelReservationSystem;

import java.util.Scanner;

public class HotelReservationSystem {

    private static final int MAX_ROOMS = 20;
    private static final int[] ROOM_RATES = {600, 700, 850, 1000, 1200};
    private static final int[] ROOM_COUNTS = {4, 4, 4, 4, 4};
    private static final double[] DISCOUNT_RATES = {0, 0, 0.1, 0.15, 0.2};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] guestNames = new String[MAX_ROOMS];
        int[] roomTypes = new int[MAX_ROOMS];
        int[] stayDays = new int[MAX_ROOMS];
        int guestCount = 0;

        System.out.print("The available room type and price of the room");
        System.out.print("\nDaily rate of room type 1: Rs.600");
        System.out.print("\nDaily rate of room type 2: Rs.700");
        System.out.print("\nDaily rate of room type 3: Rs.850");
        System.out.print("\nDaily rate of room type 4: Rs.1000");
        System.out.print("\nDaily rate of room type 5: Rs.1200\n");

        while (guestCount < MAX_ROOMS) {
            System.out.print("\nEnter guest name (or 'quit' to exit): ");
            String name = scanner.nextLine();
            if (name.equals("quit")) {
                break;
            }

            System.out.print("Enter room type (1-5): ");
            int roomType = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            if (roomType < 1 || roomType > 5) {
                System.out.println("Invalid room type!");
                continue;
            }

            if (ROOM_COUNTS[roomType-1] == 0) {
                System.out.println("Sorry, no rooms of this type are available.");
                continue;
            }

            System.out.print("Enter number of days: ");
            int days = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            if (guestCount == MAX_ROOMS - 1) {
                System.out.println("Hotel is full!");
                break;
            }

            guestNames[guestCount] = name;
            roomTypes[guestCount] = roomType;
            stayDays[guestCount] = days;
            guestCount++;

            ROOM_COUNTS[roomType-1]--;
        }

        System.out.println("\nReport 1:");
        System.out.printf("%-15s %-7s %-9s %s\n", "Guest Name", "Days", "Discount", "Subtotal");
        double totalRevenue = 0;
        for (int i = 0; i < guestCount; i++) {
            int roomRate = ROOM_RATES[roomTypes[i]-1];
            double discountRate = stayDays[i] > 15 ? DISCOUNT_RATES[4] :
                    stayDays[i] > 10 ? DISCOUNT_RATES[3] :
                            stayDays[i] > 5 ? DISCOUNT_RATES[2] :
                                    DISCOUNT_RATES[1];
            int subtotal = (int) (roomRate * stayDays[i] * (1 - discountRate));
            System.out.printf("%-15s %-7d %-9.2f Rs.%d\n", guestNames[i], stayDays[i], discountRate * 100, subtotal);
            totalRevenue += subtotal;
        }

        System.out.println("\nReport 2:");
        System.out.printf("%-15s %-15s\n", "Total Guests", "Total Rate");
        System.out.printf("%-15d %-15d\n", guestCount, (int) totalRevenue);
    }
}
