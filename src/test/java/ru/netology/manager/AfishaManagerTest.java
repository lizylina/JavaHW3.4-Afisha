package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

public class AfishaManagerTest {

    private AfishaManager manager = new AfishaManager(10);

    Film first = new Film(1, "Бладшот", "Боевик", "Image1", false);
    Film second = new Film(2, "Вперёд", "Мультфильм", "Image2", true);
    Film third = new Film(3, "Отель Белград", "Комедия", "Image3", false);
    Film fourth = new Film(4, "Джентльмены", "Боевик", "Image4", false);
    Film fifth = new Film(5, "Человек-невидимка", "Ужасы", "Image5", false);
    Film sixth = new Film(6, "Тролли. Мировой тур", "Мультфильм", "Image6", true);
    Film seventh = new Film(7, "Номер один", "Комедия", "Image7", true);
    Film eighth = new Film(8, "Довод", "Фантастика", "Image8", false);
    Film ninth = new Film(9, "Новые мутанты", "Ужасы", "Image9", true);
    Film tenth = new Film(10, "Мулан", "Боевик", "Image10", false);
    Film eleventh = new Film(11, "Гренландия", "Боевик", "Image11", false);

    @Test
    void shouldAdd() {
        Film[] expected = new Film[]{tenth};
        manager.add(tenth);
        assertArrayEquals(expected, manager.getLastFilms());
    }

    @Test
    void shouldShowLessThanDefault() {
        Film[] expected = new Film[]{fifth, fourth, third, second, first};

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        assertArrayEquals(expected, manager.getLastFilms());
    }

    @Test
    void shouldShowMoreThanDefault() {
        AfishaManager manager = new AfishaManager(11);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

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
    void shouldReturnEmptyAfisha() {
        assertArrayEquals(new Film[0], manager.getLastFilms());
    }
}