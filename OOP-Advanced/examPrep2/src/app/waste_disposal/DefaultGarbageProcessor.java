package app.waste_disposal;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.*;

import java.lang.annotation.Annotation;

public class DefaultGarbageProcessor implements GarbageProcessor {
    private static String GARBAGE_DISPOSAL_STRATEGY_STRING = "GarbageDisposalStrategy";
    private static final String STRATEGY_PACKAGE = "app.waste_disposal.models.strategies.";

    private StrategyHolder strategyHolder;

    public DefaultGarbageProcessor() {
        this.setStrategyHolder(new DefaultStrategyHolder());
    }

    public DefaultGarbageProcessor(StrategyHolder strategyHolder){
        this.setStrategyHolder(strategyHolder);
    }

    private void setStrategyHolder(StrategyHolder strategyHolder) {
        if (strategyHolder == null) {
            throw new IllegalArgumentException();
        }
        this.strategyHolder = strategyHolder;
    }

    @Override
    public StrategyHolder getStrategyHolder() {
        return this.strategyHolder;
    }

    @Override
    public ProcessingData processWaste(Waste garbage) {
        Class type = garbage.getClass();
        Annotation[] garbageAnnotations = type.getAnnotations();
        Class disposableAnnotation = null;
        for (Annotation annotation : garbageAnnotations) {
            if(annotation.annotationType().isAnnotationPresent(Disposable.class)){
                disposableAnnotation = annotation.annotationType();
                break;
            }
        }

        GarbageDisposalStrategy currentStrategy;
        if (disposableAnnotation == null )
        {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
        } else if(!this.getStrategyHolder().getDisposalStrategies().containsKey(disposableAnnotation)){
            try {
                this.createStrategy(disposableAnnotation);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e){
                throw new IllegalArgumentException(
                        "The passed in garbage does not implement an annotation implementing the Disposable meta-annotation or is not supported by the StrategyHolder.");
            }
        }

        currentStrategy = this.getStrategyHolder().getDisposalStrategies().get(disposableAnnotation);
        return currentStrategy.processGarbage(garbage);
    }

    private void createStrategy(Class strategyAnnotation) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<GarbageDisposalStrategy> strategyClass = (Class<GarbageDisposalStrategy>)
                Class.forName(STRATEGY_PACKAGE + strategyAnnotation.getSimpleName() + GARBAGE_DISPOSAL_STRATEGY_STRING);
        GarbageDisposalStrategy strategy = strategyClass.newInstance();
        this.getStrategyHolder().addStrategy(strategyAnnotation, strategy);
    }
}
