package ru.netology.manager;

import ru.netology.domain.Film;

public class AfishaManager {
  private Film[] films = new Film[0];
  private int filmsToReturn = 10;

  public AfishaManager() {
  }

  public AfishaManager(int filmsToReturn) {
    this.filmsToReturn = filmsToReturn;
  }

  public void add(Film film) {
    Film[] tmp = new Film[films.length + 1];

    for (int i = 0; i < films.length; i++) {
      tmp[i] = films[i];
    }

    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = film;
    films = tmp;
  }

  public Film[] getLastFilms() {
    int length = filmsToReturn;

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


