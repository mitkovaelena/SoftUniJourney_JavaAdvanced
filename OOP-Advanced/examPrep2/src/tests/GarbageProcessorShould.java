package tests;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.contracts.*;
import app.waste_disposal.models.data.ProcessingDataImpl;
import app.waste_disposal.models.waste.BurnableGarbage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedHashMap;
import java.util.Map;

public class GarbageProcessorShould {

    private final Map<Class, GarbageDisposalStrategy> strategies = new LinkedHashMap<>();

    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolder;
    private ProcessingData processingData = new ProcessingDataImpl(0,0);
    private GarbageDisposalStrategy garbageDisposalStrategy;
    private Waste garbage = new BurnableGarbage("e", 0,0);

    @Before
    public void initializeTestObjects() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolder);
    }

    @Test
    public void testTheDefaultConstructor(){
        Assert.assertEquals(this.garbageProcessor.getStrategyHolder(), this.strategyHolder);
    }

    @Test
    public void testTheConstructor(){
        this.garbageProcessor = new DefaultGarbageProcessor();
        Assert.assertEquals(this.garbageProcessor.getStrategyHolder().getClass(), DefaultStrategyHolder.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenNullStrategyHolderIsPassed() {
        this.garbageProcessor = new DefaultGarbageProcessor(null);
    }

    @Test
    public void correctInputShouldReturnProcessingData(){
        ProcessingData pd = this.garbageProcessor.processWaste(this.garbage);
        Assert.assertTrue(this.processingData.getEnergyBalance() == pd.getEnergyBalance());
        Assert.assertTrue(this.processingData.getCapitalBalance() == pd.getCapitalBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonDisposaleWasteSHouldThrowErr(){
        this.garbage = Mockito.mock(Waste.class);
        ProcessingData pd = this.garbageProcessor.processWaste(this.garbage);
    }

}

