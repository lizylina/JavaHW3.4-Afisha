package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

public class AfishaCustomManagerTest {

    private AfishaManager manager = new AfishaManager(5);

    Film first = new Film(1, "Бладшот", "Боевик", "Image1", false);
    Film second = new Film(2, "Вперёд", "Мультфильм", "Image2", true);
    Film third = new Film(3, "Отель Белград", "Комедия", "Image3", false);
    Film fourth = new Film(4, "Джентльмены", "Боевик", "Image4", false);
    Film fifth = new Film(5, "Человек-невидимка", "Ужасы", "Image5", false);
    Film sixth = new Film(6, "Тролли. Мировой тур", "Мультфильм", "Image6", true);

    @Test
    void shouldAdd() {
        Film[] expected = new Film[]{fifth};
        manager.add(fifth);
        assertArrayEquals(expected, manager.getLastFilms());
    }

    @Test
    void shouldGetFilms() {
        Film[] expected = new Film[]{second, first};
        manager.add(first);
        manager.add(second);

        assertArrayEquals(expected, manager.getLastFilms());
    }

    @Test
    void shouldShowLessThan5() {
        Film[] expected = new Film[]{fifth, fourth, third, second, first};

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        assertArrayEquals(expected, manager.getLastFilms());
    }

    @Test
    void shouldShowMoreThan5() {
        AfishaManager manager = new AfishaManager(6);

        Film[] expected = new Film[]{sixth, fifth, fourth, third, second, first};

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        assertArrayEquals(expected, manager.getLastFilms());
    }

    @Test
    void shouldReturnEmptyAfisha() {
        assertArrayEquals(new Film[0], manager.getLastFilms());
    }
}