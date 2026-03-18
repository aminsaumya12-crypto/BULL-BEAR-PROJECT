package BULL_BEAR;

import java.util.Scanner;

class Admin extends StockSim {
    String user = "admin";
    String pass = "141";
    int choice = 0;

    void log() {
        Scanner sc = new Scanner(System.in);

        boolean a1 = true;
        while (a1) {
            System.out.println("Who do you want to log in as?");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 3: {
                    System.exit(0);
                }
                break;
                case 1: {
                    authenticate();
                    a1 = false;
                }
                break;
                case 2: {
                    int a = 1;
                    while (a != 0) {
                        System.out.println("(Enter 0 in both user and password to exit)");

                        System.out.println("Enter username");
                        String u = sc.nextLine();

                        System.out.println("Enter password");
                        String p = sc.nextLine();

                        if (u.equals(user) && p.equals(pass)) {
                            boolean a2 = true;
                            while (a2) {
                                System.out.println("What do you want to do?");
                                System.out.println("1. Change prices of shares");
                                System.out.println("2. Add shares");
                                System.out.println("3. View User's data");
                                System.out.println("4. Exit");
                                int ent = sc.nextInt();
                                sc.nextLine();

                                switch (ent) {
                                    case 1: {
                                        setPrice();
                                    }
                                    break;
                                    case 4: {
                                        a2 = false;
                                        a = 0;
                                    }
                                    break;
                                    case 2: {
                                        counting = 0;
                                        boolean abc1 = true;
                                        while (abc1) {
                                            System.out.println("How many shares do you want to add? (max:3)");
                                            choice = sc.nextInt();
                                            sc.nextLine();

                                            if (choice > 0 && choice <= 3) {
                                                for (int i = 0; i < choice; i++) {
                                                    addedStocks();
                                                }
                                                abc1 = false;
                                            } else if (choice == 0) {
                                                System.out.println("You chose to not add any shares");
                                                System.out.println("Exiting from add shares");
                                                System.out.println();
                                                abc1 = false;
                                            } else {
                                                System.out.println("Enter valid choice");
                                            }
                                        }
                                    }
                                    break;
                                    case 3: {
                                        // BUG FIX: condition was != 1, so it only showed message when exactly 1 account existed.
                                        // Changed to == 0 to correctly show "no accounts" when none are found.
                                        int ab = 0;
                                        for (int i = 0; i < login.length; i++) {
                                            if (!(login[i].username.equals(""))) {
                                                ab++;
                                                userDetails(i);
                                            }
                                        }

                                        if (ab == 0) {
                                            System.out.println("No accounts available to see the data");
                                            System.out.println();
                                        }
                                    }
                                    break;
                                    default: {
                                        System.out.println("Please choose valid option");
                                    }
                                }
                            }
                        } else if (u.equals("0") && p.equals("0")) {
                            a = 0;
                        } else {
                            System.out.println("Please enter username and password again");
                            System.out.println(" ");
                        }
                    }
                }
                break;
                default: {
                    System.out.println("Please choose a valid option");
                    System.out.println(" ");
                }
            }
        }
    }

    void userDetails(int i) {
        System.out.println();
        System.out.println("username: " + login[i].username);
        System.out.println("password: " + login[i].password);
        System.out.println("email: " + login[i].gmail);
        System.out.println();
        System.out.println("shares user owns: ");
        if (login[i].AZ > 0) {
            System.out.println("Amazon shares: " + login[i].AZ);
        }
        if (login[i].AS > 0) {
            System.out.println("Apple shares: " + login[i].AS);
        }
        if (login[i].GS > 0) {
            System.out.println("Google shares: " + login[i].GS);
        }
        if (login[i].MS > 0) {
            System.out.println("Microsoft shares: " + login[i].MS);
        }
        if (login[i].TS > 0) {
            System.out.println("Tesla shares: " + login[i].TS);
        }
        if (newAdd > 0) {
            if (login[i].ST0 > 0) {
                System.out.println(added[0] + " shares: " + login[i].ST0);
            }
            if (newAdd > 1) {
                if (login[i].ST1 > 0) {
                    System.out.println(added[1] + " shares: " + login[i].ST1);
                }
                if (newAdd > 2) {
                    if (login[i].ST2 > 0) {
                        System.out.println(added[2] + " shares: " + login[i].ST2);
                    }
                }
            }
        }
        System.out.println();
    }
}