import java.util.*;
import java.io.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;

public class PredictionSystem {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int consoleWidth = (int) (screenSize.getWidth() * 0.75);
        int consoleMaxWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        int spacesBefore = (consoleMaxWidth - consoleWidth) / 2;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        LoadingBar NewBar = new LoadingBar();
        NewBar.Loading();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String text = "Welcome to our Requirement Based Laptop Price Prediction system";
        String output = String.format("%" + (spacesBefore + text.length()) + "s", text);
        System.out.println(output);
        Processors NewProcessor = new Processors();
        NewProcessor.Show();
        try {
            System.out.println("\n!!! Processor Added !!!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GPUs NewGpu = new GPUs();
        NewGpu.Show();
        try {
            System.out.println("\n!!! GPU Added !!!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RAMs NewRAM = new RAMs();
        NewRAM.Show();
        try {
            System.out.println("\n!!! RAM Added !!!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LoadingBar {
    public void Loading() {
        int total = 100; // total number of iterations
        int progress = 0; // current progress

        while (progress <= total) {

            System.out.print("\rProgress: [");
            int count = (int) (((double) progress / total) * 20);
            for (int i = 0; i < count; i++) {
                System.out.print("=");
            }
            for (int i = count; i < 20; i++) {
                System.out.print(" ");
            }
            System.out.print("] " + progress + "%");
            try {
                Thread.sleep(10); // simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress++;
        }
        System.out.println("\n");
    }
}

class Laptop {
    String Line = "";
    String CSVSplitBy = ",";
    int SerialNumber = 1;
    Scanner Input = new Scanner(System.in);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int consoleWidth = (int) (screenSize.getWidth() * 0.75);
    int consoleMaxWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    int spacesBefore = (consoleMaxWidth - consoleWidth) / 2;

}

class Processors extends Laptop {
    public void Show() {
        System.out.println("Processor");
        try (BufferedReader File = new BufferedReader(new FileReader("Processors.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0] + "\n");
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Select();
    }

    public void Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        System.out.print("Please select processor:- ");
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("Processors.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);
                        Price(value);
                        break;
                    } else {
                        System.out.println("Column number is out of range");
                        break;
                    }
                }
                CurrentRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Price(double value) {
        double temp = value;
        System.out.print("Price of processor:- " + temp);
    }

}

class GPUs extends Laptop {
    public void Show() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("GPUs:- ");
        try (BufferedReader File = new BufferedReader(new FileReader("GPUs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0] + "\n");
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Select();
    }

    public void Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        System.out.print("Please select GPU:- ");
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("GPUs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);
                        Price(value);
                        break;
                    } else {
                        System.out.println("Column number is out of range");
                        break;
                    }
                }
                CurrentRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Price(double value) {
        double temp = value;
        System.out.print("Price of GPUs:- " + temp);
    }
}

class RAMs extends Laptop {
    public void Show() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("RAMs:- ");
        try (BufferedReader File = new BufferedReader(new FileReader("RAMs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0] + "\n");
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Select();
    }

    public void Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        System.out.print("Please select RAM:- ");
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("RAMs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);
                        Price(value);
                        break;
                    } else {
                        System.out.println("Column number is out of range");
                        break;
                    }
                }
                CurrentRow++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Price(double value) {
        double temp = value;
        System.out.print("Price of RAM:- " + temp);
    }
}