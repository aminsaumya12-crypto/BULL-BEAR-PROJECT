package BULL_BEAR;

import java.util.*;

class Logics {
    // these are the prices of shares
    static double amount, Amazon, Tesla, Microsoft, Apple, Google, amount2;
    // these are the no of shares user owns
    int GS, AS, MS, AZ, TS, ST0, ST1, ST2;
    // these variables are for tracking whether shares are added or not
    static boolean boo, boo2;
    // this stores data of the last transactions that we did
    String transaction[];
    // this stores data of how many shares have been used
    static int newAdd = 0;
    // these are the names of the shares added
    static String added[];
    // these are the prices of the shares added
    static double addPrices[];
    static int counting = 0;
    // these are the prices of shares at which we sold them
    double sellAZ, sellAS, sellGS, sellMS, sellTS, sellST0, sellST1, sellST2;
    // these are the updated prices of shares because of time
    double updateAZ, updateAS, updateGS, updateMS, updateTS, updateST0, updateST1, updateST2;
    // these are the variables that store the amount that we invested in a particular company's shares
    double investAZ = 0;
    double investAS = 0;
    double investGS = 0;
    double investMS = 0;
    double investTS = 0;
    double investST0 = 0;
    double investST1 = 0;
    double investST2 = 0;
    // this is the no of users that are possible to be created
    static StockSim login[] = new StockSim[20];
    // the variable that tracks how many times a user has logged in and out
    int cnt = 0;

    void sellStocks() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Shares that are available to sell ");

        if (AZ > 0) {
            System.out.println();
            System.out.println("Amazon ");
            System.out.println("Current Price: ₹" + Amazon + " and Quantity: " + AZ);
        }
        if (AS > 0) {
            System.out.println();
            System.out.println("Apple ");
            System.out.println("Current Price: ₹" + Apple + " and Quantity: " + AS);
        }
        if (GS > 0) {
            System.out.println();
            System.out.println("Google ");
            System.out.println("Current Price: ₹" + Google + " and Quantity: " + GS);
        }
        if (MS > 0) {
            System.out.println();
            System.out.println("Microsoft ");
            System.out.println("Current Price: ₹" + Microsoft + " and Quantity: " + MS);
        }
        if (TS > 0) {
            System.out.println();
            System.out.println("Tesla ");
            System.out.println("Current Price: ₹" + Tesla + " and Quantity: " + TS);
        }

        // BUG FIX: Guard all addPrices accesses with newAdd checks
        if (newAdd > 0) {
            if (ST0 > 0) {
                System.out.println();
                System.out.println(added[0]);
                System.out.println("Current Price: ₹" + addPrices[0] + " and Quantity:" + ST0);
            }
            if (newAdd > 1) {
                if (ST1 > 0) {
                    System.out.println();
                    System.out.println(added[1]);
                    System.out.println("Current Price: ₹" + addPrices[1] + " and Quantity:" + ST1);
                }
                if (newAdd > 2) {
                    if (ST2 > 0) {
                        System.out.println();
                        System.out.println(added[2]);
                        System.out.println("Current Price: ₹" + addPrices[2] + " and Quantity:" + ST2);
                    }
                }
            }
        }

        boolean b = true;
        while (b) {
            System.out.println();
            System.out.println("Enter name of your shares: ");
            System.out.println("Enter null to exit");
            String choice = sc.nextLine();
            choice = choice.trim();

            if (choice.equalsIgnoreCase("amazon") && AZ > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= AZ) {
                        AZ = AZ - sell;
                        amount = amount + sell * Amazon;
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of Amazon");
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + AZ + " shares of Amazon left");
                        sellAZ = Amazon;
                        Amazon = Amazon - sell * Amazon * 0.0004;
                        Amazon = (int) (Amazon * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of Amazon";
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (choice.equalsIgnoreCase("apple") && AS > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= AS) {
                        AS = AS - sell;
                        amount = amount + sell * Apple;
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of Apple");
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + AS + " shares of Apple left");
                        sellAS = Apple;
                        Apple = Apple - sell * Apple * 0.0002;
                        Apple = (int) (Apple * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of Apple";
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (choice.equalsIgnoreCase("google") && GS > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= GS) {
                        GS = GS - sell;
                        amount = amount + sell * Google;
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of Google");
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + GS + " shares of Google left");
                        sellGS = Google;
                        Google = Google - sell * Google * 0.0002;
                        Google = (int) (Google * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of Google";
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (choice.equalsIgnoreCase("microsoft") && MS > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= MS) {
                        MS = MS - sell;
                        amount = amount + sell * Microsoft;
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of Microsoft");
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + MS + " shares of Microsoft left");
                        sellMS = Microsoft;
                        Microsoft = Microsoft - sell * Microsoft * 0.0003;
                        Microsoft = (int) (Microsoft * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of Microsoft";
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (choice.equalsIgnoreCase("tesla") && TS > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= TS) {
                        TS = TS - sell;
                        amount = amount + sell * Tesla;
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of Tesla");
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + TS + " shares of Tesla left");
                        sellTS = Tesla;
                        Tesla = Tesla - sell * Tesla * 0.0001;
                        Tesla = (int) (Tesla * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of Tesla";
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (newAdd > 0 && choice.equalsIgnoreCase(added[0]) && ST0 > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= ST0) {
                        ST0 = ST0 - sell;
                        amount = amount + sell * addPrices[0];
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of " + added[0]);
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + ST0 + " shares of " + added[0] + " left");
                        sellST0 = addPrices[0];
                        addPrices[0] = addPrices[0] - sell * addPrices[0] * 0.0002;
                        addPrices[0] = (int) (addPrices[0] * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of " + added[0];
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (newAdd > 1 && choice.equalsIgnoreCase(added[1]) && ST1 > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= ST1) {
                        ST1 = ST1 - sell;
                        amount = amount + sell * addPrices[1];
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of " + added[1]);
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + ST1 + " shares of " + added[1] + " left");
                        sellST1 = addPrices[1];
                        addPrices[1] = addPrices[1] - sell * addPrices[1] * 0.0004;
                        addPrices[1] = (int) (addPrices[1] * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of " + added[1];
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (newAdd > 2 && choice.equalsIgnoreCase(added[2]) && ST2 > 0) {
                boolean a = true;
                while (a) {
                    System.out.println();
                    System.out.println("Enter how many shares you want to sell");
                    int sell = sc.nextInt();
                    sc.nextLine();
                    if (sell > 0 && sell <= ST2) {
                        ST2 = ST2 - sell;
                        amount = amount + sell * addPrices[2];
                        System.out.println();
                        System.out.println("You sold " + sell + " shares of " + added[2]);
                        System.out.println("Your amount: ₹" + amount);
                        System.out.println("You have " + ST2 + " shares of " + added[2] + " left");
                        sellST2 = addPrices[2];
                        addPrices[2] = addPrices[2] - sell * addPrices[2] * 0.0003;
                        addPrices[2] = (int) (addPrices[2] * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You sold " + sell + " shares of " + added[2];
                        setTransaction();
                    } else if (sell == 0) {
                        System.out.println("You have chosen to not sell");
                        System.out.println("Exiting from sell shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Please enter sell quantity correctly or check your shares");
                    }
                }
            } else if (choice.equalsIgnoreCase("null")) {
                System.out.println("You are exiting from sell shares");
                b = false;
            } else {
                System.out.println();
                System.out.println("Invalid option, please re-enter");
            }
        }
    }

    void buyStocks() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Available shares ");
        System.out.println("Amazon : ₹" + Amazon);
        System.out.println("Apple : ₹" + Apple);
        System.out.println("Google : ₹" + Google);
        System.out.println("Microsoft : ₹" + Microsoft);
        System.out.println("Tesla : ₹" + Tesla);

        if (newAdd > 0) {
            System.out.println(added[0] + " : ₹" + addPrices[0]);
            if (newAdd > 1) {
                System.out.println(added[1] + " : ₹" + addPrices[1]);
                if (newAdd > 2) {
                    System.out.println(added[2] + " : ₹" + addPrices[2]);
                }
            }
        }

        boolean b = true;
        while (b) {
            System.out.println();
            System.out.println("Enter name of the shares you would like to buy");
            System.out.println("Enter null to exit");
            String opt = sc.nextLine();
            opt = opt.trim();

            if (opt.equalsIgnoreCase("Amazon")) {
                if (amount > Amazon) {
                    System.out.println();
                    System.out.println("Current price: ₹" + Amazon);
                    boolean a = true;
                    while (a) {
                        System.out.println("Enter quantity:");
                        int qt = sc.nextInt();
                        sc.nextLine();
                        if (amount >= qt * Amazon && qt > 0) {
                            AZ += qt;
                            amount = amount - qt * Amazon;
                            System.out.println();
                            System.out.println("You bought " + qt + " shares of Amazon");
                            System.out.println("Your amount left: ₹" + amount);
                            investAZ += Amazon * qt;
                            Amazon = Amazon + qt * Amazon * 0.0004;
                            Amazon = (int) (Amazon * 10000) / 10000.0;
                            amount = (int) (amount * 10000) / 10000.0;
                            b = false;
                            a = false;
                            transaction[0] = "You bought " + qt + " shares of Amazon";
                            setTransaction();
                        } else if (qt == 0) {
                            System.out.println("You have chosen to not buy");
                            System.out.println("Exiting from buy shares");
                            a = false;
                        } else {
                            System.out.println();
                            System.out.println("Insufficient funds or error in quantity, please re-enter");
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("You don't have enough amount, try to buy other shares.");
                }
            } else if (opt.equalsIgnoreCase("Apple")) {
                if (amount > Apple) {
                    System.out.println();
                    System.out.println("Current price: ₹" + Apple);
                    boolean a = true;
                    while (a) {
                        System.out.println("Enter quantity:");
                        int qt = sc.nextInt();
                        sc.nextLine();
                        if (amount >= qt * Apple && qt > 0) {
                            AS += qt;
                            amount = amount - qt * Apple;
                            System.out.println();
                            System.out.println("You bought " + qt + " shares of Apple");
                            System.out.println("Your amount left: ₹" + amount);
                            investAS += Apple * qt;
                            Apple = Apple + qt * Apple * 0.0002;
                            Apple = (int) (Apple * 10000) / 10000.0;
                            amount = (int) (amount * 10000) / 10000.0;
                            b = false;
                            a = false;
                            transaction[0] = "You bought " + qt + " shares of Apple";
                            setTransaction();
                        } else if (qt == 0) {
                            System.out.println("You have chosen to not buy");
                            System.out.println("Exiting from buy shares");
                            a = false;
                        } else {
                            System.out.println();
                            System.out.println("Insufficient funds or error in quantity, please re-enter");
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("You don't have enough amount, try to buy other shares");
                }
            } else if (opt.equalsIgnoreCase("Google")) {
                if (amount > Google) {
                    System.out.println();
                    System.out.println("Current price: ₹" + Google);
                    boolean a = true;
                    while (a) {
                        System.out.println("Enter quantity:");
                        int qt = sc.nextInt();
                        sc.nextLine();
                        if (amount >= qt * Google && qt > 0) {
                            GS += qt;
                            amount = amount - qt * Google;
                            System.out.println();
                            System.out.println("You bought " + qt + " shares of Google");
                            System.out.println("Your amount left: ₹" + amount);
                            investGS += Google * qt;
                            Google = Google + qt * Google * 0.0002;
                            Google = (int) (Google * 10000) / 10000.0;
                            amount = (int) (amount * 10000) / 10000.0;
                            b = false;
                            a = false;
                            transaction[0] = "You bought " + qt + " shares of Google";
                            setTransaction();
                        } else if (qt == 0) {
                            System.out.println("You have chosen to not buy");
                            System.out.println("Exiting from buy shares");
                            a = false;
                        } else {
                            System.out.println();
                            System.out.println("Insufficient funds or error in quantity, please re-enter");
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("You don't have enough amount, try to buy other shares.");
                }
            } else if (opt.equalsIgnoreCase("Microsoft")) {
                if (amount > Microsoft) {
                    System.out.println();
                    System.out.println("Current price: ₹" + Microsoft);
                    boolean a = true;
                    while (a) {
                        System.out.println("Enter quantity:");
                        int qt = sc.nextInt();
                        sc.nextLine();
                        if (amount >= qt * Microsoft && qt > 0) {
                            MS += qt;
                            amount = amount - qt * Microsoft;
                            System.out.println();
                            System.out.println("You bought " + qt + " shares of Microsoft");
                            System.out.println("Your amount left: ₹" + amount);
                            investMS += Microsoft * qt;
                            Microsoft = Microsoft + qt * Microsoft * 0.0003;
                            Microsoft = (int) (Microsoft * 10000) / 10000.0;
                            amount = (int) (amount * 10000) / 10000.0;
                            b = false;
                            a = false;
                            transaction[0] = "You bought " + qt + " shares of Microsoft";
                            setTransaction();
                        } else if (qt == 0) {
                            System.out.println("You have chosen to not buy");
                            System.out.println("Exiting from buy shares");
                            a = false;
                        } else {
                            System.out.println();
                            System.out.println("Insufficient funds or error in quantity, please re-enter");
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("You don't have enough amount, try to buy other shares.");
                }
            } else if (opt.equalsIgnoreCase("Tesla")) {
                if (amount > Tesla) {
                    System.out.println();
                    System.out.println("Current price: ₹" + Tesla);
                    boolean a = true;
                    while (a) {
                        System.out.println("Enter quantity:");
                        int qt = sc.nextInt();
                        sc.nextLine();
                        if (amount >= qt * Tesla && qt > 0) {
                            TS += qt;
                            amount = amount - qt * Tesla;
                            System.out.println();
                            System.out.println("You bought " + qt + " shares of Tesla");
                            System.out.println("Your amount left: ₹" + amount);
                            investTS += Tesla * qt;
                            Tesla = Tesla - qt * Tesla * 0.0001;
                            Tesla = (int) (Tesla * 10000) / 10000.0;
                            amount = (int) (amount * 10000) / 10000.0;
                            b = false;
                            a = false;
                            transaction[0] = "You bought " + qt + " shares of Tesla";
                            setTransaction();
                        } else if (qt == 0) {
                            System.out.println("You have chosen to not buy");
                            System.out.println("Exiting from buy shares");
                            a = false;
                        } else {
                            System.out.println();
                            System.out.println("Insufficient funds or error in quantity, please re-enter");
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("You don't have enough amount, try to buy other shares.");
                }
            } else if (newAdd > 0 && opt.equalsIgnoreCase(added[0]) && amount > addPrices[0]) {
                System.out.println();
                System.out.println("Current price: ₹" + addPrices[0]);
                boolean a = true;
                while (a) {
                    System.out.println("Enter quantity:");
                    int qt = sc.nextInt();
                    sc.nextLine();
                    if (amount >= qt * addPrices[0] && qt > 0) {
                        ST0 += qt;
                        amount = amount - qt * addPrices[0];
                        System.out.println();
                        System.out.println("You bought " + qt + " shares of " + added[0]);
                        System.out.println("Your amount left: ₹" + amount);
                        investST0 += addPrices[0] * qt;
                        addPrices[0] = addPrices[0] - qt * addPrices[0] * 0.0001;
                        addPrices[0] = (int) (addPrices[0] * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You bought " + qt + " shares of " + added[0];
                        setTransaction();
                    } else if (qt == 0) {
                        System.out.println("You have chosen to not buy");
                        System.out.println("Exiting from buy shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Insufficient funds or error in quantity, please re-enter");
                        System.out.println();
                    }
                }
            } else if (newAdd > 1 && opt.equalsIgnoreCase(added[1]) && amount > addPrices[1]) {
                System.out.println();
                System.out.println("Current price: ₹" + addPrices[1]);
                boolean a = true;
                while (a) {
                    System.out.println("Enter quantity:");
                    int qt = sc.nextInt();
                    sc.nextLine();
                    if (amount >= qt * addPrices[1] && qt > 0) {
                        ST1 += qt;
                        amount = amount - qt * addPrices[1];
                        System.out.println();
                        System.out.println("You bought " + qt + " shares of " + added[1]);
                        System.out.println("Your amount left: ₹" + amount);
                        investST1 += addPrices[1] * qt;
                        addPrices[1] = addPrices[1] - qt * addPrices[1] * 0.0001;
                        addPrices[1] = (int) (addPrices[1] * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You bought " + qt + " shares of " + added[1];
                        setTransaction();
                    } else if (qt == 0) {
                        System.out.println("You have chosen to not buy");
                        System.out.println("Exiting from buy shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Insufficient funds or error in quantity, please re-enter");
                        System.out.println();
                    }
                }
            } else if (newAdd > 2 && opt.equalsIgnoreCase(added[2]) && amount > addPrices[2]) {
                System.out.println();
                System.out.println("Current price: ₹" + addPrices[2]);
                boolean a = true;
                while (a) {
                    System.out.println("Enter quantity:");
                    int qt = sc.nextInt();
                    sc.nextLine();
                    if (amount >= qt * addPrices[2] && qt > 0) {
                        // BUG FIX: was incorrectly updating TS instead of ST2
                        ST2 += qt;
                        amount = amount - qt * addPrices[2];
                        System.out.println();
                        System.out.println("You bought " + qt + " shares of " + added[2]);
                        System.out.println("Your amount left: ₹" + amount);
                        investST2 += addPrices[2] * qt;
                        addPrices[2] = addPrices[2] - qt * addPrices[2] * 0.0001;
                        addPrices[2] = (int) (addPrices[2] * 10000) / 10000.0;
                        amount = (int) (amount * 10000) / 10000.0;
                        b = false;
                        a = false;
                        transaction[0] = "You bought " + qt + " shares of " + added[2];
                        setTransaction();
                    } else if (qt == 0) {
                        System.out.println("You have chosen to not buy");
                        System.out.println("Exiting from buy shares");
                        a = false;
                    } else {
                        System.out.println();
                        System.out.println("Insufficient funds or error in quantity, please re-enter");
                        System.out.println();
                    }
                }
            } else if (opt.equalsIgnoreCase("null")) {
                System.out.println("You are exiting from buy shares");
                b = false;
            } else {
                System.out.println();
                System.out.println("Please enter the correct name of shares or check your balance");
            }
        }
    }

    void start() {
        System.out.println(" ");
        System.out.println("Here are the basic rates with which share prices change in this simulator");
        System.out.println("Amazon shares change by 0.35% every 3 minutes");
        System.out.println("Apple shares change by 0.30% every 3 minutes");
        System.out.println("Google shares change by 0.25% every 3 minutes");
        System.out.println("Microsoft shares change by 0.25% every 3 minutes");
        System.out.println("Tesla shares change by 0.20% every 3 minutes");
        System.out.println("Prices of added stocks change randomly every 3 minutes");
    }

    void setTransaction() {
        transaction[5] = transaction[4];
        transaction[4] = transaction[3];
        transaction[3] = transaction[2];
        transaction[2] = transaction[1];
        transaction[1] = transaction[0];
    }

    void displayTransaction() {
        System.out.println();
        System.out.println("-----Transactions:-----");
        for (int i = 1; i < 6; i++) {
            System.out.println(transaction[i]);
        }
        System.out.println("-----------------------");
    }
}