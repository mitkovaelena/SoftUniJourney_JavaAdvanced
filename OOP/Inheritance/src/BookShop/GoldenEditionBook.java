package BookShop;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String author, String title, Double price) {
        super(author, title, price);
    }

    @Override
    protected void setPrice(Double price) {
        if ( price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        super.setPrice(price+price*0.3);
    }

}
