package spittr.data;

import org.springframework.context.annotation.Configuration;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class SpittleRepositoryImpl implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> list = new ArrayList<Spittle>();
        list.add(new Spittle("First!", new Date(), 33.0, 55.0));
        list.add(new Spittle("Second!", new Date(), 54.0, 51.0));
        list.add(new Spittle("Third!", new Date(), 16.3, 87.3));
        return list;
    }

    public Spittle findOne(long id) {
        //TODO
        return new Spittle("Hello world! First ever spittle", new Date());
    }
}
