package tests;

import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.annotations.Burnable;
import app.waste_disposal.annotations.Recyclable;
import app.waste_disposal.annotations.Storable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.models.strategies.BurnableGarbageDisposalStrategy;
import app.waste_disposal.models.strategies.RecyclableGarbageDisposalStrategy;
import app.waste_disposal.models.waste.BurnableGarbage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class StrategyHolderShould {

    private StrategyHolder strategyHolder;
    private GarbageDisposalStrategy disposalStrategy;

    @Before
    public void initializeTestObjects() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.disposalStrategy = new BurnableGarbageDisposalStrategy();
    }

    @Test
    public void testTheDefaultConstructor(){
        Assert.assertEquals(this.strategyHolder.getDisposalStrategies(), new LinkedHashMap<Class, GarbageDisposalStrategy>());
    }

    @Test
    public void testTheConstructor(){
        Map<Class, GarbageDisposalStrategy> testMap = new LinkedHashMap<>();
        testMap.put(Burnable.class, this.disposalStrategy);
        this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy);
        Assert.assertEquals(this.strategyHolder.getDisposalStrategies(), testMap);
    }

    @Test ( expected = UnsupportedOperationException.class)
    public void testGetDisposalStrategiesShouldBeUnmodifiable(){
        this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy);
        this.strategyHolder.getDisposalStrategies().clear();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetDisposalStrategiesShouldBeUnmodifiable2(){
        this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy);
        this.strategyHolder.getDisposalStrategies().put(Recyclable.class, this.disposalStrategy);
    }

    @Test
    public void testAddStrategyWithCorrectInput(){
        Assert.assertTrue(this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddStrategyWithInCorrectInput(){
        Assert.assertTrue(this.strategyHolder.addStrategy(BurnableGarbage.class, this.disposalStrategy));
    }

    @Test
    public void testAddStrategyWithCorrectInputShouldReturnMapWithAll(){
        this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy);
        this.strategyHolder.addStrategy(Recyclable.class, this.disposalStrategy);
        this.strategyHolder.addStrategy(Storable.class, this.disposalStrategy);
        Assert.assertTrue(this.strategyHolder.getDisposalStrategies().containsKey(Burnable.class));
        Assert.assertTrue(this.strategyHolder.getDisposalStrategies().containsKey(Recyclable.class));
        Assert.assertTrue(this.strategyHolder.getDisposalStrategies().containsKey(Storable.class));
        Assert.assertTrue(this.strategyHolder.getDisposalStrategies().containsValue(this.disposalStrategy));
    }

    @Test
    public void testMultipleAddStrategyWithCorrectInput(){
        Assert.assertTrue(this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy));
        Assert.assertTrue(this.strategyHolder.addStrategy(Recyclable.class, this.disposalStrategy));
        Assert.assertTrue(this.strategyHolder.addStrategy(Storable.class, this.disposalStrategy));
    }

    @Test
    public void testAddStrategyWithIncorrectInput(){
        Assert.assertTrue(this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy));
        Assert.assertFalse(this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy));
    }

    @Test
    public void testRemoveStrategyWithCorrectInput(){
        Assert.assertTrue(this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy));
        Assert.assertTrue(this.strategyHolder.removeStrategy(Burnable.class));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveStrategyWithInCorrectClassInput(){
        Assert.assertTrue(this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy));
        Assert.assertTrue(this.strategyHolder.removeStrategy(BurnableGarbage.class));
    }

    @Test
    public void testRemoveStrategyWithIncorrectInput(){
        Assert.assertFalse(this.strategyHolder.removeStrategy(Burnable.class));
    }

    @Test
    public void testReturnStrategyWithCorrectInputShouldReturnMapWithoutRemovedElement(){
        GarbageDisposalStrategy gds = new RecyclableGarbageDisposalStrategy();
        this.strategyHolder.addStrategy(Burnable.class, this.disposalStrategy);
        this.strategyHolder.addStrategy(Recyclable.class, this.disposalStrategy);
        this.strategyHolder.addStrategy(Storable.class, this.disposalStrategy);
        this.strategyHolder.removeStrategy(Recyclable.class);
        Assert.assertTrue(this.strategyHolder.getDisposalStrategies().containsKey(Burnable.class));
        Assert.assertFalse(this.strategyHolder.getDisposalStrategies().containsKey(Recyclable.class));
        Assert.assertTrue(this.strategyHolder.getDisposalStrategies().containsKey(Storable.class));
        Assert.assertTrue(this.strategyHolder.getDisposalStrategies().containsValue(this.disposalStrategy));
        Assert.assertFalse(this.strategyHolder.getDisposalStrategies().containsValue(gds));
    }

}