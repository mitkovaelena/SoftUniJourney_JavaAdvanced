package collectionHierarchy;

public class MyList extends CustomCollection implements IMyList{
    public MyList() {
        super();
    }

    @Override
    public Integer add(String item) {
        Integer ind = 0;
        super.addAtInd(item, ind);
        return ind;
    }

    @Override
    public String remove() {
        Integer ind = 0;
        return super.removeAtInd(ind);

    }

    @Override
    public Integer used() {
        return super.length();
    }
}
