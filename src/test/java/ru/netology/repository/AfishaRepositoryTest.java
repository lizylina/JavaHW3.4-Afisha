package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Film;



public class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
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

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    void shouldFindAll() {
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldSave() {
        Film eleventh = new Film(11, "Гренландия", "Боевик", "Image11", false);
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        repository.save(eleventh);
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindById() {
        assertEquals(fourth, repository.findById(4));
        assertNull(repository.findById(11));
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(9);
        Film[] expected = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, tenth};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Film[] expected = new Film[]{};
        assertArrayEquals(new Film[]{}, repository.findAll());

    }
}