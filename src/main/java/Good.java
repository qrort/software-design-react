
import org.bson.Document;


public class Good {
    public final int id;
    public final String name;
    public final String ruble;
    public final String euro;
    public final String dollar;

    public Good(int id, String name, String ruble, String euro, String dollar) {
        this.id = id;
        this.name = name;
        this.ruble = ruble;
        this.euro = euro;
        this.dollar = dollar;
    }

    public Good(Document document) {
        this(document.getInteger("id"),
                document.getString("name"),
                document.getString("ruble"),
                document.getString("euro"),
                document.getString("dollar"));
    }

    public Document toDocument() {
        return new Document("id", id)
                .append("name", name)
                .append("ruble", ruble)
                .append("dollar", dollar)
                .append("euro", euro);
    }

    public String toString(String currency) {
        String price = "";
        switch (currency) {
            case "ruble":
                price = "ruble=" + ruble;
                break;
            case "euro":
                price = "euro=" + euro;
                break;
            case "dollar":
                price = "dollar=" + dollar;
                break;
        }
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", " + price  +
                '}';
    }
}
