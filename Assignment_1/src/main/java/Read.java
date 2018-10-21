import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;

class Read {

    private final ArrayList<Data> data = new ArrayList();

    public void ReadData() throws IOException {

        org.jsoup.nodes.Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();
        // select table by its title
        org.jsoup.nodes.Element table = doc.select("span#Trivia").parents().first().nextElementSibling();
        org.jsoup.select.Elements rows = table.select("tr");

        for (org.jsoup.nodes.Element row : rows) {
            String th = row.select("th").text();
            String td = row.select("td").text();

            data.add(new Data(th, td));

            System.out.print(row.select("th").text());
            System.out.print("  :  ");
            System.out.print(row.select("td").text());
            System.out.println();

        }

    }
    public ArrayList<Data> arraylist() {
        return data;
    }

}
