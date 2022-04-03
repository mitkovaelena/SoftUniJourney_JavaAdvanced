package collectionHierarchy;

public class AddRemoveCollection extends CustomCollection implements IAddRemoveCollection{
    public AddRemoveCollection() {
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
        Integer ind = super.length()-1;
        return super.removeAtInd(ind);
    }
}
