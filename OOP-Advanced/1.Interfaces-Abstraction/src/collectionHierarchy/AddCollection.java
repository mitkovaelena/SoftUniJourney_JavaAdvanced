package collectionHierarchy;

public class AddCollection extends CustomCollection implements IAddCollection {
    public AddCollection() {
        super();
    }

    @Override
    public Integer add(String item) {
        Integer ind = super.length();
        super.addAtInd(item, ind);
        return ind;
    }
}
