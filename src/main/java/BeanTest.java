import models.Album;
import models.Author;
import models.Quote;

import java.util.ArrayList;
import java.util.Date;

public class BeanTest {
    public static void main(String[] args) {

        Album a7x = new Album();
        /*
        *     private long id;
              private String artist;
              private String name;
              private Date releaseDate;
              private double sales;
              private String genre;*/

        a7x.setId(1L);
        a7x.setArtist("Avenged Sevenfold");
        a7x.setName("Nightmare");
        a7x.setReleaseDate(new Date());
        a7x.setSales(25.5);
        a7x.setGenre("Rock");

        Album reb = new Album();

        reb.setId(2L);
        reb.setArtist("Rebelution");
        reb.setName("Falling into place");
        reb.setReleaseDate(new Date());
        reb.setSales(25.5);
        reb.setGenre("Reggae");

        System.out.println(a7x.getArtist());
        System.out.println(reb.getSales());

        Author me = new Author();
        me.setFirstName("Matt");
        me.setId(1L);
        me.setLastName("B");

        ArrayList<Quote> quotes = new ArrayList<>();
        Quote first = new Quote();
        Quote second = new Quote();

        first.setAuthor(me);
        first.setId(1L);
        first.setContent("It is me");

        second.setAuthor(me);
        second.setId(2L);
        second.setContent("I am myself");

        quotes.add(first);
        quotes.add(second);

        int count = 0;
        for(Quote q : quotes){
            System.out.println(q.getContent() + " Spoken by famous Author : " + q.getAuthor().getFirstName() + " " + q.getAuthor().getLastName());
            if(q.getAuthor().getFirstName().equalsIgnoreCase("matt")){
                count++;
            }
        }
        System.out.println(count + " different quotes spoken by Mr. " + me.getFirstName());




    }
}
