import java.io.IOException;

class Main {

    public static void main (String [] args) throws IOException {
        Read read = new Read();
        read.ReadData();

        Excel excel = new Excel();
        excel.WriteToExcel(read.arraylist());
    }
}
