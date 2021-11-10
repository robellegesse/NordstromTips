import java.io.IOException;
import java.util.Scanner;

// 
// Created by Robel Legesse
// 

public class TipCalculator {
	int totalServer;
	int totalBusser;
	int totalBar;
	int totalHost;
	int totalExpo;
	int fp; // function pointer
	double cashBusser;
	double cashExpo;
	double cashBar;
	double cashHost;
	Scanner read;

	public TipCalculator() throws IOException {
		read = new Scanner(System.in);
		menu();
	}

	public void menu() {
		totalServer = 0;
		totalBusser = 0;
		totalBar = 0;
		totalHost = 0;
		totalExpo = 0;
		cashBar = 0.0;
		cashExpo = 0.0;
		cashBusser = 0.0;
		cashHost = 0.0;
		fp = -1;
		System.out.println();
		System.out.println("Which function would you like to run?");
		System.out.printf(
				"1 - totalCalculator%n2 - basicCalculator%n3 - busserCalculator%n4 - expoCalculator%n5 - barCalculator%n6 - hostCalculator%nEnter 0 to exit%n",
				new Object[0]);
		fp = read.nextInt();
		if (fp == 0) {
			System.exit(0);
		}
		if (fp == 1) {
			totalCalculator();
		}
		if (fp == 2) {
			basicCalculator();
		}
		if (fp == 3) {
			busserCalculator();
		}
		if (fp == 4) {
			expoCalculator();
		}
		if (fp == 5) {
			barCalculator();
		}
		if (fp == 6) {
			hostCalculator();
		}
	}

	public void totalCalculator() {
		busserCalculator();
		expoCalculator();
		barCalculator();
		hostCalculator();
		if (fp == 1) {
			System.out.println();
			System.out.printf("---totalCalculator is completed---%n", new Object[0]);
			menu();
		}
	}

	public void basicCalculator() {
		payoutServer();
		payoutBar();
		payoutHost();
		totalCalculator();
		if (fp == 2) {
			System.out.println();
			System.out.printf("---basicCalculator is completed---%n", new Object[0]);
			menu();
		}
	}

	public void busserCalculator() {
		if (cashBusser == 0.0) {
			System.out.println("Total cash for Busser?");
			try {
				cashBusser = read.nextDouble();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		System.out.println("Total Busser Cash: $" + getCashBusser());
		splitBusserTips();
		if (fp == 3) {
			System.out.println();
			System.out.printf("---busserCalculator is completed---%n", new Object[0]);
			menu();
		}
	}

	public void expoCalculator() {
		if (cashExpo == 0.0) {
			System.out.println("Total cash for Expo?");
			try {
				cashExpo = read.nextDouble();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		System.out.println("Total Expo Cash: $" + getCashExpo());
		splitExpoTips();
		if (fp == 4) {
			System.out.println();
			System.out.printf("---expoCalculator is completed---%n", new Object[0]);
			menu();
		}
	}

	public void barCalculator() {
		if (cashBar == 0.0) {
			System.out.println("Total cash for Bar?");
			try {
				cashBar = read.nextDouble();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		System.out.println("Total Bar Cash: $" + getCashBar());
		splitBarTips();
		if (fp == 5) {
			System.out.println();
			System.out.printf("---barCalculator is completed---%n", new Object[0]);
			menu();
		}
	}

	public void hostCalculator() {
		if (cashHost == 0.0) {
			System.out.println("Total cash for Host?");
			try {
				cashHost = read.nextDouble();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		System.out.println("Total Host Cash: $" + getCashHost());
		splitHostTips();
		if (fp == 6) {
			System.out.println();
			System.out.printf("---hostCalculator is completed---%n", new Object[0]);
			menu();
		}
	}

	public double getCashBar() {
		return (double) Math.round(cashBar);
	}

	public double getCashBusser() {
		return (double) Math.round(cashBusser);
	}

	public double getCashExpo() {
		return (double) Math.round(cashExpo);
	}

	public double getCashHost() {
		return (double) Math.round(cashHost);
	}

	public void payoutServer() {
		if (totalServer == 0) {
			System.out.println("How many working Servers?");
			try {
				totalServer = read.nextInt();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		double totalTips = 0.0;
		for (int i = 0; i < totalServer; ++i) {
			System.out.println(String.format("Enter total tips for Server %d:", i + 1));
			try {
				totalTips = read.nextFloat();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
			cashExpo += totalTips * 0.0125;
			cashBusser += totalTips * 0.015;
			cashHost += totalTips * 0.005;
		}
	}

	public void payoutHost() {
		if (totalHost == 0) {
			System.out.println("How many working Host?");
			try {
				totalHost = read.nextInt();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		double totalTips = 0.0;
		for (int i = 0; i < totalHost; ++i) {
			System.out.println(String.format("Enter total tips for Host %d:", i + 1));
			try {
				totalTips = read.nextFloat();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
			cashExpo += totalTips * 0.2;
		}
	}

	public void payoutBar() {
		if (totalBar == 0) {
			System.out.println("How many working Bar?");
			try {
				totalBar = read.nextInt();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		double totalTips = 0.0;
		for (int i = 0; i < totalBar; ++i) {
			System.out.println(String.format("Enter total tips for Bar %d:", i + 1));
			try {
				totalTips = read.nextFloat();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
			cashExpo += totalTips * 0.0125;
			cashBusser += totalTips * 0.015;
			cashHost += totalTips * 0.005;
		}
	}

	public void splitBusserTips() {
		if (totalBusser == 0) {
			System.out.println("How many working Bussers?");
			try {
				totalBusser = read.nextInt();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		double totalHours = 0.0;
		final double[] hoursWorked = new double[totalBusser];
		final double[] tipPercentage = new double[totalBusser];
		for (int i = 0; i < totalBusser; ++i) {
			System.out.println(String.format("How many hours did Busser %d work:", i + 1));
			try {
				hoursWorked[i] = read.nextDouble();
			} catch (Exception e2) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		for (int i = 0; i < totalBusser; ++i) {
			totalHours += hoursWorked[i];
		}
		for (int i = 0; i < totalBusser; ++i) {
			tipPercentage[i] = hoursWorked[i] / totalHours;
		}
		for (int i = 0; i < totalBusser; ++i) {
			System.out.println(
					String.format("Busser %d split is: $%d", i + 1, Math.round(getCashBusser() * tipPercentage[i])));
		}
	}

	public void splitExpoTips() {
		if (totalExpo == 0) {
			System.out.println("How many working Expo?");
			try {
				totalExpo = read.nextInt();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		double totalHours = 0.0;
		final double[] hoursWorked = new double[totalExpo];
		final double[] tipPercentage = new double[totalExpo];
		for (int i = 0; i < totalExpo; ++i) {
			System.out.println(String.format("How many hours did Expo %d work:", i + 1));
			try {
				hoursWorked[i] = read.nextDouble();
			} catch (Exception e2) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		for (int i = 0; i < totalExpo; ++i) {
			totalHours += hoursWorked[i];
		}
		for (int i = 0; i < totalExpo; ++i) {
			tipPercentage[i] = hoursWorked[i] / totalHours;
		}
		for (int i = 0; i < totalExpo; ++i) {
			System.out.println(
					String.format("Expo %d split is: $%d", i + 1, Math.round(getCashExpo() * tipPercentage[i])));
		}
	}

	public void splitBarTips() {
		if (totalBar == 0) {
			System.out.println("How many working Bar?");
			try {
				totalBar = read.nextInt();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		double totalHours = 0.0;
		final double[] hoursWorked = new double[totalBar];
		final double[] tipPercentage = new double[totalBar];
		for (int i = 0; i < totalBar; ++i) {
			System.out.println(String.format("How many hours did Bar %d work:", i + 1));
			try {
				hoursWorked[i] = read.nextDouble();
			} catch (Exception e2) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		for (int i = 0; i < totalBar; ++i) {
			totalHours += hoursWorked[i];
		}
		for (int i = 0; i < totalBar; ++i) {
			tipPercentage[i] = hoursWorked[i] / totalHours;
		}
		for (int i = 0; i < totalBar; ++i) {
			System.out
					.println(String.format("Bar %d split is: $%d", i + 1, Math.round(getCashBar() * tipPercentage[i])));
		}
	}

	public void splitHostTips() {
		if (totalHost == 0) {
			System.out.println("How many working Host?");
			try {
				totalHost = read.nextInt();
			} catch (Exception e) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		double totalHours = 0.0;
		final double[] hoursWorked = new double[totalHost];
		final double[] tipPercentage = new double[totalHost];
		for (int i = 0; i < totalHost; ++i) {
			System.out.println(String.format("How many hours did Host %d work:", i + 1));
			try {
				hoursWorked[i] = read.nextDouble();
			} catch (Exception e2) {
				System.out.println("Not valid input... Resetting program");
				read.next();
				menu();
			}
		}
		for (int i = 0; i < totalHost; ++i) {
			totalHours += hoursWorked[i];
		}
		for (int i = 0; i < totalHost; ++i) {
			tipPercentage[i] = hoursWorked[i] / totalHours;
		}
		for (int i = 0; i < totalHost; ++i) {
			System.out.println(
					String.format("Host %d split is: $%d", i + 1, Math.round(getCashHost() * tipPercentage[i])));
		}
	}
}