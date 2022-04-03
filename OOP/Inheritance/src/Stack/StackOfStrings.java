package Stack;

import java.util.ArrayList;

public class StackOfStrings {
   private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<String>();
    }

    public void push(String item){
        data.add(item);
    }

    public String pop(){
        if(data.isEmpty()){
            throw new IndexOutOfBoundsException("StackOfStrings is empty");
        }
        String element = data.get(data.size()-1);
        data.remove(data.size()-1);
        return element;
    }

    public String peek(){
        if(data.isEmpty()){
            throw new IndexOutOfBoundsException("StackOfStrings is empty");
        }
        return data.get(data.size()-1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
