package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
  private AfishaRepository repository;
  private int filmsToReturn = 10;

  public AfishaManager(AfishaRepository repository) {
    this.repository = repository;
  }

  public void add(Film film) {
    repository.save (film);
  }

  public Film[] getLastFilms(int filmsToReturn) {
    int length = filmsToReturn;
    Film[] films = repository.findAll();

    if (length > films.length) {
      length = films.length;
    }

    Film[] result = new Film[length];

    for (int i = 0; i < length; i++) {
      int index = films.length - i - 1;
      result[i] = films[index];
    }
    return result;
  }
}


