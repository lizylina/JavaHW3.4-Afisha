package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;

    @InjectMocks
    private AfishaManager manager;
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
        Film[] returned = new Film[]{};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(first);
        manager.add(first);
        Film[] expected = new Film[]{};
        assertArrayEquals(expected, manager.getLastFilms(10));
    }

    @Test
    void shouldShowLessThanDefault() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Film[] expected = new Film[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, manager.getLastFilms(5));
    }

    @Test
    void shouldShowMoreThanDefault() {
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth,
                eleventh};
        doReturn(returned).when(repository).findAll();
        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, manager.getLastFilms(11));
    }

    @Test
    void shouldGetFilms() {
        Film[] returned = new Film[]{first, second, third};
        doReturn(returned).when(repository).findAll();

        Film[] expected = new Film[]{third, second, first};

        assertArrayEquals(expected, manager.getLastFilms(3));
    }
}

