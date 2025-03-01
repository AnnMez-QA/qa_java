package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;


public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {

        feline = spy(new Feline());
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Питание не соответствует", expectedFood, actualFood);
    }

    @Test
    public void getFamilyTest() {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Некорректное семейство", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensTest() {
        int result = feline.getKittens();
        assertEquals(1, result);
        Mockito.verify(feline).getKittens(eq(1));
    }

    @Test
    public void getKittensCountTest() {
        Mockito.when(feline.getKittens(3)).thenReturn(3);
        int expectedKittensCount = 3;
        int actualKittensCount = feline.getKittens(3);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}