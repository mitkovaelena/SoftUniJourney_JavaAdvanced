package collectionHierarchy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CustomCollection {
    private List<String> list;

    public CustomCollection() {
        this.list = new ArrayList<>();
    }

    public List<String> getList() {
        return Collections.unmodifiableList(this.list);
    }

    protected void addAtInd(String item, Integer ind){
        this.list.add(ind, item);
    }


    protected String removeAtInd(Integer ind){
        String item = this.list.get(ind);
        this.list.remove(item);
        return item;
    }

    protected Integer length(){
       return this.list.size();
    }
}
