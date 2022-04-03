package app.waste_disposal;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {

    private Map<Class,GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder(){
        this.strategies = new LinkedHashMap<>();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if(!annotationClass.isAnnotationPresent(Disposable.class)){
            throw new IllegalArgumentException("The passed in class does not implement @Disposable annotation!");
        }
        if(this.strategies.containsKey(annotationClass)){
            return false;
        }
        this.strategies.put(annotationClass,strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if(!annotationClass.isAnnotationPresent(Disposable.class)){
            throw new IllegalArgumentException("The passed in class does not implement @Disposable annotation!");
        }
        if(!this.strategies.containsKey(annotationClass)){
            return false;
        }
        this.strategies.remove(annotationClass);
        return true;
    }
}
