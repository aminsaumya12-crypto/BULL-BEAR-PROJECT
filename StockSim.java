package BULL_BEAR;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class StockSim extends Logics {
    String username = "";
    String bullBearCode = "";
    String password = "";
    String gmail = "";
    static int count = 1;
    static char a1 = 'A';
    static char a2 = 'Z';

    void start() {
        Scanner sc = new Scanner(System.in);
        cnt++;

        if (cnt == 1) {
            if (!boo) {
                defaultPrice();
            }

            System.out.println();
            System.out.println("=================================");
            System.out.println("WELCOME TO STOCK MARKET SIMULATOR");
            System.out.println("Starting amount: ₹" + amount);
            super.start();
            start(1);

            System.out.println();
            System.out.println("===Default prices of shares:===");
            System.out.println("Amazon shares : ₹" + Amazon);
            System.out.println("Apple shares : ₹" + Apple);
            System.out.println("Google shares : ₹" + Google);
            System.out.println("Microsoft shares : ₹" + Microsoft);
            System.out.println("Tesla shares : ₹" + Tesla);
        }

        if (cnt > 1) {
            System.out.println();
            System.out.println("WELCOME BACK");
            System.out.println("You have amount: " + amount);
            System.out.println("Current values of shares: ");
            System.out.println("Amazon shares : ₹" + Amazon);
            System.out.println("Apple shares : ₹" + Apple);
            System.out.println("Google shares : ₹" + Google);
            System.out.println("Microsoft shares : ₹" + Microsoft);
            System.out.println("Tesla shares : ₹" + Tesla);
        }

        if (boo2) {
            displayAdded();
        }

        System.out.println("=======================");
        startPriceUpdates();

        boolean b = true;
        while (b) {
            count++;
            System.out.println();
            System.out.println("===================");
            System.out.println("Enter your choice: ");
            System.out.println("1. View current price of shares");
            System.out.println("2. Sell shares");
            System.out.println("3. Buy shares");
            System.out.println("4. Portfolio");
            System.out.println("5. Check your account balance");
            System.out.println("6. Last 5 transactions");
            System.out.println("7. Log Out");
            int option = sc.nextInt();
            sc.nextLine();
            System.out.println("===================");

            switch (option) {
                case 7: {
                    authenticate();
                }
                break;
                case 1: {
                    currentPrice();
                }
                break;
                case 2: {
                    if (AS == 0 && AZ == 0 && GS == 0 && MS == 0 && TS == 0 && ST0 == 0 && ST1 == 0 && ST2 == 0) {
                        System.out.println();
                        System.out.println("You don't have shares to sell");
                        System.out.println("Buy more shares to sell");
                    } else {
                        System.out.println("==========");
                        this.sellStocks();
                        System.out.println("==========");
                    }
                }
                break;
                case 3: {
                    double min = Math.min(Amazon, Apple);
                    min = Math.min(min, Google);
                    min = Math.min(min, Microsoft);
                    min = Math.min(min, Tesla);

                    if (newAdd > 0) {
                        min = Math.min(min, addPrices[0]);
                        if (newAdd > 1) {
                            min = Math.min(min, addPrices[1]);
                            if (newAdd > 2) {
                                min = Math.min(min, addPrices[2]);
                            }
                        }
                    }

                    if (amount > min) {
                        System.out.println("==========");
                        this.buyStocks();
                        System.out.println("==========");
                    } else {
                        System.out.println();
                        System.out.println("You don't have enough money to buy any shares now");
                    }
                }
                break;
                case 4: {
                    System.out.println("==========");
                    invigilateStocks();
                    System.out.println("==========");
                }
                break;
                case 5: {
                    System.out.println("==========");
                    balanceCheck();
                    System.out.println("==========");
                }
                break;
                case 6: {
                    System.out.println("==========");
                    displayTransaction();
                    System.out.println("==========");
                }
                break;
                default: {
                    System.out.println("Enter correct value");
                }
            }

            // Random market events
            int rand = (int) (Math.random() * 10) + 5;
            if (count == rand) {
                System.out.println();
                System.out.println("Google just released its new product: Google Pixel 11");
                System.out.println("Prices of shares of Google have increased by 1%");
                Google = Google + Google * 0.01;
                Google = (int) (Google * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 5) {
                System.out.println();
                System.out.println("Apple has released its new phone: iPhone 18, iPhone 18 Pro and iPhone 18 Pro max");
                System.out.println("Prices of shares of Apple have increased by 2.5% !!");
                Apple = Apple + Apple * 0.025;
                Apple = (int) (Apple * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 6) {
                System.out.println();
                System.out.println("Tesla has noticed a decline in their revenue");
                System.out.println("Prices of shares of Tesla have decreased by 0.5%");
                Tesla = Tesla - Tesla * 0.005;
                Tesla = (int) (Tesla * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 6) {
                System.out.println();
                System.out.println("Microsoft's performance has been poor for the last 3 months!!");
                System.out.println("There has been a decrease of 1.5% in share prices of Microsoft");
                Microsoft = Microsoft - Microsoft * 0.015;
                Microsoft = (int) (Microsoft * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 7) {
                System.out.println();
                System.out.println("Amazon has recorded a strong earning this last 3-4 months");
                System.out.println("Amazon's share prices increase by 2%");
                Amazon = Amazon + Amazon * 0.02;
                Amazon = (int) (Amazon * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 7) {
                System.out.println();
                System.out.println("Google has reported that their profits were higher than analyst expectations");
                System.out.println("Google's share prices increased by 1.5%");
                Google = Google + Google * 0.015;
                Google = (int) (Google * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 8) {
                System.out.println();
                System.out.println("Apple has achieved a huge profit because of commodity price changes");
                System.out.println("Apple's share prices have increased by 1%");
                Apple = Apple + Apple * 0.01;
                Apple = (int) (Apple * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 8) {
                System.out.println();
                System.out.println("Tesla recently bought some huge companies, being a reason of its growth");
                System.out.println("Prices of Tesla's shares have risen by 2%");
                Tesla = Tesla + Tesla * 0.02;
                Tesla = (int) (Tesla * 10000) / 10000.0;
            } else if (count == (int) (Math.random() * 10) + 8) {
                System.out.println();
                System.out.println("Tesla got internal conflicts which indirectly affected the company's growth");
                // BUG FIX: was using + instead of -, and missing /10000.0 for correct truncation
                System.out.println("Price of Tesla shares have decreased by 1%");
                Tesla = Tesla - Tesla * 0.01;
                Tesla = (int) (Tesla * 10000) / 10000.0;
            }
        }
    }

    void startPriceUpdates() {
        Timer timer = new Timer(true); // BUG FIX: daemon=true so timer doesn't block JVM exit
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Amazon *= (1 + (Math.random() - 0.5) * 0.007);
                Apple *= (1 + (Math.random() - 0.5) * 0.006);
                Google *= (1 + (Math.random() - 0.5) * 0.005);
                Microsoft *= (1 + (Math.random() - 0.5) * 0.005);
                Tesla *= (1 + (Math.random() - 0.5) * 0.004);

                // BUG FIX: Guard addPrices access with newAdd checks to prevent ArrayIndexOutOfBoundsException
                if (newAdd > 0) {
                    addPrices[0] *= (1 + (Math.random() - 0.5) * 0.005);
                    if (newAdd > 1) {
                        addPrices[1] *= (1 + (Math.random() - 0.5) * 0.003);
                        if (newAdd > 2) {
                            addPrices[2] *= (1 + (Math.random() - 0.5) * 0.008);
                        }
                    }
                }

                Amazon = (int) (Amazon * 10000) / 10000.0;
                updateAZ = Amazon;
                if (Amazon <= 0) Amazon = 0;

                Apple = (int) (Apple * 10000) / 10000.0;
                updateAS = Apple;
                if (Apple <= 0) Apple = 0;

                Google = (int) (Google * 10000) / 10000.0;
                updateGS = Google;
                if (Google <= 0) Google = 0;

                Microsoft = (int) (Microsoft * 10000) / 10000.0;
                updateMS = Microsoft;
                if (Microsoft <= 0) Microsoft = 0;

                Tesla = (int) (Tesla * 10000) / 10000.0;
                updateTS = Tesla;
                if (Tesla <= 0) Tesla = 0;

                // BUG FIX: Only update addPrices if they were actually set
                if (newAdd > 0) {
                    addPrices[0] = (int) (addPrices[0] * 10000) / 10000.0;
                    updateST0 = addPrices[0];
                    if (addPrices[0] <= 0) addPrices[0] = 0;
                }
                if (newAdd > 1) {
                    addPrices[1] = (int) (addPrices[1] * 10000) / 10000.0;
                    updateST1 = addPrices[1];
                    if (addPrices[1] <= 0) addPrices[1] = 0;
                }
                if (newAdd > 2) {
                    addPrices[2] = (int) (addPrices[2] * 10000) / 10000.0;
                    updateST2 = addPrices[2];
                    if (addPrices[2] <= 0) addPrices[2] = 0;
                }

                System.out.println();
                System.out.println("Prices of shares have updated!!!");
            }
        };
        timer.schedule(task, 180000, 180000); // BUG FIX: start delay changed from 0 to 180000 to avoid immediate update on login
    }

    void invigilateStocks() {
        System.out.println();

        if (AZ == 0 && AS == 0 && GS == 0 && TS == 0 && MS == 0 && ST0 == 0 && ST1 == 0 && ST2 == 0) {
            System.out.println("You don't own any shares currently");
        } else {
            System.out.println("Current prices of your owned shares ");

            if (AZ > 0) {
                System.out.println();
                System.out.println("Amazon: ₹" + Amazon);
                double currentValueAZ = AZ * Amazon;
                System.out.println("Total investment in Amazon: ₹" + investAZ);
                System.out.println("Current value of Amazon shares: ₹" + currentValueAZ);
            }
            if (AS > 0) {
                System.out.println();
                System.out.println("Apple: ₹" + Apple);
                double currentValueAS = AS * Apple;
                System.out.println("Total investment in Apple: ₹" + investAS);
                System.out.println("Current value of Apple shares: ₹" + currentValueAS);
            }
            if (GS > 0) {
                System.out.println();
                System.out.println("Google: ₹" + Google);
                double currentValueGS = GS * Google;
                System.out.println("Total investment in Google: ₹" + investGS);
                System.out.println("Current value of Google shares: ₹" + currentValueGS);
            }
            if (MS > 0) {
                System.out.println();
                System.out.println("Microsoft: ₹" + Microsoft);
                double currentValueMS = MS * Microsoft;
                System.out.println("Total investment in Microsoft: ₹" + investMS);
                System.out.println("Current value of Microsoft shares: ₹" + currentValueMS);
            }
            if (TS > 0) {
                System.out.println();
                System.out.println("Tesla: ₹" + Tesla);
                double currentValueTS = TS * Tesla;
                System.out.println("Total investment in Tesla: ₹" + investTS);
                System.out.println("Current value of Tesla shares: ₹" + currentValueTS);
            }
            if (newAdd > 0) {
                System.out.println(added[0] + " shares: " + addPrices[0]);
                if (newAdd > 1) {
                    System.out.println(added[1] + " shares: " + addPrices[1]);
                    if (newAdd > 2) {
                        System.out.println(added[2] + " shares: " + addPrices[2]);
                    }
                }
            }

            double currentValue = AZ * Amazon + AS * Apple + GS * Google + MS * Microsoft + TS * Tesla;
            if (newAdd > 0) currentValue += ST0 * addPrices[0];
            if (newAdd > 1) currentValue += ST1 * addPrices[1];
            if (newAdd > 2) currentValue += ST2 * addPrices[2];

            double invested = investAZ + investAS + investGS + investMS + investTS + investST0 + investST1 + investST2;
            double profitLoss = currentValue - invested;

            System.out.println();
            System.out.println("Total Invested : ₹" + invested);
            System.out.println("Current Value  : ₹" + currentValue);
            System.out.println("Profit / Loss  : ₹" + profitLoss);
        }
    }

    void currentPrice() {
        System.out.println();
        System.out.println("==========");
        System.out.println("===Current prices of shares===");
        System.out.println("Amazon: ₹" + Amazon);
        System.out.println("Apple: ₹" + Apple);
        System.out.println("Google: ₹" + Google);
        System.out.println("Microsoft: ₹" + Microsoft);
        System.out.println("Tesla: ₹" + Tesla);
        displayAdded();
        System.out.println("==========");
    }

    void start(int i) {
        System.out.println();
        System.out.println("Here are the basic rules on how this system works: ");
        System.out.println("There are 5 companies whose shares can be bought/sold in this simulator");
        System.out.println("Some shares can also be added by admin which can be bought/sold by users");
        System.out.println("Share Prices depend on: time and when you sell/buy a share");
        System.out.println();
        System.out.println("Share Prices update every 3 minutes in this simulator");
    }

    StockSim() {
        super();
        transaction = new String[6];
        transaction[0] = " ";
        transaction[1] = " ";
        transaction[2] = " ";
        transaction[3] = " ";
        transaction[4] = " ";
        transaction[5] = " ";

        if (added == null) {
            added = new String[3];
            addPrices = new double[3];
            counting = 0;
        }
    }

    void defaultPrice() {
        amount = 10000.0;
        Amazon = 1500.0;
        Apple = 1750.0;
        Google = 1250.0;
        Microsoft = 1050.0;
        Tesla = 1000.0;
        amount2 = 10000.0;
    }

    void displayAdded() {
        if (newAdd > 0) {
            System.out.println(added[0] + " shares: " + addPrices[0]);
            if (newAdd > 1) {
                System.out.println(added[1] + " shares: " + addPrices[1]);
                if (newAdd > 2) {
                    System.out.println(added[2] + " shares: " + addPrices[2]);
                }
            }
        }
    }

    void setPrice() {
        Scanner sc = new Scanner(System.in);
        boo = true;

        System.out.println("Enter default amount");
        amount = sc.nextDouble();

        System.out.println("Enter price of shares of Amazon");
        Amazon = sc.nextDouble();

        System.out.println("Enter price of shares of Apple");
        Apple = sc.nextDouble();

        System.out.println("Enter price of shares of Google");
        Google = sc.nextDouble();

        System.out.println("Enter prices of shares of Microsoft");
        Microsoft = sc.nextDouble();

        System.out.println("Enter prices of shares of Tesla");
        Tesla = sc.nextDouble();

        if (newAdd > 0) {
            System.out.println("Enter prices of shares of " + added[0]);
            addPrices[0] = sc.nextDouble();
            if (newAdd > 1) {
                System.out.println("Enter prices of shares of " + added[1]);
                addPrices[1] = sc.nextDouble();
                if (newAdd > 2) {
                    System.out.println("Enter prices of shares of " + added[2]);
                    addPrices[2] = sc.nextDouble();
                }
            }
        }
        amount2 = amount;
        sc.nextLine();
    }

    void balanceCheck() {
        System.out.println();
        System.out.println("You current balance is: ₹" + amount);
    }

    void addedStocks() {
        Scanner sc = new Scanner(System.in);
        boo2 = true;
        newAdd++;

        System.out.println("Enter name of shares");
        added[counting] = sc.nextLine();

        System.out.println("Enter price of shares");
        addPrices[counting] = sc.nextDouble();

        sc.nextLine();
        counting++;
    }

    public static void main(String[] args) {
        Admin ad = new Admin();
        ad.log();
    }

    static {
        for (int i = 0; i < login.length; i++) {
            login[i] = new StockSim();
        }
    }

    void authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("====================================");
        System.out.println("WELCOME TO BULL-BEAR STOCK SIMULATOR");
        System.out.println("=====================================");

        boolean z = true;
        while (z) {
            System.out.println("Choose an option from below:");
            System.out.println("1.Login");
            System.out.println("2.Signup");
            System.out.println("3.Forgot Password");
            System.out.println("4.Exit");
            System.out.println("0.UserType");
            int choice = sc.nextInt();
            sc.nextLine();

            login[0].username = "user";
            login[0].password = "12345678";

            if (choice == 0) {
                Admin ad = new Admin();
                ad.log();
            } else if (choice == 1) {
                System.out.println("================");
                System.out.println("Enter username: ");
                String user = sc.nextLine();

                System.out.println("Enter password:");
                String pass = sc.nextLine();
                System.out.println("================");

                // BUG FIX: Rewritten login logic. Original count logic was broken —
                // it incremented count for every non-matching user, so count==1 was never a reliable indicator.
                boolean found = false;
                for (int i = 0; i < login.length; i++) {
                    if (user.equals(login[i].username)) {
                        found = true;
                        if (pass.equals(login[i].password)) {
                            login[i].start();
                        } else {
                            System.out.println("Incorrect password, please try again.");
                            System.out.println(" ");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("We can't find your account, please re-enter username and password");
                    System.out.println(" ");
                }

            } else if (choice == 2) {
                System.out.println("==============================================");
                System.out.println("To signup, please enter the following details:");

                boolean a1 = true;
                while (a1) {
                    int count2 = 0;

                    System.out.println("Create username:");
                    login[count].username = sc.nextLine();

                    for (int i = 0; i < count; i++) {
                        if (login[count].username.equals(login[i].username)) {
                            count2++;
                        }
                    }

                    if (count2 == 1) {
                        System.out.println("username not available, please choose another username");
                        System.out.println(" ");
                    } else {
                        System.out.println("username available and verified");
                        a1 = false;
                    }
                }

                System.out.println(" ");
                System.out.println("Your unique bull bear code: ");
                login[count].bullBearCode = "#" + this.a1 + "bB" + count + login[count].username.charAt(0) + "$" + a2 + "@";
                System.out.println("bullBearCode: " + login[count].bullBearCode);

                int chars = 0;
                int nums = 0;
                int counta = 0;
                int extra = 0;

                boolean abc = true;
                while (abc) {
                    System.out.println(" ");
                    System.out.println("Enter your email: ");
                    login[count].gmail = sc.nextLine();
                    counta = 0;
                    chars = 0;
                    nums = 0;
                    extra = 0;

                    for (int i = 0; i < login[count].gmail.length(); i++) {
                        if ((login[count].gmail).charAt(i) == '@') {
                            counta++;
                        }
                    }

                    if (counta == 0 || counta > 1) {
                        System.out.println("Enter correct email again");
                    } else {
                        if (login[count].gmail.endsWith(".com")) {
                            String eg[] = login[count].gmail.split("@");
                            eg[0] = eg[0].toLowerCase();

                            for (int i = 0; i < eg[0].length(); i++) {
                                if (eg[0].charAt(i) >= 'a' && eg[0].charAt(i) <= 'z') {
                                    chars++;
                                } else if (eg[0].charAt(i) >= '0' && eg[0].charAt(i) <= '9') {
                                    nums++;
                                } else {
                                    extra++;
                                }
                            }

                            if (eg.length > 2 || eg.length <= 1) {
                                System.out.println("Enter correct email again");
                            } else {
                                if (nums == eg[0].length()) {
                                    System.out.println("Enter correct email again");
                                } else if (eg[0].charAt(0) >= '0' && eg[0].charAt(0) <= '9') {
                                    System.out.println("Enter correct email again");
                                } else if (extra > 0) {
                                    System.out.println("Enter correct email again");
                                } else {
                                    System.out.println("Email verified");
                                    abc = false;
                                }
                            }
                        } else {
                            System.out.println("Enter correct email again");
                        }
                    }
                }

                System.out.println(" ");
                System.out.println("Create password: (length should be at least 8)");
                boolean l = true;
                while (l) {
                    login[count].password = sc.nextLine();
                    if (login[count].password.length() >= 8) {
                        l = false;
                    } else {
                        System.out.println("The entered password's length is not 8 or more, please enter again");
                    }
                }

                System.out.println(" ");
                System.out.println("Login to start trading");
                System.out.println("=======================");
                System.out.println(" ");

            } else if (choice == 3) {
                System.out.println("Enter Username");
                String usr = sc.nextLine();

                String cd, gm;
                int a = 0;
                int c = 0;
                for (int i = 0; i < login.length; i++) {
                    if (login[i].username.equals(usr)) {
                        a++;
                        System.out.println("Enter bullBear code");
                        cd = sc.nextLine();

                        System.out.println("Enter gmail");
                        gm = sc.nextLine();

                        for (int j = 0; j < login.length; j++) {
                            if (usr.equals(login[j].username) && cd.equals(login[j].bullBearCode) && gm.equals(login[j].gmail)) {
                                c++;
                                System.out.println();
                                System.out.println("Account verified");
                                System.out.println("Username: " + login[j].username);
                                System.out.println("Gmail: " + login[j].gmail);

                                System.out.println("Enter your new password");
                                login[j].password = sc.nextLine();

                                System.out.println("Login again to start trading");
                                System.out.println();
                            }
                        }

                        if (c != 1) {
                            System.out.println("Can't find your account, please write the details again");
                            System.out.println();
                        }
                    }
                }

                if (a != 1) {
                    System.out.println("Can't find your account, please write the details again");
                    System.out.println();
                }

            } else if (choice == 4) {
                z = false;
                System.exit(0);
            } else {
                System.out.println("Choose a valid option.");
                System.out.println();
            }

            count++;
            a1++;
            a2--;
        }
    }
}