package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;



public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Питание не соответствует", expectedFood, actualFood);
    }

    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Некорректное семейство", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensTest() {
        Feline spyFeline = Mockito.spy(feline);
        int result = spyFeline.getKittens();
        assertEquals("Количество котят не соответствует", 1, result);
        Mockito.verify(spyFeline).getKittens(1);
    }

    @Test
    public void getKittensCountTest() {
        int expectedKittensCount = 3;
        int actualKittensCount = feline.getKittens(3);
        assertEquals("Неверное количество котят", expectedKittensCount, actualKittensCount);
    }
}