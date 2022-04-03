package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList{
    public Object getRandomElement(){
        Random rnd = new Random();
        int randomNum = rnd.nextInt() % (this.size() + 1);
        Object obj = this.get(randomNum);
        this.remove(randomNum);
        return obj;
    }
}
