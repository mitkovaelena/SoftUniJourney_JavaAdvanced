package tests;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InventoryClassTests {
    private static final int SMALL_TEST_VALUE = 5;
    private static final long LONG_TEST_VALUE = 5L + Integer.MAX_VALUE;
    private static final String TEST_NAME = "Eli";
    private static final String TEST_NAME2 = "Elena";
    private static final String TEST_NAME3 = "bored";
    private Inventory inventory;

    @Before
    public void initializeTestObjects() {
        this.inventory = new HeroInventory();
    }

    @Test
    public void testTheDefaultConstructor() throws IllegalAccessException {
        Map<String, Item> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (LinkedHashMap<String, Item>) field.get(this.inventory);
            }
        }

        Assert.assertEquals(items, new LinkedHashMap<String, Item>());
        Assert.assertTrue(items.isEmpty());
    }

    @Test
    public void testTheDefaultConstructor2() throws IllegalAccessException {
        Map<String, Recipe> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (LinkedHashMap<String, Recipe>) field.get(this.inventory);
            }
        }

        Assert.assertEquals(items, new LinkedHashMap<String, Recipe>());
        Assert.assertTrue(items.isEmpty());
    }

    @Test
    public void testAddCommonItem() throws IllegalAccessException {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Mockito.when(item.getStrengthBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item.getAgilityBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item.getHitPointsBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item.getDamageBonus()).thenReturn(SMALL_TEST_VALUE);

        this.inventory.addCommonItem(item);
        Map<String, Item> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (LinkedHashMap<String, Item>) field.get(this.inventory);
            }
        }

        System.out.println(items.get(TEST_NAME));
        Assert.assertEquals(items.get(TEST_NAME).getStrengthBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getAgilityBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getIntelligenceBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getHitPointsBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getDamageBonus(), SMALL_TEST_VALUE);
    }

    @Test
    public void testEqualCommonItems() throws IllegalAccessException {
        Item item = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME);


        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);

        Map<String, Item> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (LinkedHashMap<String, Item>) field.get(this.inventory);
            }
        }

        Assert.assertEquals(1, items.size());
    }

    @Test
    public void testEqualRecepies() throws IllegalAccessException {
        Recipe item = Mockito.mock(Recipe.class);
        Recipe item2 = Mockito.mock(Recipe.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME);


        this.inventory.addRecipeItem(item);
        this.inventory.addRecipeItem(item2);

        Map<String, Recipe> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();
        fields[1].setAccessible(true);

        items = (LinkedHashMap<String, Recipe>) fields[1].get(this.inventory);

        Assert.assertEquals(1, items.size());
    }

    @Test
    public void testAddRecepie() throws IllegalAccessException, NoSuchFieldException {
        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(recipe.getName()).thenReturn(TEST_NAME);
        Mockito.when(recipe.getStrengthBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(recipe.getAgilityBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(recipe.getIntelligenceBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(recipe.getHitPointsBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(recipe.getDamageBonus()).thenReturn(SMALL_TEST_VALUE);

        this.inventory.addRecipeItem(recipe);
        Map<String, Recipe> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field field = inventoryClass.getDeclaredField("recipeItems");
        field.setAccessible(true);
        items = (LinkedHashMap<String, Recipe>) field.get(this.inventory);

        Assert.assertEquals(items.get(TEST_NAME).getStrengthBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getAgilityBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getIntelligenceBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getHitPointsBonus(), SMALL_TEST_VALUE);
        Assert.assertEquals(items.get(TEST_NAME).getDamageBonus(), SMALL_TEST_VALUE);
    }


    @Test
    public void testgetTotalStrengthBonus() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getStrengthBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(SMALL_TEST_VALUE, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testgetTotalAgilityBonus() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getAgilityBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(SMALL_TEST_VALUE, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void testgetTotalIntelligenceBonus() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(SMALL_TEST_VALUE, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void testgetTotalHitPointsBonus() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getHitPointsBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(SMALL_TEST_VALUE, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void testgetTotalDamageBonus() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getDamageBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(SMALL_TEST_VALUE, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void testgetTotalStrengthBonusMultipleValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getStrengthBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item2.getStrengthBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(SMALL_TEST_VALUE * 2, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testgetTotalAgilityBonusMultipleValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getAgilityBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item2.getAgilityBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(SMALL_TEST_VALUE * 2, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void testgetTotalIntelligenceBonusMultipleValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item2.getIntelligenceBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(SMALL_TEST_VALUE * 2, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void testgetTotalHitPointsBonusMultipleValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getHitPointsBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item2.getHitPointsBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(SMALL_TEST_VALUE * 2, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void testgetTotalDamageBonusMultipleValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getDamageBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item2.getDamageBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(SMALL_TEST_VALUE * 2, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void testgetTotalStrengthBonusMultipleValuesBigValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getStrengthBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getStrengthBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(LONG_TEST_VALUE, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testgetTotalAgilityBonusMultipleValuesBigValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getAgilityBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getAgilityBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(LONG_TEST_VALUE, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void testgetTotalIntelligenceBonusMultipleValuesBigValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(SMALL_TEST_VALUE);
        Mockito.when(item2.getIntelligenceBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(SMALL_TEST_VALUE * 2, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void testgetTotalHitPointsBonusMultipleValuesBigValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getHitPointsBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getHitPointsBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(LONG_TEST_VALUE, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void testgetTotalDamageBonusMultipleValuesBigValues() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Item item2 = Mockito.mock(Item.class);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(item.getDamageBonus()).thenReturn(Integer.MAX_VALUE);
        Mockito.when(item2.getDamageBonus()).thenReturn(SMALL_TEST_VALUE);
        this.inventory.addCommonItem(item);
        this.inventory.addCommonItem(item2);
        Assert.assertEquals(LONG_TEST_VALUE, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void combineRecepieShouldWorkCorectly() throws IllegalAccessException {
        List<String> tempList = new LinkedList();
        Item item = Mockito.mock(Item.class);
        Item item2 = Mockito.mock(Item.class);
        Recipe recipe = Mockito.mock(Recipe.class);
        Mockito.when(item.getName()).thenReturn(TEST_NAME);
        Mockito.when(item2.getName()).thenReturn(TEST_NAME2);
        Mockito.when(recipe.getName()).thenReturn(TEST_NAME3);
        Mockito.when(recipe.getRequiredItems()).thenReturn(tempList);
        this.inventory.addCommonItem(item);
        this.inventory.addRecipeItem(recipe);

        this.inventory.addCommonItem(item);
        Map<String, Item> items = null;

        Class inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (LinkedHashMap<String, Item>) field.get(this.inventory);
            }
        }

        Assert.assertEquals(2, items.size());
    }
}
