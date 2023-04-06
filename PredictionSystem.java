import java.util.*;
import java.io.*;

public class PredictionSystem {

    public static void main(String[] args) {
        Laptop NewLaptop = new Laptop();
        PredictingBar NewBar = new PredictingBar();
        Processors NewProcessor = new Processors();
        GPUs NewGpu = new GPUs();
        RAMs NewRam = new RAMs();
        Storages NewStorage = new Storages();
        WebStores NewWebStore = new WebStores();
        NewLaptop.Clear();
        System.out.println("Welcome to our Requirement Based Laptop Price Prediction system\n".toUpperCase());

        double PredictedPrice = NewProcessor.Show() + NewGpu.Show() + NewRam.Show() + NewStorage.Show()
                + NewWebStore.Show();
        NewBar.Predict();
        NewLaptop.Clear();
        System.out.println("\nThe predicted price of requirement based laptop is :- ".toUpperCase() + PredictedPrice);
    }
}

class PredictingBar {
    public void Predict() {
        int Total = 100;
        int Progress = 0;
        while (Progress <= Total) {

            System.out.print("\rPredicting: [".toUpperCase());
            int count = (int) (((double) Progress / Total) * 20);
            for (int i = 0; i < count; i++) {
                System.out.print("=");
            }
            for (int i = count; i < 20; i++) {
                System.out.print(" ");
            }
            System.out.print("] " + Progress + "%");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Progress++;
        }
        System.out.println("\n");
    }
}

class Laptop {
    String Line = "";
    String CSVSplitBy = ",";
    int SerialNumber = 1;
    Scanner Input = new Scanner(System.in);

    public void Waiting() {
        try {
            System.out.println("\n");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Clear();
    }

    public void Clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class Processors extends Laptop {
    public double Show() {
        System.out.println("Processors Available :-".toUpperCase());
        try (BufferedReader File = new BufferedReader(new FileReader("Processors.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0]);
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Select();

    }

    public double Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        double PredictedPrice = 0;
        System.out.print("\n\tPlease select Processor:- ".toUpperCase());
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("Processors.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);

                        System.out.println("\n !!! Processor Added !!!".toUpperCase());

                        Waiting();

                        return value;
                    }
                }
                CurrentRow++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PredictedPrice;
    }
}

class GPUs extends Laptop {
    public double Show() {
        System.out.println("GPUs Available :-".toUpperCase());
        try (BufferedReader File = new BufferedReader(new FileReader("GPUs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0]);
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Select();

    }

    public double Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        double PredictedPrice = 0;
        System.out.print("\n\tPlease select gpu:- ".toUpperCase());
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("GPUs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);

                        System.out.println("\n !!! gpu Added !!!".toUpperCase());

                        Waiting();

                        return value;
                    }
                } 
                CurrentRow++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PredictedPrice;
    }
}

class RAMs extends Laptop {
    public double Show() {
        System.out.println("Rams Available :-".toUpperCase());
        try (BufferedReader File = new BufferedReader(new FileReader("RAMs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0]);
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Select();

    }

    public double Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        double PredictedPrice = 0;
        System.out.print("\n\tPlease select ram:- ".toUpperCase());
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("RAMs.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);

                        System.out.println("\n !!! ram Added !!!".toUpperCase());

                        Waiting();

                        return value;
                    }
                } 
                CurrentRow++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PredictedPrice;
    }
}

class Storages extends Laptop {
    public double Show() {
        System.out.println("Storages Available :-".toUpperCase());
        try (BufferedReader File = new BufferedReader(new FileReader("WebStores.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0]);
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Select();

    }

    public double Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        double PredictedPrice = 0;
        System.out.print("\n\tPlease select storage:- ".toUpperCase());
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("WebStores.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);

                        System.out.println("\n !!! storage Added !!!".toUpperCase());

                        Waiting();

                        return value;
                    }
                }
                CurrentRow++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PredictedPrice;
    }
}

class WebStores extends Laptop {
    public double Show() {
        System.out.println("WebStores Available :-".toUpperCase());
        try (BufferedReader File = new BufferedReader(new FileReader("WebStores.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                System.out.println("\n\t" + SerialNumber + " " + data[0]);
                SerialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Select();

    }

    public double Select() {
        int CurrentRow = 0;
        int ColumnNumber = 1;
        double PredictedPrice = 0;
        System.out.print("\n\tPlease select WebStore:- ".toUpperCase());
        int SelectRow = Input.nextInt();
        try (BufferedReader File = new BufferedReader(new FileReader("WebStores.csv"))) {
            while ((Line = File.readLine()) != null) {
                String[] data = Line.split(CSVSplitBy);
                if (CurrentRow == SelectRow - 1) {
                    if (ColumnNumber < data.length) {
                        double value = Double.parseDouble(data[ColumnNumber]);

                        System.out.println("\n !!! WebStore Selected !!!".toUpperCase());

                        Waiting();

                        return value;
                    }
                } 
                CurrentRow++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return PredictedPrice;
    }
}
