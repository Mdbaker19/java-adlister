public class Album {

    private String artist;
    private Long id;
    private String name;
    private String genre;
    private double sales;
    private int release_date;

    public Album(Long id, String a, String n, String g, double s, int rd){
        this.artist = a;
        this.id = id;
        this.name = n;
        this.genre = g;
        this.sales = s;
        this.release_date = rd;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public int getRelease_date() {
        return release_date;
    }

    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }
}
